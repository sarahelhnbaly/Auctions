package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    private static List<Users> winners = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter number of users to bid: ");
            int numUsers = scanner.nextInt();
            Users.registerUsers(numUsers);

            List<Users> userList = Users.getUserList();
            System.out.println("Registered Users:\n" + userList);
            System.out.println("Starting the auction...");

            BidItem bidItem = new BidItem(); // This initializes the item object and registers it

            startBidding(userList, bidItem);

            System.out.print("\nPlay Again? \n1-yes 0-no: ");
            if (scanner.nextInt() != 1) break; // exit the loop if not playing again
        }

        scanner.close();
    }

    private static void startBidding(List<Users> userList, BidItem bidItem) {
        List<Double> bidAmounts = new ArrayList<>();

        while (true) {
            System.out.print("Select a user by ID to bid: ");
            int userId = scanner.nextInt();
            Users bidder = getUserById(userList, userId);

            if (bidder == null) {
                System.out.println("User does not exist.");
                continue;
            }

            System.out.print("Enter bid amount: ");
            double bidAmount = scanner.nextDouble();

            // Check if the bid amount is valid
            if (bidAmount <= bidder.getAmount() && bidAmount > bidItem.getInitialAmount()) {
                // Allow the bid
                if (bidAmounts.isEmpty() || bidAmount > bidAmounts.get(bidAmounts.size() - 1)) {
                    // Adjust the user's amount and save the bid
                    winners.add(bidder);
                    bidder.setAmount(bidder.getAmount() - bidAmount); // Deduct the bid amount
                    bidAmounts.add(bidAmount); // Store the bid amount in the list

                    System.out.println(bidder.getFirstname() + " " + bidder.getLastname() + " placed a bid of $" + bidAmount);

                    // Ask if the bidding should stop
                    System.out.print("Stop bidding? (1 for yes, 0 for no): ");
                    if (scanner.nextInt() == 1) {
                        System.out.printf("The winner is %s %s with a remaining amount of: $%.2f%n",
                                bidder.getFirstname(), bidder.getLastname(), bidder.getAmount());
                        break; // Exit the bidding loop
                    }
                } else {
                    System.out.println("You need to place a higher bid than the previous one.");
                }
            } else {
                System.out.println("Invalid bid amount. Ensure it's greater than the initial amount and within your balance.");
            }
        }
    }





    private static Users getUserById(List<Users> users, int userId) {
        for (Users user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}
