import java.util.Scanner;
import models.Game;
import models.User;
import services.AuctionService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for name
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        // Get user input for email
        System.out.print("Enter your email: ");
        String userEmail = scanner.nextLine();

        // Get user input for bid amount
        System.out.print("Enter bid amount: ");
        double bidAmount = Double.parseDouble(scanner.nextLine());

        // Creating Game, User, and AuctionService instances based on user input
        Game game = new Game("Awesome Game", "An awesome game description", 50.0);
        User user = new User(userName, userEmail, "password123", 100.0);
        AuctionService auctionService = new AuctionService();

        auctionService.createAuction(game, user, 60000); // 1 minute auction

        // Placing bid
        auctionService.placeBid(auctionService.getAuctions().get(0), user, bidAmount);

        System.out.println("Bid placed successfully by " + user.getUsername());
        System.out.println("Highest bid: " + auctionService.getAuctions().get(0).getHighestBid());

        scanner.close();
    }
}
