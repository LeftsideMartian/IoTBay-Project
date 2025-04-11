<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>

        <form action="index.jsp" method="POST">
            <ul>
                <li><input type="text" name="email" id="email" placeholder="Email"></li>
                <li><input type="text" name="password" id="password" placeholder="Password"></li>
                <i><input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm password"></li>
            </ul>

            <input name="wasSubmitted" type="hidden" value="yes"/>

            <div>
                <a class="button" href="index.jsp">Cancel</a>
                <input class="button" type="submit" value="Login">
            </div>
        </form>
    </body>
</html>
