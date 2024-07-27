package models;

import services.NotificationService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;

public class Auction {
    private Game game;
    private User seller;
    private ConcurrentHashMap<User, Double> bids;
    private long startTime;
    private long endTime;
    private List<User> watchingUsers; // Track users who want to watch the auction
    private NotificationService notificationService;
    private boolean isActive; // Track if the auction is currently active

    public Auction(Game game, User seller, long duration, NotificationService notificationService) {
        this.game = game;
        this.seller = seller;
        this.bids = new ConcurrentHashMap<>();
        this.startTime = System.currentTimeMillis();
        this.endTime = startTime + duration;
        this.watchingUsers = new ArrayList<>();
        this.notificationService = notificationService;
        this.isActive = true; // Auction starts as active
    }

    public synchronized void placeBid(User user, double amount) {
        if (!isActive) {
            notificationService.notifyUser(user, "Cannot place bid. The auction has already ended.");
            return;
        }

        if (System.currentTimeMillis() < endTime && amount > getHighestBid()) {
            bids.put(user, amount);
            notificationService.notifyUser(user, "Your bid of $" + amount + " has been placed for " + game.getTitle());
        } else {
            notificationService.notifyUser(user, "Your bid of $" + amount + " is invalid. The auction may have ended or your bid is too low.");
        }
    }

    public double getHighestBid() {
        return bids.values().stream().max(Double::compare).orElse(game.getStartingPrice());
    }

    public void startAuction() {
        new Thread(() -> {
            while (System.currentTimeMillis() < endTime) {
                long timeLeft = endTime - System.currentTimeMillis();
                if (timeLeft <= 10000 && timeLeft > 0) { // Notify the last 10 seconds
                    notifyWatchingUsers("Auction for " + game.getTitle() + " is about to end!");
                }
                try {
                    Thread.sleep(1000); // Check every second
                } catch (InterruptedException e) {
                    System.err.println("Error during auction timer: " + e.getMessage());
                }
            }
            isActive = false; // Mark auction as ended
            notifyWatchingUsers("Auction ended for " + game.getTitle());
        }).start();
    }

    private void notifyWatchingUsers(String message) {
        for (User user : watchingUsers) {
            notificationService.notifyUser(user, message);
        }
    }

    public void watchAuction(User user) {
        if (!watchingUsers.contains(user)) {
            watchingUsers.add(user);
            notificationService.notifyUser(user, "You are now watching the auction for " + game.getTitle());
        } else {
            notificationService.notifyUser(user, "You are already watching this auction.");
        }
    }

    // Getters for game, seller, bids etc.
    public Game getGame() {
        return game;
    }

    public User getSeller() {
        return seller;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public ConcurrentHashMap<User, Double> getBids() {
        return bids;
    }

    public boolean isActive() {
        return isActive;
    }
}
