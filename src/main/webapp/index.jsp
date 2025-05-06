<%@page import="iotbay.model.User"%>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <link rel="shortcut icon" href="css/iotbayIcon.ico">
        <title>Home Page</title>
    </head>

    <body>
        <% User user = (User) session.getAttribute("user"); %>

        <div class="gridContainer">
            <jsp:include page="header.jsp"/>

            <div class="contentWrapper">
                <div class="centerContent">
                    <div class="indexContentWrapper">
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
        </div>
        <jsp:include page="/servlet/dbConnection" flush="true" />
    </body>
</html>
