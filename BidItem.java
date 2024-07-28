package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BidItem implements Bidable, Serializable {
    private String itemName;
    private double initialAmount;

    private static List<BidItem> itemList = new ArrayList<>();

    // Default Constructor
    public BidItem() {
        registerBid();  // Automatically registers during construction
    }

    @Override
    public void registerBid() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter item name: ");
            this.itemName = input.nextLine();
            System.out.print("Enter initial amount: ");
            while (!input.hasNextDouble()) {
                System.out.println("Invalid amount. Please enter a numeric value.");
                input.next(); // clear invalid input
            }
            this.initialAmount = input.nextDouble();
            itemList.add(this); // register the item
            System.out.println("Bid item registered: " + this); // Implicitly calls toString()
        }
    }

    public String getName() {
        return itemName;
    }

    public double getInitialAmount() {
        return initialAmount;  // Ensure this method is here
    }

    public static List<BidItem> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {
        return itemName + " initial amount is: $" + initialAmount;
    }
}
