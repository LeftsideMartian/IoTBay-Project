<%@page import="iotbay.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="iotbay.helper.ProjectConstants"%>
<%@page import="iotbay.service.ProductService"%>
<%@page import="java.sql.Connection"%>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <link rel="shortcut icon" href="css/iotbayIcon.ico">
        <title>Manage products</title>

        <style>
            body {
                background-color: #ffffff;
            }

            header {
                position: sticky;
                top: 0;
                left: 0;
                right: 0;
                z-index: 1000;
            }

            .gridContainer {
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }

            .contentWrapper {
                flex: 1;
                padding: 40px;
                display: flex;
                flex-direction: column;
                align-items: flex-start;
            }

            hr {
                border: 0;
                height: 1px;
                background: #ccc;
                margin-bottom: 30px;
                width: 100%;
            }

            .productsContent {
                display: flex;
                gap: 40px;
                width: 100%;
                max-width: 1200px; 
            }

            .sidebar {
                display: flex;
                flex-direction: column;
                gap: 20px;
                min-width: 150px;
                border-right: 1px solid #ccc;
                padding-right: 30px; 
            }

            .product-section {
                flex-grow: 1;
                padding-left: 40px; 
            }
        </style>
    </head>
    <body>
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

        <%
            List<Product> products = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_PRODUCT_LIST);
        %>
        <div class="gridContainer">
            <jsp:include page="header.jsp"/>
            
            <div class="contentWrapper">
                <h1>Manage Product</h1>
                <hr>

                <div class="productsContent">
                    <div class="sidebar">
                        <a href="manageAccount.jsp" class="button lrgBtn">Account</a>
                        <a href="vieworders.jsp" class="button lrgBtn">Orders</a>
                        <a href="/servlet/manageProducts" class="button lrgBtn button-blue">Products</a>
                    </div>

                    <div class="product-section">
                        <div class="manageStockTableWrapper">
                            <div class="scrollableTable">
                                <form method="POST" action="/servlet/manageProducts">
                                    <table class="manageStockTable">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Category</th>
                                                <th>Price</th>
                                                <th>Stock</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (Product product : products) { %>
                                                <tr>
                                                    <td><%=product.getProductName()%></td>
                                                    <td><%=product.getCategory()%></td>
                                                    <td>$<%=String.format("%.2f", product.getPrice())%></td>
                                                    <td><%=product.getQuantity()%></td>
                                                    <td><button class="button smlBtn" name="productId" value="<%=product.getProductId()%>">View</button></td>
                                                </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
