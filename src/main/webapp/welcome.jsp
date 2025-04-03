<%@page import="iotbay.model.User"%>
<html>
    <head>
        <title>Welcome Page</title>
    </head>
    <body bgcolor="alice blue">
        <% 
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
        %>
            <h1 class="welcomeText">
                Welcome <%= firstName %> <%= lastName %>! <br>
                Your email is <%= email %>! <br>
                Your Password is <%= password %>! <br>
                Click <a href="index.jsp">here</a> to proceed to the main page.
            </h1>
        <%
            User user = new User(firstName, lastName, email, password);
            session.setAttribute("user", user);
        %>
    </body>
</html>
