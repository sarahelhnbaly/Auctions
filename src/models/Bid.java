package models;

public class Bid {

        private User bidder;
        private double amount;

        public Bid(User bidder, double amount) {
            this.bidder = bidder;
            this.amount = amount;
        }

        // Getters
        public User getBidder() {
            return bidder;
        }

        public double getAmount() {
            return amount;
        }
    }
