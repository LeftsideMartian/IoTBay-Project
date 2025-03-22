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
                        <a href="index.html">
                            <img src="css/iotbayLogo.png" alt="">
                        </a>
                    </div>
        
                    <div class="menuItems">
                        <a class="button" href="">Browse products</a> <!-- HREF NEEDS UPDATING HERE -->
                        <a class="button" href="login.jsp">Log in</a>
                        <a class="button" href="register.jsp">Create account</a>
                    </div>
                </div>
            </header>

            <div class="contentWrapper">
                <div class="centerContent">
                    <h1 class="mainHeading" >Your leading IoT distributor</h1>

                    <% 
                      String wasSubmittedString = request.getParameter("wasSubmitted");

                      if (wasSubmittedString != null && wasSubmittedString.equals("yes")) {
                    %>
                      <h1>Welcome <%= request.getParameter("firstName") %> <%= request.getParameter("lastName") %>!</h1>
                      <h1> Your email is <%= request.getParameter("email") %>!</h1>
                      <h1> Your Password is <%= request.getParameter("password") %>!</h1>
                    <% } %>

                    <img class="mainImage" src="css/tempImage.jpg" alt="">
                    <a class="button" href="register.jsp">Get started</a>
                </div>
            </div>
        </div>
    </body>
</html>
