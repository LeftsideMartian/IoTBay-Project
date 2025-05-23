<html>
<head>
    <title>View Orders - IoBay</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="shortcut icon" href="css/iotbayIcon.ico">
    <style>
        body {

            background-color: #ffffff;
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

        header {
                position: sticky;
                top: 0;
                left: 0;
                right: 0;
                z-index: 1000;
        }

        hr {
            border: 0;
            height: 1px;
            background: #ccc;
            margin-bottom: 30px;
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
    <div class="gridContainer">
        <jsp:include page="header.jsp"/>
        

        <div class="contentWrapper">
            <h1>View Orders</h1>
            <hr>
            <div class="ordersContent">
                <div class="sidebar">
                    <a href= "manageAccount.jsp" class="button lrgBtn">Account</a>
                    <a href= "vieworders.jsp" class="button lrgBtn button-blue">Orders</a>
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