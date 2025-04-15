package iotbay.model;

import java.io.Serializable;

/**
* Model class for users
* */
public class User implements Serializable {
    public int userId;
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    /**
    * Empty constructor
    * */
    public User() {}

    /**
    * Constructor with details
    * */
    public User(int userId, String firstName, String lastName, String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return
            "User {" +
            "userId=" + userId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
