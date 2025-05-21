<!DOCTYPE html>
<html>
    <head>
        <title>Manage Account - IoTBay</title>
        <link rel="stylesheet" href="css/index.css">
        <link rel="shortcut icon" href="css/iotbayIcon.ico">
        <style>
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
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="contentWrapper">
            <h1>Manage Your Account</h1>
            <hr>

            <div class="accountContent">
                <div class="sidebar">
                    <a href="manageAccount.jsp" class="button lrgBtn button-blue">Account</a>
                    <a href="" class="button lrgBtn">Orders</a>
                </div>

                <div class="account-section">
                    <%-- To be updated to servlet url --%>
                    <form action="ManageAccountController.java" method="POST" class="section-box">
                        <h2>Personal Information</h2>

                        <label for="firstName" class="inputHeading"><strong>First Name</strong></label><br>
                        <input type="text" name="firstName" id="firstName" class="inputField" required><br><br>

                        <label for="lastName" class="inputHeading"><strong>Last Name</strong></label><br>
                        <input type="text" name="lastName" id="lastName" class="inputField" required><br><br>

                        <label for="email" class="inputHeading"><strong>Email</strong></label><br>
                        <input type="email" name="email" id="email" class="inputField" required><br><br>

                        <button type="submit" class="button med-btn button-blue">Update</button>
                    </form>

                    <hr>

                    <form action="updateAccount.jsp" method="POST" class="section-box">
                        <h2>Change Password</h2>

                        <label for="currentPassword" class="inputHeading"><strong>Current Password</strong></label><br>
                        <input type="password" name="currentPassword" id="currentPassword" class="inputField"><br><br>

                        <label for="newPassword" class="inputHeading"><strong>New Password</strong></label><br>
                        <input type="password" name="newPassword" id="newPassword" class="inputField"><br><br>

                        <button type="submit" class="button medBtn button-blue">Update Password</button>
                        <a href="account.jsp" class="button medBtn">Cancel</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>