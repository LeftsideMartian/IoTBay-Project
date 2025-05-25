
package iotbay.test;


import iotbay.controller.ManageAccountController;
import iotbay.dao.DBConnector;
import iotbay.helper.ProjectConstants;
import iotbay.model.User;
import iotbay.service.UserService;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.sql.Connection;


import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.eq;


public class ManageAccountControllerTest {


    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private DBConnector dbConnector;
    private Connection connection;
    private ManageAccountController manageAccountController;


    @BeforeEach
    public void setup() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);


        dbConnector = new DBConnector();
        connection = dbConnector.connect();
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION)).thenReturn(connection);


        manageAccountController = new ManageAccountController();
    }


    @AfterEach
    public void cleanup() {
        dbConnector.closeConnection();
    }


    @Test
    @DisplayName("9a - Edit First Name")
    public void testEditFirstName() {
        when(request.getParameter("firstName")).thenReturn("Alex");
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(new User("old", "email", "pw"));


        manageAccountController.doPost(request, response);


        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS), eq("Details updated successfully."));
    }


    @Test
    @DisplayName("9b - Edit Last Name")
    public void testEditLastName() {
        when(request.getParameter("lastName")).thenReturn("Smith");
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(new User("Alex", "email", "pw"));


        manageAccountController.doPost(request, response);


        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS), eq("Details updated successfully."));
    }


    @Test
    @DisplayName("9c - Edit Email")
    public void testEditEmail() {
        when(request.getParameter("email")).thenReturn("alex.smith@example.com");
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(new User("Alex", "old@example.com", "pw"));


        manageAccountController.doPost(request, response);


        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS), eq("Details updated successfully."));
    }


    @Test
    @DisplayName("9d - Edit Password")
    public void testEditPassword() {
        when(request.getParameter("password")).thenReturn("NewStrongPassword123!");
        when(request.getParameter("confirmPassword")).thenReturn("NewStrongPassword123!");
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(new User("Alex", "email", "OldPw!"));


        manageAccountController.doPost(request, response);


        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS), eq("Password updated successfully."));
    }


    @Test
    @DisplayName("9e - Confirm Edited Password Mismatch")
    public void testPasswordMismatch() {
        when(request.getParameter("password")).thenReturn("Pass123");
        when(request.getParameter("confirmPassword")).thenReturn("WrongPass123");
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(new User("Alex", "email", "OldPw!"));


        manageAccountController.doPost(request, response);


        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_ERROR), eq("Passwords do not match."));
    }


    @Test
    @DisplayName("9f - Submit Edited Details")
    public void testSubmitAllDetails() {
        when(request.getParameter("firstName")).thenReturn("Alex");
        when(request.getParameter("lastName")).thenReturn("Smith");
        when(request.getParameter("email")).thenReturn("alex.smith@example.com");
        when(request.getParameter("password")).thenReturn("NewStrongPassword123!");
        when(request.getParameter("confirmPassword")).thenReturn("NewStrongPassword123!");
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(new User("Old", "old@example.com", "pw"));


        manageAccountController.doPost(request, response);


        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS), eq("Details updated successfully."));
    }
}
