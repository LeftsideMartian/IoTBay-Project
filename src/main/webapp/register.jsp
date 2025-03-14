<html>
    <head>
        <title>Create new account</title>
    </head>
    <body>
        <h1>Create new account</h1>

        <form action="welcome.jsp" method="POST">
            <ul>
                <li><input type="text" placeholder="First Name"></li>
                <li><input type="text" placeholder="Last Name"></li>
                <li><input type="email" placeholder="Email"></li>
                <li><input type="password" placeholder="Password"></li>
                <li><input type="password" placeholder="Confirm password"></li>
            </ul>

            <div>
                <a class="button" href="index.jsp">Cancel</a>
                <input class="button" type="submit" value="Create new account">
            </div>
        </form>
    </body>
</html>
