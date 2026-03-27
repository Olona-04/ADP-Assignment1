package za.ac.cput.Repository;
/**
 * @author Aiden Wallace 222471174
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Auction;
import za.ac.cput.repositoryImpl.AuctionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuctionRepositoryTest {

    private static AuctionRepository repository = AuctionRepository.getRepository();

    private Auction auction1 = new Auction.Builder()
            .auctionID(1L)
            .productID(100L)
            .sellerId(2L)
            .startingPrice(new BigDecimal("100"))
            .endTime(LocalDateTime.now().plusDays(1))
            .build();

    private Auction auction2 = new Auction.Builder()
            .auctionID(2L)
            .productID(102L)
            .sellerId(2L)
            .startingPrice(new BigDecimal("100"))
            .endTime(LocalDateTime.now().plusDays(1))
            .build();

    private Auction auction3 = new Auction.Builder()
            .auctionID(3L)
            .productID(101L)
            .sellerId(2L)
            .startingPrice(new BigDecimal("100"))
            .endTime(LocalDateTime.now().plusDays(1))
            .build();

    @BeforeEach
    void setUp(){
        repository = AuctionRepository.getRepository();
        repository.getAll().clear();
    }

    @Test
    void create() {
        Auction auc1 = repository.create(auction1);
        Auction auc2 = repository.create(auction2);
        Auction auc3 = repository.create(auction3);

        assertNotNull(auc1);
        assertNotNull(auc2);
        assertNotNull(auc3);

        List<Auction> all = repository.getAll();
        assertEquals(3, all.size());

        System.out.println("Created Auction: " + all);
    }

    @Test
    void read() {
        repository.create(auction1);
        Auction read = repository.read(auction1.getAuctionID());

        assertNotNull(read);
        System.out.println("read: " + read);
    }

    @Test
    void update() {
        repository.create(auction1);

        Auction updatedAuction = new Auction.Builder()
                .auctionID(1L)
                .productID(10L)
                .sellerId(2L)
                .startingPrice(new BigDecimal("200"))
                .endTime(LocalDateTime.now().plusDays(1))
                .build();

        Auction updated = repository.update(updatedAuction);
        assertNotNull(updated);

        System.out.println("updated: " + updated);
    }

    @Test
    void delete() {
        repository.create(auction1);

        Boolean deleted = repository.delete(auction1.getAuctionID());
        assertTrue(deleted);
        System.out.println("DELETED");

    }

    @Test
    void getAll(){
        repository.create(auction1);
        repository.create(auction2);
        repository.create(auction3);

        List<Auction> auctions = repository.getAll();
        assertFalse(auctions.isEmpty());
        System.out.println("All auctions: " + auctions);
    }
}