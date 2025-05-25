<%@ page import="iotbay.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="iotbay.helper.ProjectConstants" %>
<%@ page import="iotbay.model.User" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="css/index.css">
        <link rel="shortcut icon" href="css/iotbayIcon.ico">
        <title>Checkout - IoTBay</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700&display=swap');

            body {
                background-color: #f2f8fc;
                padding: 0px;
            }

            body div.placeOrderFlexBox {
                padding: 20px;
                display: flex;
                gap: 2rem; 
                flex-wrap: wrap; 
                justify-content: center; 
            }

            header {
                position: sticky;
                top: 0;
                left: 0;
                right: 0;
                z-index: 1000;
            }

            .summary {
                padding: 1em 1.5em;
                border-radius: 25px;
                filter: drop-shadow(
                1px 2px 2px rgb(197, 197, 197)
                );
                background-color: #fff;
                width: 40rem;
            }

            .summaryHeading {
                font-size: clamp(1rem, 3vw, 1.5rem);
                font-weight: 700;
                padding: 1rem;
            }

            .placeOrderTable {
                width: 100%;
                border-spacing: 0rem 0rem;
            }

            .formWrapper {
                margin-top: 2rem;
                background-color: #fff;
                padding: 2rem;
                border-radius: 25px;
                filter: drop-shadow(1px 2px 2px rgb(197, 197, 197));
                width: 42rem; 
                box-sizing: border-box;
            }

            .formSection {
                display: flex;
                gap: 1rem;
                margin-bottom: 1rem;
            }

            .inputSection {
                flex: 1;
            }

            .inputField {
                width: 100%;
                padding: 0.75rem;
                margin-bottom: 1rem;
                border-radius: 10px;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            .inputHeading, .formHeading {
                display: block;
                margin-top: 1rem;
                margin-bottom: 0.5rem;
                font-weight: 600;
            }

            th, td {
                padding: 1rem 1rem 1rem 0rem;
                text-align: left;
            }

            th {
                background-color: #fff;
                position: sticky;
                top: 0;
                z-index: 1;
                padding-top: 0;
                margin-top: 0;
            }

            td:last-child {
                text-align: right;
            }

            .tableContainer {
                max-height: 300px;
                overflow-y: auto;
                margin-top: 10px;
            }

            .buttons {
                margin-top: 20px;
                display: flex;
                justify-content: space-evenly;
            }

            strong {
                font-size: 0.9rem;
                font-weight: 700;
                margin-bottom: 0.2rem;
            }

            .totalHeading {
                text-align: right;
            }
        </style>
    </head>

    <body>
        <%
            User user = (User) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER);
            List<Product> cart = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART);
        %>
        <jsp:include page="header.jsp"/>

        <div class="placeOrderFlexBox">
            <%
                String successMessage = (String) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE);
                String errorMessage = (String) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR);
                if (successMessage != null) {
                    session.removeAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE);
            %>
                <div class="popup"><%= successMessage %></div>
            <% } else if (errorMessage != null) {
                session.removeAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR);
            %>
                <div class="popup errorMessage"><%= errorMessage %></div>
            <% } %>

            <div class="">
                <h1>Checkout</h1>
                <div class="summary">
                    <h3>Summary</h3>
                    <div class="tableContainer">
                        <table class="placeOrderTable">
                            <thead>
                                <tr>
                                    <th>Item</th>
                                    <th>Price</th>
                                    <th>Qty</th>
                                    <th class="totalHeading">Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    double subtotal = 0.0;
                                    if (cart != null && !cart.isEmpty()) {
                                        for (Product product : cart) {
                                            double itemTotal = product.getPrice() * product.getQuantity();
                                            subtotal += itemTotal;
                                %>
                                            <tr>
                                                <td><%= product.getProductName() %></td>
                                                <td>$<%= String.format("%.2f", product.getPrice()) %></td>
                                                <td><%= product.getQuantity() %></td>
                                                <td>$<%= String.format("%.2f", itemTotal) %></td>
                                            </tr>
                                <%
                                        }
                                    } else {
                                %>
                                        <tr>
                                            <td colspan="4">Cart is empty.</td>
                                        </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                    <%
                        double shipping = (subtotal > 0) ? 20.0 : 0.0;
                        double total = subtotal + shipping;
                    %>
                    <hr>
                    <p><em>Subtotal</em>: $<%= String.format("%.2f", subtotal) %></p>
                    <p><em>Shipping</em>: $<%= String.format("%.2f", shipping) %></p>
                    <p><strong>Total</strong>: $<%= String.format("%.2f", total) %></p>
                </div>
            </div>
        

            <form id="checkout-form" method="POST" action="/placeOrder">
                <div class="formWrapper">
                    <label class="formHeading">Personal Information</label>
                    <div class="formSection">
                        <% if (user != null) { %>
                            <div class="inputSection">
                                <input class="inputField" type="text" placeholder="First Name" name="firstName" value="<%= user.getFirstName() %>" disabled />
                            </div>
                            <div class="inputSection">
                                <input class="inputField" type="text" placeholder="Last Name" name="lastName" value="<%= user.getLastName() %>" disabled />
                            </div>
                        <% } else { %>
                            <div class="inputSection">
                                <input class="inputField" type="text" placeholder="First Name" name="firstName" required />
                            </div>
                            <div class="inputSection">
                                <input class="inputField" type="text" placeholder="Last Name" name="lastName" required />
                            </div>
                        <% } %>
                    </div>

                    <label class="inputHeading"><strong>Delivery Address</strong></label>
                    <input class="inputField" type="text" placeholder="Address" name="address" required />

                    <label class="inputHeading"><strong>Credit Card Info</strong></label>
                    <input class="inputField" type="text" placeholder="Card Number" name="cardNumber" required />

                    <div class="buttons">
                        <button type="button" class="button" onclick="cancelOrder()">Cancel Order</button>
                        <button type="submit" class="button button-blue">Place Order</button>
                    </div>
                </div>
            </form>
        </div>

        <%-- <script>
            document.getElementById("checkout-form").addEventListener("submit", function (e) {
                e.preventDefault();
                alert("Order placed successfully!");
            });

            function cancelOrder() {
                if (confirm("Are you sure you want to cancel the order?")) {
                    document.getElementById("checkout-form").reset();
                    location.href = "index.jsp"
                }
            }
        </script> --%>
    </body>
</html>