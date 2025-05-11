<html>
<head>
    <title>Update Successful - IoBay</title>
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
            align-items: center;
            text-align: center;
        }

        h1 {
            font-size: 24px;
            font-weight: 400;
            margin-bottom: 10px;
        }

        .message-box {
            padding: 30px;
            border: 1px solid #ccc;
            border-radius: 20px;
            background-color: #f0fbff;
            max-width: 500px;
        }

        .message-box p {
            font-size: 16px;
            color: #333;
        }

        .edit-btn {
            margin-top: 20px;
            padding: 8px 20px;
            border: 1px solid #008cba;
            border-radius: 20px;
            background-color: #fff;
            font-size: 14px;
            color: #008cba;
            text-decoration: none;
        }

        .edit-btn:hover {
            background-color: #e0f7ff;
        }

    </style>
</head>
<body>
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
            <div class="message-box">
                <h1>Account Updated</h1>
                <p>Your account details have been successfully updated.</p> <br>
                <a href="account.jsp" class="edit-btn">Back to Account</a>
            </div>
        </div>
    </div>
</body>
</html>
