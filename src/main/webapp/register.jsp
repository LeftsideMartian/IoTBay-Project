<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <title>Create new account</title>
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
                    <form action="index.jsp" method="POST">
                        <div class="formWrapper">
                            <h1>Create an account</h1>
                            <hr>

                            <label class="formHeading">Name</label>
                            <div class="formSection">
                                <div class="inputSection">
                                    <label class="inputHeading" for="firstName">First Name</label>
                                    <input class="inputField" type="text" placeholder="John" name="firstName" id="firstName" required>
                                </div>
                                <div class="inputSection">
                                    <label class="inputHeading" for="lastName">Last Name</label>
                                    <input class="inputField" type="text" placeholder="Smith" name="lastName" id="lastName" required>
                                </div>
                            </div>

                            <label class="formHeading" for="email">Email</label>
                            <input class="inputField" type="email" placeholder="ex: myname@example.com" name="email" id="email" required>
                            
                            <label class="formHeading">Password</label>
                            <div class="formSection">
                                <div class="inputSection">
                                    <label class="inputHeading" for="password">Enter password</label>
                                    <input class="inputField" type="password" name="password" id="password" required>
                                </div>
                                
                                <div class="inputSection">
                                    <label class="inputHeading" for="confirmPassword">Confirm password</label>
                                    <input class="inputField" type="password" name="confirmPassword" id="confirmPassword" required>
                                </div>
                            </div>
                            <hr>

                            <div class="formSection buttonSection">
                                <a href="index.jsp" class="button">Cancel</a>
                                <button type="submit" class="button button-blue">Create account</button>
                            </div>
                        </div>

                        <div class="signInFooter">
                            <p>Already have an account? <a href="#">Sign in</a>.</p>
                        </div>
                    </form>
                </div>
            </div>
        </div>

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
