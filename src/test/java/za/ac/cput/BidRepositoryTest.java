package za.ac.cput;

/**
 *
 * @author keano
 */


import za.ac.cput.Domain.Bid;
import za.ac.cput.Repository.IBidRepository;
import za.ac.cput.repositoryImpl.BidRepository;
import za.ac.cput.Factory.BidFactory;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class BidRepositoryTest {

    @Test
    void testRepositoryCRUD() {

        IBidRepository repo = new BidRepository();

        Bid bid = BidFactory.createBid("A1", "U1", 500);

        
        repo.create(bid);
        assertNotNull(repo.read(bid.getBidId()));

        
        Bid updated = new Bid.Builder()
                .setBidId(bid.getBidId())
                .setAuctionId("A2")
                .setUserId("U1")
                .setBidAmount(600)
                .build();

        repo.update(updated);
        assertEquals(600, repo.read(bid.getBidId()).getBidAmount());

        
        repo.delete(bid.getBidId());
        assertNull(repo.read(bid.getBidId()));
    }
}