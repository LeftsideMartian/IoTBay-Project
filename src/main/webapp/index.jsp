<%@page import="iotbay.model.User"%>
<html>
    <head>
        <title>Home Page</title>
        <link rel="stylesheet" href="css/index.css">
    </head>

    <body>
        <div class="gridContainer">
            <header>
                <div class="innerHeader">
                    <div class="logoContainer">
                        <a href="index.jsp">
                            <img src="css/iotbayLogo.png" alt="">
                        </a>
                    </div>
        
                    <div class="menuItems">
                        <a class="button" href="">Browse products</a> <!-- HREF NEEDS UPDATING HERE -->
                        <a class="button" href="login.jsp">Log in</a>
                        <a class="button button-blue" href="register.jsp">Create account</a>
                    </div>
                </div>
            </header>

            <div class="contentWrapper">
                <div class="centerContent">
                    <% 
                      User user = (User)session.getAttribute("user");

                      if (user != null) {
                    %>
                        <h1 class="welcomeText">
                            You are logged in as <%= user.getName() %> <<%= user.getEmail() %>> <br>
                        </h1>
                        <a href="logout.jsp">Logout</a>
                    <% } else { %>
                        <h1 class="mainHeading" >Your leading IoT distributor</h1>
                        <img class="mainImage" src="css/tempImage.jpg" alt="">
                        <a class="button" href="register.jsp">Get started</a>
                    <% } %>

                </div>
            </div>
        </div>
    </body>
</html>
