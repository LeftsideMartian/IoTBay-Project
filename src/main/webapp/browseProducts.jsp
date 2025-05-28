<%@ page import="java.util.List" %>
<%@ page import="iotbay.model.Product" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Browse Products - IoTBay</title>
    <link rel="stylesheet" href="css/index.css" />
    <script>
        function addToCart(productId) {
            const body = new URLSearchParams();
            body.append('productId', productId);
            body.append('quantity', 1);

            fetch('<%= request.getContextPath() %>/CartController', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: body.toString()
            })
            .then(response => response.text())
            .then(text => {
                console.log("Server response:", text);
                try {
                    const data = JSON.parse(text);
                    if (data.status === 'success') {
                        alert("Product added to cart!");
                    } else {
                        alert("Failed to add product to cart: " + (data.message || ""));
                    }
                } catch (e) {
                    alert("Unexpected response: " + text);
                }
            })
            .catch(error => {
                console.error("Error adding product to cart:", error);
                alert("An error occurred. Please try again.");
            });
        }
    </script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9fbfd;
            margin: 0;
            padding: 0;
        }
        .main-content {
            padding: 20px;
            max-width: 1200px;
            margin: 0 auto;
        }
        .products {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
            gap: 20px;
        }
        .product-card {
            background-color: white;
            padding: 10px;
            border: 1px solid #e0e0e0;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            border-radius: 8px;
        }
        .product-card .image-placeholder {
            background-color: #f0f4f8;
            height: 150px;
            margin-bottom: 10px;
        }
        .add-to-cart {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            margin-top: 10px;
            border-radius: 4px;
        }
        .add-to-cart:hover {
            background-color: #0056b3;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />

<h1>Browse Products</h1>

<div class="main-content">
    <main class="products">
        <%
            List<Product> productList = (List<Product>) session.getAttribute("productList");
            if (productList == null || productList.isEmpty()) {
        %>
            <p style="grid-column: 1 / -1; text-align: center;">No products found.</p>
        <%
            } else {
                for (Product product : productList) {
        %>
            <div class="product-card">
                <div class="image-placeholder">
                    <span>Image</span>
                </div>
                <strong><%= product.getProductName() %></strong>
                <div>$<%= String.format("%.2f", product.getPrice()) %></div>
                <p><%= product.getDescription() %></p>
                <button type="button" class="add-to-cart" onclick="addToCart(<%= product.getProductId() %>)">Add to Cart</button>
            </div>
        <%
                }
            }
        %>
    </main>
</div>

</body>
</html>
