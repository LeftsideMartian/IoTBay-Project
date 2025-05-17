package iotbay.model;

import java.io.Serializable;

// Model class for users
public class User implements Serializable {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean hasAdminPermissions;

    // All args constructor
    public User(int userId, String firstName, String lastName, String email, String password, boolean hasAdminPermissions) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.hasAdminPermissions = hasAdminPermissions;
    }

    // Getter and setter methods
    public void setUserId(int userId) { this.userId = userId; }
    public int getUserId() { return this.userId; }
    public String getName() {return firstName + " " + lastName; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public void setAdminPermissions(boolean hasAdminPermissions) { this.hasAdminPermissions = hasAdminPermissions; }
    public boolean doesHaveAdminPermissions() { return this.hasAdminPermissions; }

    // toString method for debugging
    @Override
    public String toString() {
        return
            "User{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", hasAdminPermissions=" + hasAdminPermissions +
            '}';
    }
}
