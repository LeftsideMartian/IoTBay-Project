<%@page import="iotbay.model.User"%>
<%@page import="iotbay.helper.ProjectConstants"%>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <link rel="shortcut icon" href="css/iotbayIcon.ico">
        <title>Home - IoTBay</title>
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
        <jsp:include page="/servlet/productsListInitialiser" flush="true" />
        <% User user = (User) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER); %>

        <div class="gridContainer">
            <jsp:include page="header.jsp"/>

            <div class="contentWrapper">
                <div class="centerContent">
                    <div class="indexContentWrapper">
                        <% if (user != null) { %>
                            <h1 class="welcomeText">
                                You are logged in as <%= user.getName() %> <<%= user.getEmail() %>> <br>
                                Click the profile icon to log out.
                            </h1>
                        <% } else { %>
                            <h1 class="mainHeading" >Your leading IoT distributor</h1>
                            <img class="mainImage" src="css/tempImage.jpg" alt="">
                            <a class="button" href="register.jsp">Get started</a>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
