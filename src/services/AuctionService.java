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
        // Create a new auction with a dummy NotificationService
        NotificationService notificationService = new NotificationService();
        Auction auction = new Auction(game, seller, duration, notificationService);
        auctions.add(auction);
    }

    public List<Auction> getAuctions() {
        return auctions;
    }
}
