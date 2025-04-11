<%@page import="iotbay.model.User"%>
<html>
    <head>
        <title>Home Page</title>
        <link rel="stylesheet" href="css/index.css">
        <script src="js/headerComponents.js"></script>
    </head>

    <body>
        <% session.invalidate(); %>

        <div class="gridContainer">
            <logged-out-header></logged-out-header>
            <div class="contentWrapper">
                <div class="centerContent">
                    <a href="index.jsp">Return to home page</a>
                </div>
            </div>
        </div>
        <script src="js/profileMenu.js"></script>
    </body>
</html>