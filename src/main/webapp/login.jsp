<%@page import="java.sql.Connection"%>
<%@page import="iotbay.helper.ProjectConstants"%>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <link rel="shortcut icon" href="css/iotbayIcon.ico">
        <title>Log in - IoTBay</title>
    </head>
    <body>
        <%
            String successMessage = (String) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE);
            String errorMessage = (String) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR);
            if (successMessage != null) {
                session.removeAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE);
        %>
            <div class="popup"><%= successMessage %></div>
        <% } else if (errorMessage != null) {
            session.removeAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR);
        %>
            <div class="popup errorMessage"><%= errorMessage %></div>
        <% } %>

        <jsp:include page="/servlet/dbConnection" flush="true" />
        <div class="gridContainer">
            <jsp:include page="header.jsp"/>

            <div class="contentWrapper">
                <div class="centerContent">
                    <form action="/servlet/login" method="GET">
                        <div class="formWrapper">
                            <h1>Log in</h1>
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
        <%
            Connection connection = (Connection) session.getAttribute("dbConnection");
            if (connection == null) { 
        %>
            <jsp:include page="/servlet/dbConnection" flush="true" />
        <% } %>
    </body>
</html>
