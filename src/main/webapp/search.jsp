<%@ page import="java.util.List" %>
<%@ page import="iotbay.model.Product" %>
<%@ page import="iotbay.helper.ProjectConstants" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>Search - IoTBay</title>
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
            }
            .search-bar-wrapper {
                display: flex;
                justify-content: center;
                margin: 20px 0;
            }
            .search-bar {
                width: 60%;
                display: flex;
                align-items: center;
                background-color: white;
                border: 1px solid #ccc;
                border-radius: 30px;
                padding: 10px 20px;
                box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            }
            .search-bar input {
                flex: 1;
                border: none;
                outline: none;
                font-size: 16px;
                padding: 10px;
            }
            .search-icon {
                margin-right: 10px;
                font-size: 18px;
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

        <h1>SEARCH PRODUCTS</h1>

        <div class="search-bar-wrapper">
            <form action="SearchProducts" method="get" class="search-bar">
                <input 
                    type="text" 
                    name="searchTerm" 
                    placeholder="Search for products..." 
                    value="<%= request.getParameter("searchTerm") != null ? request.getParameter("searchTerm") : "" %>" 
                />
                <button type="submit" style="display:none;"></button>
            </form>
        </div>

        <div class="main-content">
            <main class="products">
                <%
                    List<Product> productList = (List<Product>) session.getAttribute("productList");
                    if (productList == null || productList.isEmpty()) {
                %>
                    <p style="padding: 20px;">No products found.</p>
                <%
                    } else {
                        for (Product product : productList) {
                        %>
                            <div class="product-card">
                                <div class="image-placeholder"></div>
                                <strong><%= product.getProductName() %></strong>
                                <div>$<%= String.format("%.2f", product.getPrice()) %></div>
                                <button class="add-to-cart">ADD TO CART</button>
                            </div>
                        <%
                        }
                    }
                %>
            </main>
        </div>
    </body>
</html>
