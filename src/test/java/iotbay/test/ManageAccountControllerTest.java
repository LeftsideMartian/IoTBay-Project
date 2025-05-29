package iotbay.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iotbay.controller.ManageAccountController;
import iotbay.dao.DBConnector;
import iotbay.helper.ProjectConstants;
import iotbay.model.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    private User user;

    @BeforeEach
    public void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        dbConnector = new DBConnector();
        connection = dbConnector.connect();
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_DBCONNECTION)).thenReturn(connection);

        // Create a sample user and add to session
        user = new User(0, "John", "Doe", "john@example.com", "password123", false);
        when(session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_USER)).thenReturn(user);

        manageAccountController = new ManageAccountController();
    }

    @AfterEach
    public void tearDown() {
        dbConnector.closeConnection();
    }

    @Test
    @DisplayName("ManageAccountController - Successful password update")
    public void testUpdatePasswordSuccess() throws Exception {
        when(request.getParameter("typeOfUpdate")).thenReturn("updatePassword");
        when(request.getParameter("currentPassword")).thenReturn("password123");
        when(request.getParameter("newPassword")).thenReturn("newpassword456");

        manageAccountController.doPost(request, response);

        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_USER), any(User.class));
        verify(response).sendRedirect(ProjectConstants.MANAGE_ACCOUNT_PAGE);
    }

    @Test
    @DisplayName("ManageAccountController - Failed password update due to wrong current password")
    public void testUpdatePasswordFailure() throws Exception {
        when(request.getParameter("typeOfUpdate")).thenReturn("updatePassword");
        when(request.getParameter("currentPassword")).thenReturn("wrongpassword");
        when(request.getParameter("newPassword")).thenReturn("newpassword456");

        manageAccountController.doPost(request, response);

        verify(session).setAttribute(ProjectConstants.SESSION_ATTRIBUTE_ERROR, "Current password is incorrect.");
        verify(response).sendRedirect(ProjectConstants.MANAGE_ACCOUNT_PAGE);
    }

    @Test
    @DisplayName("ManageAccountController - Update user details")
    public void testUpdateDetails() throws Exception {
        when(request.getParameter("typeOfUpdate")).thenReturn("updateDetails");
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_FIRST_NAME)).thenReturn("Jane");
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_LAST_NAME)).thenReturn("Smith");
        when(request.getParameter(ProjectConstants.REQUEST_ATTRIBUTE_USER_EMAIL)).thenReturn("jane.smith@example.com");

        manageAccountController.doPost(request, response);

        verify(session).setAttribute(eq(ProjectConstants.SESSION_ATTRIBUTE_USER), any(User.class));
        verify(response).sendRedirect(ProjectConstants.MANAGE_ACCOUNT_PAGE);
    }
}
