<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String cancelledOrderId = request.getParameter("cancelledOrderId");
    String searchTerm = request.getParameter("orderSearch");
    if (searchTerm == null) searchTerm = ""; // avoid null pointer
%>
<!DOCTYPE html>
<html>
<head>
    <title>View Orders - IoTBay</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="shortcut icon" href="css/iotbayIcon.ico">
    <style>
        /* Your existing CSS here */
        body {
            background-color: #ffffff;
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
        .accountContent {
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
        .account-section {
            flex-grow: 1;
            padding-left: 40px;
        }
        .section-box {
            margin-bottom: 30px;
        }
        .section-box h2 {
            font-size: 18px;
            margin-bottom: 10px;
            color: #333;
        }
        .section-box p {
            margin: 5px 0;
            font-size: 14px;
            color: #555;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
            margin-top: 20px;
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
            text-decoration: none;
            display: inline-block;
        }
        .view-btn:hover {
            background-color: #f0fbff;
        }
        #orderSearch {
            margin-bottom: 20px;
            padding: 8px 14px;
            border-radius: 8px;
            border: 1px solid #ccc;
            width: 300px;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="contentWrapper">
    <h1>View Orders</h1>
    <hr>

    <div class="accountContent">
        <div class="sidebar">
            <a href="manageAccount.jsp" class="button lrgBtn">Account</a>
            <a href="vieworders.jsp" class="button lrgBtn button-blue">Orders</a>
        </div>

        <div class="account-section">
            <div class="section-box">
                <h2>Your Recent Orders</h2>

                <!-- Search form without submit button -->
                <form method="get" action="vieworders.jsp" style="margin-bottom:20px;">
                    <input
                        type="text"
                        name="orderSearch"
                        id="orderSearch"
                        placeholder="Search by Order #"
                        value="<%= searchTerm %>"
                        style="padding:8px 14px; border-radius:8px; border:1px solid #ccc; width:300px; font-size:14px;"
                        autocomplete="off"
                    />
                </form>

                <table>
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Order #</th>
                        <th>Total</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        String[][] orders = {
                                {"2025-05-21", "ORD1001", "$150", "Processing"},
                                {"2025-05-22", "ORD1002", "$85", "Shipped"},
                                {"2025-05-23", "ORD1003", "$230", "Delivered"}
                        };

                        for (String[] order : orders) {
                            String date = order[0];
                            String orderNum = order[1];
                            String total = order[2];
                            String status = order[3];

                            if (orderNum.equals(cancelledOrderId)) {
                                status = "Cancelled";
                            }

                            if (orderNum.toUpperCase().contains(searchTerm.toUpperCase())) {
                    %>
                    <tr>
                        <td><%= date %></td>
                        <td><%= orderNum %></td>
                        <td><%= total %></td>
                        <td><%= status %></td>
                        <td>
                        <a class="view-btn" href="orderdetails.jsp?orderId=<%= orderNum %>&status=<%= status %>&date=<%= date %>&total=<%= total %>">
                         View
                        </a>
                        </td>

                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
