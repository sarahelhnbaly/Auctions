package models;

import java.util.ArrayList;
import java.util.List;

public class AuctionHistory {
    private List<Bid> bidHistory;

    public AuctionHistory() {
        this.bidHistory = new ArrayList<>();
    }

    public void addBid(Bid bid) {
        bidHistory.add(bid);
    }

    public List<Bid> getBidHistory() {
        return bidHistory;
    }
}

