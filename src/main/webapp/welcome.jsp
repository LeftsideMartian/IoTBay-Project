<%@page import="iotbay.model.User"%>
<html>
    <head>
        <title>Welcome Page</title>
        <link rel="stylesheet" href="css/index.css">
        <script src="js/headerComponents.js"></script>
    </head>
    <body>
        <% 
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User(firstName, lastName, email, password);
            session.setAttribute("user", user);
        %>
        <div class="gridContainer">
            <logged-in-header></logged-in-header>

            <div class="contentWrapper">
                <div class="centerContent">
                    <div class="welcomeText">
                        Welcome <%= firstName %> <%= lastName %>! <br>
                        Your email is <%= email %>! <br>
                        Your Password is <%= password %>! <br>
                        Click <a href="index.jsp">here</a> to proceed to the home page!
                    </div>
                </div>
            </div>
        </div>
        <script src="js/profileMenu.js"></script>
    </body>
</html>
