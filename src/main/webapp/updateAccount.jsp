<%@page import = "iotbay.model.User" %>
<%@ page import = "iotbay.dao.UserDAO" %>
<%@ page session = "true" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(login.jsp);
        return;
    }
    
    String firstName = request.getParameter("firstName")
    String lastName = request.getParameter("lastName")
    Stirng email = request.getParameter("email")

    String currentPassword = request.getParameter("currentPassword")
    String newPassword = request.getParameter("newPassword")

    boolean passwordChanged = false;
    String message = "";

    if (currentPassword != null && !currentPassword.isEmpty()) {
        if (currentPassword.equals(user.getpassword())) {
            if (newPassword != null && !newPassword.isEmpty()){
            user.setPassword(newPassword);
            passwordChanged = true;
        } else {
            message = "New password cannot be empty."
        }
    } else {
        message = "Current password is incorrect.";
    }
}

user.setFirstName(firstName);
user.setLastName(lastName);
user.setEmail(email);

try {
    UserDAO userDAO = new UserDAO();
    userDAO.updatedUser(user);

    session.setAttribute("user", user);
    if (message.isEmpty()){
        message = "Account updated successfully" + (passwordChanged ? " (password changed)." : ".");

    }
} catch (Expression e) {
    message = "Error updating account: " + e.getMessage();
}
%>

<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <title>Manage Your Account</title>
        <script src="js/headerComponents.js"></script>
    </head>

  <body>
    <div class = "gridContainer">
        <logged-in-header></logged-in-header>
        <div class = "centerContent">
            <h2> Update Status</h2>
            <p><%= message %></p>
            <a href = "account.jsp" class = "button medBtn button-blue">Back to Account</a>
        </div>
        </div>
    </div>
  </body>
</html>
