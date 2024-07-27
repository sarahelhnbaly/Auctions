import models.Auction;
import services.UserService;
import services.NotificationService;
import services.AuctionService;
import models.Game;
import models.User;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        NotificationService notificationService = new NotificationService();
        AuctionService auctionService = new AuctionService();

        // Register users
        userService.registerUser("JohnDoe", "john@example.com", "password", "123-456-7890");

        // Retrieve User
        User user = userService.getUser("JohnDoe");

        // Create a Game
        Game game = new Game("Super Mario", "A fun platform game.", 10.0);

        // Create an Auction
        Auction auction = new Auction(game, user, 60000, notificationService); // 1-minute auction
        auctionService.createAuction(game, user, 60000);

        // Start the auction
        auction.startAuction();

        // Simulate a bid
        user.placeBid(auction, 15.0);

        // Notify user of bid
        notificationService.notifyUser(user, "You placed a bid of $15.0 on Super Mario.");
    }
}
