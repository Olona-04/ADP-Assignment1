package za.ac.cput;

/**
 *
 * @author keano
 */

import za.ac.cput.Domain.Bid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.BidFactory;


public class BidFactoryTest {

    @Test
    void testCreateBid() {
        Bid bid = BidFactory.createBid("A1", "U1", 500.0);

        assertNotNull(bid);
        assertEquals("A1", bid.getAuctionId());
        assertEquals("U1", bid.getUserId());
        assertEquals(500.0, bid.getBidAmount());
    }
}
    