package services;

import models.User;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    private ConcurrentHashMap<String, User> users;

    public UserService() {
        this.users = new ConcurrentHashMap<>();
    }

    public void registerUser(String username, String email, String password, String phoneNumber) {
        // Ensure user does not already exist
        if (!users.containsKey(username)) {
            User newUser = new User(username, email, password, 0, phoneNumber);
            users.put(username, newUser);
            System.out.println("User registered: " + username);
        } else {
            System.out.println("User with username '" + username + "' already exists!");
        }
    }

    // Example of user lookup
    public User getUser(String username) {
        return users.get(username);
    }

    // Other user management methods (login, get user by email, etc.)
}
