<%@ page import="java.util.List" %>
<%@ page import="iotbay.model.Product" %>

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
    <jsp:include page="header.jsp" />

    <h1>BROWSE PRODUCTS</h1>
    
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
