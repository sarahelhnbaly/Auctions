package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {
    private int userId;
    private String firstName;
    private String lastName;
    private double amount;
    private static List<Users> userList = new ArrayList<>();

    public Users(int userId, String firstName, String lastName, double amount) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static void registerUsers(int n) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter user ID: ");
            int userId = input.nextInt();
            input.nextLine();  // Consume newline
            System.out.print("Enter first name: ");
            String firstName = input.nextLine();
            System.out.print("Enter last name: ");
            String lastName = input.nextLine();
            System.out.print("Enter initial amount: ");
            double amount = input.nextDouble();

            Users user = new Users(userId, firstName, lastName, amount);
            userList.add(user);
            System.out.println("User registered successfully: " + user);
        }
    }

    public static List<Users> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        return String.format("User ID: %d, Name: %s %s, Amount: $%.2f", userId, firstName, lastName, amount);
    }
}
