
package models;

import models.Auction;

public class User {
    private String username;
    private String email;
    private String password;
    private double balance;

    public User(String username, String email, String password, double balance) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

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

    public boolean placeBid(Auction auction, double amount) {
        if (amount <= balance) {
            auction.placeBid(this, amount);
            balance -= amount;
            return true;
        }
        return false;
    }
}
