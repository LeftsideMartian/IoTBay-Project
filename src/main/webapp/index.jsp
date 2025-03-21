<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        <h1>ISD Week6 Home Page</h1>

        <% 
        String wasSubmittedString = request.getParameter("wasSubmitted");

        if (wasSubmittedString != null && wasSubmittedString.equals("yes")) {
        %>
            <h1>Welcome! <%= request.getParameter("firstName") %> <%= request.getParameter("lastName") %>!</h1>
        <% } %>

        <div>
            <a class="button" href="register.jsp">Register</a>
            <a class="button" href="login.jsp">Login</a>
        </div>
    </body>
</html>
