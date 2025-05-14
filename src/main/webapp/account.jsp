<html>
<head>
    <title>Manage Your Account - IoBay</title>
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

        .edit-btn {
            margin-top: 10px;
            padding: 5px 15px;
            border: 1px solid #008cba;
            border-radius: 20px;
            background-color: #fff;
            cursor: pointer;
            font-size: 14px;
            color: #008cba;
            text-decoration: none;
        }

        .edit-btn:hover {
            background-color: #f0fbff;
        }
        
        .formHeading {
        
            margin: 5px 0;
            font-size: 14px;
            color: #555;
            }
        
        .inputField {
            font-size: 12px;
            color: #555;
        }

    </style>
</head>
<body>
    <jsp:include page="header.jsp"/>

        <div class="contentWrapper">
            <h1>Manage Your Account</h1>
            <hr>
            <div class="accountContent">
                <div class="sidebar">
                    <button class="side-btn active">Account</button>
                    <button class="side-btn">Orders</button>
                </div>
                <div class="account-section">
                    <div class="section-box">
                        <h2>Personal Information</h2>
						<label for = "firstName" class = "formHeading"><strong> First Name </strong></label> <br>
                		<input type="text" name= "firstName" id="firstName" class = "inputField"requried><br><br>
                        <label for = "lastName" class = "formHeading"><strong> Last Name </strong></label>
                        <br>
                        <input type="text" name= "lastName" id="lastName" class = "inputField" requried><br><br>
                		<label for = "email" class = "formHeading"><strong>Email </strong></label><br>
                		<input type="email" name= "email" id="email" class = "inputField" requried><br><br>
                        <a href="updateAccount.jsp" class="edit-btn">Update</a>
                    </div>
                    <hr>
                    <div class="section-box">
                        <h2>Change Password</h2>
                        <label for = "currentPassword" class = "formHeading"><strong>Current Password</strong></label><br>
                <input type="password" name= "currentPassword" id="currentPassword" class = "inputField"><br><br>

                <label for = "newPassword" class = "formHeading"><strong>New Password</strong></label><br>
                <input type="password" name= "newPassword" id="newPassword" class = "inputField"><br><br>

                        <a href="updateAccount.jsp" class="edit-btn">Update Password</a>
                        <a href="account.jsp" class="edit-btn">Cancel</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
