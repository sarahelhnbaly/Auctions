package services;

import models.User;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationService {
    private ConcurrentHashMap<User, String> notifications;

    public NotificationService() {
        this.notifications = new ConcurrentHashMap<>();
    }

    // Method to Notify the user
    public void notifyUser(User user, String message) {
        if (user == null || message == null || message.isEmpty()) {
            System.out.println("User or message cannot be null or empty.");
            return;
        }

        // Notify via console (default)
        System.out.println("Notification to " + user.getUsername() + ": " + message);
        notifications.put(user, message); // Store notification

        try {
            if (user.getEmail() != null && !user.getEmail().isEmpty()) {
                sendEmail(user.getEmail(), message);
            }

            String phoneNumber = user.getPhoneNumber();
            if (phoneNumber != null && !phoneNumber.isEmpty()) {
                sendSMS(phoneNumber, message);
            } else {
                System.out.println("User phone number is not set. Cannot send SMS notification.");
            }
        } catch (Exception e) {
            // Log error or provide notification that delivery failed
            System.out.println("Failed to send notification to " + user.getUsername() + ": " + e.getMessage());
        }
    }

    private void sendEmail(String email, String message) {
        try {
            System.out.println("Sending email to " + email + ": " + message);
            // Add email sending logic if needed
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }

    private void sendSMS(String phoneNumber, String message) {
        try {
            System.out.println("Sending SMS to " + phoneNumber + ": " + message);
            // Add SMS sending logic if needed
        } catch (Exception e) {
            System.out.println("Error sending SMS: " + e.getMessage());
        }
    }
}
