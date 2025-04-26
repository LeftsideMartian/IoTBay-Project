<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <title>Log in</title>
        <script src="js/headerComponents.js"></script>
    </head>
    <body>
        <%
            String errorMessage = (String) session.getAttribute("loginError");
            if (errorMessage != null) { 
        %>
            <%= errorMessage %>
        <% } %>

        <div class="gridContainer">
            <logged-out-header></logged-out-header>

            <div class="contentWrapper">
                <div class="centerContent">
                    <form action="login" method="GET">
                        <div class="formWrapper">
                            <h1 class="registerHeading">Log in</h1>
                            <hr>

                            <label class="formHeading" for="email">Email</label>
                            <input class="inputField" type="email" placeholder="ex: myname@example.com" name="email" id="email" required>
                            
                            <label class="formHeading">Password</label>
                            <input class="inputField" type="password" name="password" id="password" required>

                            <hr>

                            <div class="formSection buttonSection">
                                <a href="index.jsp" class="button medBtn">Cancel</a>
                                <button type="submit" class="button medBtn button-blue">Log in</button>
                            </div>
                        </div>

                        <div class="signInFooter">
                            <p>Don't have an account? <a href="register.jsp">Create one here</a>.</p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
