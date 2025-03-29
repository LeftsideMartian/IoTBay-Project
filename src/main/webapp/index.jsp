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
                      String wasSubmittedString = request.getParameter("wasSubmitted");

                      if (wasSubmittedString != null && wasSubmittedString.equals("yes")) {
                    %>
                        <h1 class="welcomeText">
                            Welcome <%= request.getParameter("firstName") %> <%= request.getParameter("lastName") %>! <br>
                            Your email is <%= request.getParameter("email") %>! <br>
                            Your Password is <%= request.getParameter("password") %>!
                        </h1>
                    <% } else { %>
                        <h1 class="mainHeading" >Your leading IoT distributor</h1>
                        <a class="button" href="register.jsp">Get started</a>
                    <% } %>

                    <img class="mainImage" src="css/tempImage.jpg" alt="">
                </div>
            </div>
        </div>
    </body>
</html>
