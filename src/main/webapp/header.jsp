<%@page import="iotbay.model.User"%>
<html>
    <body>
        <% User user = (User) session.getAttribute("user"); %>
        <header>
            <div class="innerHeader">
                <div class="logoContainer">
                    <a href="/">
                        <img src="css/iotbayLogo.png" alt="">
                    </a>
                </div>

                <div class="menuItems">
                    <% if (user != null) { %>
                        <a class="button" href="">Browse products</a>
                        <img class="profileIcon" id="profileIcon" src="css/profileIcon.svg">

                        <div class="profileMenuWrapper" id="profileMenu">
                            <form action="servlet/login" method="POST" class="profileMenu">
                                <h2 class="profileMenuUserName">User name here</h2>
                                <hr>
                                <a href="">Edit account details</a>
                                <button type="submit">Logout</button>
                            </form>
                        </div>
                    <% } else { %>
                        <a class="button" href="">Browse products</a>
                        <a class="button" href="login.jsp">Log in</a>
                        <a class="button button-blue" href="register.jsp">Create account</a>
                    <% } %>
                </div>
            </div>
        </header>
    </body>
</html>


