<%@ page import="java.util.List" %>
<%@ page import="iotbay.model.Product" %>
<%@ page import="iotbay.helper.ProjectConstants" %>
<%@ page import="iotbay.service.ProductService" %>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Browse Products - IoTBay</title>
    <link rel="stylesheet" href="css/index.css" />
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9fbfd;
        }
        header {
            position: sticky;
            top: 0;
        }
        .container {
            display: flex;
            padding: 20px;
        }
        .sidebar {
            width: 200px;
            background-color: white;
            padding: 10px;
            border-right: 1px solid #e0e0e0;
        }
        .sidebar h4 {
            margin: 10px 0;
            cursor: pointer;
        }
        .products {
            flex: 1;
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            gap: 20px;
            padding: 0 20px;
        }
        .product-card {
            background-color: white;
            padding: 10px;
            border: 1px solid #e0e0e0;
            text-align: center;
        }
        .product-card .image-placeholder {
            background-color: #f0f4f8;
            height: 150px;
            margin-bottom: 10px;
        }
        .add-to-cart {
            background-color: #f0f4f8;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        .breadcrumb {
            font-size: 12px;
            margin-bottom: 20px;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 30px;
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

        <jsp:include page="header.jsp" />

        <h1>BROWSE PRODUCTS</h1>
        
        <div class="main-content">
            <main class="products">
                <%
                    Connection connection = (Connection) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION);

                    if (connection == null) {
                        response.sendRedirect(ProjectConstants.HOME_PAGE);
                    }

                    ProductService productService = new ProductService(connection);
                    List<Product> productList = productService.getAllInStockProducts();

                    if (productList == null) {
                        response.sendRedirect(ProjectConstants.HOME_PAGE);
                    } else if (productList.isEmpty()) {
                %>
                    <p style="padding: 20px;">No products found.</p>
                <%
                    } else {
                        for (Product product : productList) {
                %>
                            <form class="product-card" action="BrowseProducts" method="POST">
                                <div class="image-placeholder"></div>
                                <strong><%= product.getProductName() %></strong>
                                <div>$<%= String.format("%.2f", product.getPrice()) %></div>
                                <input type="hidden" name="productId" value="<%= product.getProductId() %>"/>
                                <button class="add-to-cart" type="submit">ADD TO CART</button>
                            </form>
                <%
                        }
                    }
                %>
            </main>
        </div>
    </body>
</html>