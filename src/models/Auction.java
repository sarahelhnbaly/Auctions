package models;

import java.util.concurrent.ConcurrentHashMap;

public class Auction {
    private Game game;
    private User seller;
    private ConcurrentHashMap<User, Double> bids;
    private long startTime;
    private long endTime;

    public Auction(Game game, User seller, long duration) {
        this.game = game;
        this.seller = seller;
        this.bids = new ConcurrentHashMap<>();
        this.startTime = System.currentTimeMillis();
        this.endTime = startTime + duration;
    }

    public synchronized void placeBid(User user, double amount) {
        if (System.currentTimeMillis() < endTime && amount > getHighestBid()) {
            bids.put(user, amount);
        }
    }

    public double getHighestBid() {
        return bids.values().stream().max(Double::compare).orElse(game.getStartingPrice());
    }

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
}
