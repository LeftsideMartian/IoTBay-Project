<%@page import = "iotbay.model.User" %>
<%@ page session = "true" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("/login.jsp");
        return;
    }

    String firstName = user.getFirstName();
    String lastName = user.getLastName();
    String email = user.getEmail();
%>


<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <title>Manage Your Account</title>
    </head>

    <body>
        <div class= "gridContainer">

        <div class = "contentWrapper">
            <div class = "centerContent">
            <h1> Manage Your Account </h1>
            <form action="updateAccount.jsp" method = "POST">
                <h2>Personal Details</h2>
                <hr>
                <label for = "firstName" class = "formHeading">First Name</label>
                <input type="text" name= "firstName" id="firstName" class = "inputField" value = "<%= firstName %>" requried>

                <label for = "lastName" class = "formHeading">Last Name</label>
                <input type="text" name= "lastName" id="lastName" class = "inputField" value = "<%= lastName %>" requried>

                <label for = "email" class = "formHeading">Email</label>
                <input type="email" name= "email" id="email" class = "inputField" value = "<%= email %>" requried>

                <hr>
                <h2>Change Password</h2>
                <label for = "currentPassword" class = "formHeading">Current Password</label>
                <input type="password" name= "currentPassword" id="currentPassword" class = "inputField">

                <label for = "newPassword" class = "formHeading">New Password</label>
                <input type="password" name= "newPassword" id="newPassword" class = "inputField">

                <hr>
                <div class = "formSection buttonSection">
                    <a href ="index.jsp" class = "button medBtn">Cancel</a>
                    <button type ="submit" class="button medBtn button-blue">Save Changes</button>
                </div>
            </form>
            </div>
        </div> 
        </div>
        <script src="js/profileMenu.js"></script>
    </body>
</html>