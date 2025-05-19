<%@page import="iotbay.model.User"%>
<%@page import="iotbay.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="iotbay.helper.ProjectConstants"%>

<%
    User user = (User) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER);
    List<Product> cart = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CART);
%>
<header>
    <div class="innerHeader">
        <div class="logoContainer">
            <a href="/">
                <img src="css/iotbayLogo.png" alt="">
            </a>
        </div>

        <div class="menuItems">
            <a class="button" href="">Browse products</a>
            <a href=""><img class="iconButton" id="searchIcon" src="css/searchIcon.svg"></a>

            <img class="iconButton cartIcon" id="cartIcon" src="css/cartIcon.svg">
            <div class="cartMenuWrapper" id="cartMenu">
                <form action="servlet/cart" method="POST" class="cartMenu">
                    <h2 class="cartMenuHeading">Cart</h2>
                    <hr>
                    <% if (cart.isEmpty()) { %>
                        Cart is empty.
                    <% } else { %>
                        <div class="scrollableCartTable">
                            <table class="cartTable">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Quantity</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (Product product : cart) { %>
                                        <tr id="tableRow:<%= product.getProductId() %>">
                                            <td><%= product.getProductName() %></td>
                                            <td><input class="cartQuantityInput" min="1" type="number" name="<%= product.getProductId() %>:quantity" value="<%= product.getQuantity() %>"></td>
                                            <td><button type="button" class="cartRemoveButton" id="removeButton:<%= product.getProductId() %>">x</button></td>
                                            <input type="hidden" name="productId" value="<%= product.getProductId() %>">
                                        </tr>
                                    <% } %>
                                </tbody>
                            </table>
                        </div>
                        <input type="hidden" name="page" value="<%= request.getRequestURI() %>">
                        <div class="cartButtonWrapper">
                            <button class="button smlBtn button-blue" type="submit">Save</button>
                        </div>
                    <% } %>
                </form>
            </div>

            <% if (user != null) { %>
                <img class="iconButton" id="profileIcon" src="css/profileIcon.svg">

                <div class="profileMenuWrapper" id="profileMenu">
                    <form action="servlet/login" method="POST" class="profileMenu">
                        <h2 class="profileMenuUserName"><%= user.getFirstName() %></h2>
                        <hr>
                        <a href="account.jsp">Edit account details</a>
                        <button type="submit">Logout</button>
                    </form>
                </div>
            <% } else { %>
                <a class="button med-btn" href="login.jsp">Log in</a>
                <a class="button med-btn button-blue" href="register.jsp">Create account</a>
            <% } %>
        </div>
    </div>
</header>
<script src="js/headerMenu.js"></script>