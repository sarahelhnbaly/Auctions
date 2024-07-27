package models;

import models.Auction;

public class User {
    private String username;
    private String email;
    private String password;
    private double balance;
    private String phoneNumber; // Added phone number field

    // Updated constructor to include phone number
    public User(String username, String email, String password, double balance, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.phoneNumber = phoneNumber; // Initialize phone number
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter for phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean placeBid(Auction auction, double amount) {
        if (amount <= balance) {
            auction.placeBid(this, amount);
            balance -= amount; // Deduct the amount from the balance
            return true;
        }
        return false; // Not enough balance
    }
}
