<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>lolBay - Category 1</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9fbfd;
        }
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            background-color: white;
            border-bottom: 1px solid #e0e0e0;
        }
        .logo {
            display: flex;
            align-items: center;
        }
        .logo img {
            height: 40px;
        }
        .nav-buttons {
            display: flex;
            gap: 10px;
        }
        .nav-buttons button, .nav-buttons .icon {
            background: none;
            border: 1px solid #ddd;
            border-radius: 20px;
            padding: 5px 15px;
            cursor: pointer;
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
    <header>
        <div class="logo">
            <img src="https://via.placeholder.com/100x40?text=lolBay" alt="lolBay Logo">
        </div>
        <div class="nav-buttons">
            <button>Browse products</button>
            <div class="icon">🔍</div>
            <div class="icon">👤</div>
        </div>
    </header>

    <h1>SEARCH PRODUCTS</h1>
    <div class="search-bar-wrapper">
        <div class="search-bar">
            <span class="search-icon">🔍</span>
            <input type="text" placeholder="Search for products...">
        </div>
    </div>

    <div class="main-content">
        <main class="products">
            <div class="product-card">
                <div class="image-placeholder"></div>
                <strong>PRODUCT A</strong>
                <div>$100.00</div>
                <button class="add-to-cart">ADD TO CART</button>
            </div>
            <div class="product-card">
                <div class="image-placeholder"></div>
                <strong>PRODUCT B</strong>
                <div>$600.00</div>
                <button class="add-to-cart">ADD TO CART</button>
            </div>
            <div class="product-card">
                <div class="image-placeholder"></div>
                <strong>PRODUCT C</strong>
                <div>$200.00</div>
                <button class="add-to-cart">ADD TO CART</button>
            </div>
        </main>
    </div>
</body>
</html>
