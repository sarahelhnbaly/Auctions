package services;

import models.Auction;
import models.Game;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class AuctionService {
    private List<Auction> auctions;

    public AuctionService() {
        this.auctions = new ArrayList<>();
    }

    public void createAuction(Game game, User seller, long duration) {
        Auction auction = new Auction(game, seller, duration);
        auctions.add(auction);
        new Thread(() -> {
            try {
                Thread.sleep(duration);
                System.out.println("Auction ended for " + game.getTitle());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void placeBid(Auction auction, User user, double amount) {
        auction.placeBid(user, amount);
    }

    public List<Auction> getAuctions() {
        return auctions;
    }
}
