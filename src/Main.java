import models.Game;
import models.User;
import services.AuctionService;
import models.Auction;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User("JohnDoe", "john@example.com", "password123", 100.0);
        User user2 = new User("JaneDoe", "jane@example.com", "password456", 150.0);

        Game game = new Game("Awesome Game", "An awesome game description", 50.0);

        AuctionService auctionService = new AuctionService();
        auctionService.createAuction(game, user1, 60000); // 1 minute auction

        Auction auction = auctionService.getAuctions().get(0);

        if (user2.placeBid(auction, 55.0)) {
            System.out.println("Bid placed successfully by " + user2.getUsername());
        } else {
            System.out.println("Bid failed due to insufficient balance");
        }

        System.out.println("Highest bid: " + auction.getHighestBid());
    }

}