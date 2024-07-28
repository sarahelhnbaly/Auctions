package org.example;

import org.testng.annotations.Test; // Use TestNG imports only
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BidItemTest {

    @Test
    public void testBidItemCreation() {
        BidItem item = new BidItem(); // This will call registerBid and ask for input
        item.registerBid(); // It's not ideal to have input in a unit test context, but we'll keep it for now
        assertNotNull(item, "BidItem should not be null.");
        assertNotNull(item.getName(), "Item name should not be null.");
        assertTrue(item.getInitialAmount() >= 0, "Initial amount should be non-negative.");
    }

    @Test
    public void testUserCreation() {
        Users user = new Users(1, "John", "Doe", 150.0);
        assertNotNull(user, "User should not be null.");
        assertEquals(user.getUserId(), 1, "User ID should match");
        assertEquals(user.getFirstname(), "John", "First name should match");
        assertEquals(user.getLastname(), "Doe", "Last name should match");
        assertEquals(user.getAmount(), 150.0, "User amount should match");
    }
}
