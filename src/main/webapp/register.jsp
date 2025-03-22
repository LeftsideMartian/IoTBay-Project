<html>
    <head>
        <title>Create new account</title>
    </head>
    <body>
        <h1>Create new account</h1>

        <form action="index.jsp" method="POST">
            <ul>
                <li><input type="text" name="firstName" id="firstName" placeholder="First Name"></li>
                <li><input type="text" name="lastName" id="lastName" placeholder="Last Name"></li>
                <li><input type="email" name="email" id="email" placeholder="Email"></li>
                <li><input type="password" name="password" id="password" placeholder="Password"></li>
                <li><input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm password"></li>
            </ul>

            <input name="wasSubmitted" type="hidden" value="yes"/>

            <div>
                <a class="button" href="index.jsp">Cancel</a>
                <input class="button" type="submit" value="Create new account">
            </div>
        </form>

        <script>
            const passwordInput = document.getElementById("password");
            const confirmPasswordInput = document.getElementById("confirmPassword");

            const validatePassword = () => {
                if (passwordInput.value !== confirmPasswordInput.value) {
                    confirmPasswordInput.setCustomValidity("Passwords do not match.");
                } else {
                    confirmPasswordInput.setCustomValidity("");
                }
            }
    
            passwordInput.onchange = validatePassword;
            confirmPasswordInput.onkeyup = validatePassword;
        </script>
    </body>
</html>
