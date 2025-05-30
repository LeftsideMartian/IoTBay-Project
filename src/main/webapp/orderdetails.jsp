<%@ page import="java.util.*" %>
<%
    String orderId = request.getParameter("orderId");
    String email = request.getParameter("email");
    String date = request.getParameter("date");
    String action = request.getParameter("action");
    String status = request.getParameter("status");

    // Default values to avoid nulls
    if (email == null || email.isEmpty()) {
        email = "customer@example.com";
    }
    if (date == null || date.isEmpty()) {
        date = "2025-05-30";
    }

    // Update status if cancelled
    if ("confirmCancel".equals(action)) {
        status = "Cancelled";
    } else if (status == null || status.isEmpty()) {
        status = "Processing";
    }

    class Product {
        String name;
        int qty;
        double price;

        Product(String name, int qty, double price) {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        double subtotal() {
            return qty * price;
        }
    }

    List<Product> products = new ArrayList<>();

    if ("ORD1001".equals(orderId)) {
        products.add(new Product("Wireless Mouse", 2, 25));
        products.add(new Product("Mechanical Keyboard", 1, 100));
    } else if ("ORD1002".equals(orderId)) {
        products.add(new Product("USB-C Cable", 3, 10));
        products.add(new Product("Laptop Stand", 1, 55));
    } else if ("ORD1003".equals(orderId)) {
        products.add(new Product("Gaming Headset", 2, 100));
        products.add(new Product("Mousepad", 1, 30));
    }

    double total = 0;
    for (Product p : products) total += p.subtotal();
%>


<!DOCTYPE html>
<html>
<head>
    <title>Order Details - <%= orderId %></title>
    <link rel="stylesheet" href="css/index.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        .modal-content {
            background-color: #fff;
            margin: 0 auto;
            padding: 30px 40px;
            border-radius: 15px;
            width: 80%;
            max-width: 700px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.25);
        }
        .modal-header {
            display: flex;
            align-items: center;
            gap: 14px;
            margin-bottom: 25px;
        }
        .modal-header img {
            width: 40px;
            height: 40px;
        }
        .modal-header-text span {
            display: block;
        }
        .modal-header-text #modal-order-number {
            font-weight: 700;
            font-size: 22px;
        }
        .modal-header-text #modal-email,
        .modal-header-text #modal-order-date {
            font-size: 14px;
            color: #555;
        }
        .order-info-box {
            border: 1px solid #ddd;
            border-radius: 12px;
            padding: 20px 25px;
            background: #fafafa;
            margin-bottom: 25px;
        }
        .receipt-table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 10px;
        }
        .receipt-table th {
            text-align: left;
            font-weight: 700;
            font-size: 16px;
            padding-bottom: 12px;
            border-bottom: 2px solid #008cba;
            color: #008cba;
        }
        .receipt-table td {
            background: white;
            padding: 14px 18px;
            font-size: 15px;
            border-radius: 10px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
        }
        .receipt-table td.qty,
        .receipt-table td.price,
        .receipt-table td.subtotal {
            text-align: right;
            font-variant-numeric: tabular-nums;
        }
        .receipt-total-row td {
            border-top: 2px solid #008cba;
            font-weight: 700;
            font-size: 17px;
            background: #f0fcff;
        }
        .modal-buttons {
            margin-top: 28px;
            display: flex;
            justify-content: flex-end;
            gap: 10px;
        }
        .modal-action-btn {
            padding: 10px 26px;
            border: none;
            border-radius: 25px;
            font-size: 14px;
            font-weight: 600;
            cursor: pointer;
        }
        .cancel-btn {
            background-color: #fff4e5;
            color: #ff9900;
        }
        .cancel-btn:hover {
            background-color: #ffe7b3;
        }
        .go-back-btn {
            background-color: #008cba;
            color: white;
        }
        .go-back-btn:hover {
            background-color: #0077a3;
        }
        .status-label {
            display: inline-block;
            padding: 6px 12px;
            border-radius: 10px;
            font-size: 14px;
            font-weight: 600;
            margin-top: 10px;
        }
        .confirm-text {
            font-size: 16px;
            margin: 20px 0;
        }
    </style>
</head>
<body>

<div class="modal-content">
    <div class="modal-header">
        <img src="https://cdn-icons-png.flaticon.com/512/1170/1170678.png" alt="Shopping Cart Icon" />
        <div class="modal-header-text">
            <span id="modal-order-number"><%= orderId != null ? orderId : "N/A" %></span>
            <span id="modal-email"><%= email %></span>
            <span id="modal-order-date"><%= date %></span>
            <span class="status-label"><%= status %></span>
        </div>
    </div>

    <% if ("confirm".equals(action)) { %>
        <p class="confirm-text">Are you sure you want to cancel this order?</p>
        <div class="modal-buttons">
            <form method="get">
                <input type="hidden" name="orderId" value="<%= orderId %>"/>
                <input type="hidden" name="email" value="<%= email %>"/>
                <input type="hidden" name="date" value="<%= date %>"/>
                <input type="hidden" name="action" value="confirmCancel"/>
                <button type="submit" class="modal-action-btn cancel-btn">Yes, Cancel</button>
            </form>
            <form action="vieworders.jsp" method="get">
                <button type="submit" class="modal-action-btn go-back-btn">No, Go Back</button>
            </form>
        </div>
    <% } else if ("confirmCancel".equals(action)) { %>
        <p class="confirm-text" style="color: #cc0000;">Order has been cancelled.</p>
        <div class="modal-buttons">
            <form action="vieworders.jsp" method="get">
                <input type="hidden" name="cancelledOrderId" value="<%= orderId %>" />
                <button type="submit" class="modal-action-btn go-back-btn">Go Back to Orders</button>
            </form>
        </div>
    <% } else { %>
        <div class="order-info-box">
            <table class="receipt-table">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Qty</th>
                        <th>Price</th>
                        <th>Subtotal</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Product p : products) { %>
                        <tr>
                            <td><%= p.name %></td>
                            <td class="qty"><%= p.qty %></td>
                            <td class="price">$<%= String.format("%.2f", p.price) %></td>
                            <td class="subtotal">$<%= String.format("%.2f", p.subtotal()) %></td>
                        </tr>
                    <% } %>
                </tbody>
                <tfoot>
                    <tr class="receipt-total-row">
                        <td colspan="3">Total</td>
                        <td>$<%= String.format("%.2f", total) %></td>
                    </tr>
                </tfoot>
            </table>
        </div>

        <div class="modal-buttons">
            <% if (!"Cancelled".equals(status)) { %>
                <form method="get">
                    <input type="hidden" name="orderId" value="<%= orderId %>"/>
                    <input type="hidden" name="email" value="<%= email %>"/>
                    <input type="hidden" name="date" value="<%= date %>"/>
                    <input type="hidden" name="status" value="<%= status %>"/>
                    <input type="hidden" name="action" value="confirm"/>
                    <button type="submit" class="modal-action-btn cancel-btn">Cancel Order</button>
                </form>
            <% } %>
            <form action="vieworders.jsp" method="get">
                <button type="submit" class="modal-action-btn go-back-btn">Go Back to Orders</button>
            </form>
        </div>
    <% } %>
</div>

</body>
</html>
