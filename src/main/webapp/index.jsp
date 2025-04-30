<%@page import="iotbay.model.User"%>
<html>
    <head>
        <title>Home Page</title>
        <link rel="stylesheet" href="css/index.css">
    </head>

    <body>
        <% User user = (User) session.getAttribute("user"); %>

        <div class="gridContainer">
            <jsp:include page="header.jsp"/>

            <div class="contentWrapper">
                <div class="centerContent mainContentWrapper">
                    <% if (user != null) { %>
                        <h1 class="welcomeText">
                            You are logged in as <%= user.getName() %> <<%= user.getEmail() %>> <br>
                            Click the profile icon to log out.
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
        <jsp:include page="/servlet/dbConnection" flush="true" />
    </body>
</html>
