<html>
<head>
    <title>View Orders - IoBay</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="shortcut icon" href="css/iotbayIcon.ico">
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: #ffffff;
        }

        .gridContainer {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .headerBar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 40px;
            background-color: #f5fafd;
            border-bottom: 1px solid #ccc;
            margin-bottom: 0; 
        }

        .logo {
            height: 80px;
            width: 110px; 
        }

        .topLinks {
            display: flex;
            gap: 20px;
            align-items: center;
        }

        .topLinks a, .topLinks img {
            font-size: 14px;
            padding: 8px 12px;
            border-radius: 20px;
            border: 1px solid #ccc;
            text-decoration: none;
            color: #333;
        }

        .topLinks a:hover, .topLinks img:hover {
            background-color: #e0f7ff;
        }

        .topLinks img {
            width: 20px;
            height: 20px;
            cursor: pointer;
        }

        .contentWrapper {
            flex: 1;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: flex-start;
        }

        h1 {
            font-size: 24px;
            font-weight: 400;
            margin-bottom: 10px;
        }

        hr {
            border: 0;
            height: 1px;
            background: #ccc;
            width: 100%;
        }

        .ordersContent {
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

        .side-btn {
            border: 1px solid black;
            padding: 10px 25px;
            border-radius: 20px;
            background-color: #fff;
            font-size: 16px;
            font-weight: 500;
            cursor: pointer;
            transition: all 0.2s ease-in-out;
        }

        .side-btn:hover,
        .side-btn.active {
            background-color: #e0f7ff;
            font-weight: 600;
            color: #008cba;
        }

        .orders-table {
            flex-grow: 1;
            padding-left: 40px; 
        }

        table {
            width: 100%;
            max-width: 100%; 
            border-collapse: collapse;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
            background-color: white;
        }

        thead {
            background-color: #f5fafd;
        }

        th, td {
            padding: 14px 16px;
            text-align: left;
            font-size: 14px;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .view-btn {
            padding: 5px 15px;
            border: 1px solid #008cba;
            border-radius: 20px;
            background-color: #fff;
            cursor: pointer;
            font-size: 14px;
            color: #008cba;
        }

        .view-btn:hover {
            background-color: #f0fbff;
        }

    </style>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="gridContainer">
        <div class="headerBar">
            <img class="logo" src="css/iotbayIcon.ico" alt="IoTBay Logo">
            <div class="topLinks">
                <a href="index.jsp" class="browseBtn">Browse Products</a>
                <img src="css/accountIcon.png" alt="Account" />
                <img src="css/searchIcon.png" alt="Search" />
            </div>
        </div>

        <div class="contentWrapper">
            <h1>View Orders</h1>
            <hr>
            <div class="ordersContent">
                <div class="sidebar">
                    <button class="side-btn">Account</button>
                    <button class="side-btn active">Orders</button>
                </div>
                <div class="orders-table">
                    <table>
                        <thead>
                            <tr>
                                <th>Date</th>
                                <th>Order #</th>
                                <th>No. Products</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Date</td>
                                <td>Order #</td>
                                <td>No. Products</td>
                                <td>Total</td>
                                <td><button class="view-btn">View</button></td>
                            </tr>
                            <tr>
                                <td>Date</td>
                                <td>Order #</td>
                                <td>No. Products</td>
                                <td>Total</td>
                                <td><button class="view-btn">View</button></td>
                            </tr>
                            <tr>
                                <td>Date</td>
                                <td>Order #</td>
                                <td>No. Products</td>
                                <td>Total</td>
                                <td><button class="view-btn">View</button></td>
                            </tr>
                            <tr>
                                <td>Date</td>
                                <td>Order #</td>
                                <td>No. Products</td>
                                <td>Total</td>
                                <td><button class="view-btn">View</button></td>
                            </tr>
                            <tr>
                                <td>Date</td>
                                <td>Order #</td>
                                <td>No. Products</td>
                                <td>Total</td>
                                <td><button class="view-btn">View</button></td>
                            </tr>
                            <tr>
                                <td>Date</td>
                                <td>Order #</td>
                                <td>No. Products</td>
                                <td>Total</td>
                                <td><button class="view-btn">View</button></td>
                                    
                            </tr>
                            <tr>
                                <td>Date</td>
                                <td>Order #</td>
                                <td>No. Products</td>
                                <td>Total</td>
                                <td><button class="view-btn">View</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>