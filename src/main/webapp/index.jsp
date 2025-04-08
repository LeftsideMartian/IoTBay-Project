<%@page import="iotbay.model.User"%>
<html>
    <head>
        <title>Home Page</title>
        <link rel="stylesheet" href="css/index.css">
        <script src="js/headerComponents.js"></script>
    </head>

    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>

        <div class="gridContainer">
            <% if (user != null) { %>
                <logged-in-header></logged-in-header>
            <% } else { %>
                <logged-out-header></logged-out-header>
            <% } %>

            <div class="contentWrapper">
                <div class="centerContent">
                    <% if (user != null) { %>
                        <h1 class="welcomeText">
                            You are logged in as <%= user.getName() %> <<%= user.getEmail() %>> <br>
                        </h1>
                    <% } else { %>
                        <h1 class="mainHeading" >Your leading IoT distributor</h1>
                        <img class="mainImage" src="css/tempImage.jpg" alt="">
                        <a class="button" href="register.jsp">Get started</a>
                    <% } %>
                </div>
            </div>
        </div>
        <script src="js/profileMenu.js"></script>
    </body>
</html>
