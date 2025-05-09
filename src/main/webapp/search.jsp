<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Search Products</title>
  <style>
    * {
      box-sizing: border-box;
    }

    body {
      font-family: 'Arial', sans-serif;
      background-color: #f2f8fd;
      margin: 0;
      padding: 40px;
    }

    h1 {
      font-weight: 300;
      letter-spacing: 1px;
    }

    p {
      color: #555;
    }

    .container {
      display: flex;
      margin-top: 30px;
    }

    /* Sidebar */
    .sidebar {
      width: 250px;
      background-color: white;
      border: 1px solid #ccc;
      padding: 20px;
      margin-right: 40px;
    }

    .filter-section {
      margin-bottom: 30px;
    }

    .filter-section h3 {
      font-size: 14px;
      font-weight: bold;
      text-transform: uppercase;
      margin-bottom: 10px;
      cursor: pointer;
    }

    .filter-section label {
      display: block;
      margin: 5px 0;
    }

    .price-range {
      display: flex;
      align-items: center;
      justify-content: space-between;
      font-size: 14px;
      margin-bottom: 10px;
    }

    .price-slider {
      width: 100%;
    }

    /* Search Bar */
    .main-content {
      flex: 1;
    }

    .search-bar-wrapper {
      display: flex;
      justify-content: center;
      margin-bottom: 30px;
    }

    .search-bar {
      position: relative;
      width: 100%;
      max-width: 600px;
    }

    .search-bar input[type="text"] {
      width: 100%;
      padding: 14px 50px 14px 50px;
      border-radius: 50px;
      border: 1px solid #000;
      font-size: 16px;
      outline: none;
    }

    .search-icon {
      position: absolute;
      left: 20px;
      top: 50%;
      transform: translateY(-50%);
      font-size: 18px;
      color: #555;
    }

    .search-icon::before {
      content: '🔍';
    }

    /* Product Grid */
    .product-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(160px, 1fr));
      gap: 20px;
    }

    .product-card {
      background-color: #eaf2fa;
      padding: 10px;
      text-align: center;
      border-radius: 8px;
    }

    .product-name {
      font-weight: bold;
      margin-top: 10px;
    }

    .product-price {
      margin: 5px 0;
    }

    .add-to-cart {
      background-color: #f0f3f7;
      border: none;
      padding: 5px 10px;
      border-radius: 6px;
      cursor: pointer;
      font-size: 14px;
    }

    .add-to-cart:hover {
      background-color: #dce6ef;
    }
  </style>
</head>
<body>

  <h1>SEARCH PRODUCTS</h1>

  <div class="container">
    <!-- Sidebar -->
    <div class="sidebar">
      <div class="filter-section">
        <h3>Colour ▾</h3>
        <!-- Color filter items here -->
      </div>
      <div class="filter-section">
        <h3>Features ▾</h3>
        <!-- Feature filter items here -->
      </div>
      <div class="filter-section">
        <h3>Brand</h3>
        <label><input type="checkbox"> Adobe</label>
        <label><input type="checkbox"> Apple</label>
        <label><input type="checkbox"> Dell</label>
        <label><input type="checkbox"> Google</label>
        <label><input type="checkbox"> Microsoft</label>
        <label><input type="checkbox"> Samsung</label>
      </div>
      <div class="filter-section">
        <h3>Price</h3>
        <div class="price-range">
          <span>$3</span>
          <span>$1499</span>
        </div>
        <input type="range" class="price-slider" min="3" max="1499" value="300">
      </div>
    </div>

    <!-- Main Content -->
    <div class="main-content">
      <div class="search-bar-wrapper">
        <div class="search-bar">
          <span class="search-icon"></span>
          <input type="text" placeholder="Search for products...">
        </div>
      </div>

      <div class="product-grid">
        <div class="product-card">
          <div class="product-name">Product A</div>
          <div class="product-price">$100.00</div>
          <button class="add-to-cart">Add to Cart</button>
        </div>
        <div class="product-card">
          <div class="product-name">Product B</div>
          <div class="product-price">$100.00</div>
          <button class="add-to-cart">Add to Cart</button>
        </div>
        <!-- Add more product cards as needed -->
      </div>
    </div>
  </div>

</body>
</html>