package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Auction;
import za.ac.cput.Factory.AuctionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
class AuctionFactoryTest {

    @Test
    void createAuctionTest(){
        Auction auction = AuctionFactory.createAuction(
                1L,
                10L,
                1111L,
                new BigDecimal("100"),
                LocalDateTime.now().plusDays(7)
        );
        assertNotNull(auction);
        assertEquals(1L, auction.getAuctionID());
        assertEquals(10L, auction.getProductID());
        assertEquals(new BigDecimal("100"), auction.getStartingPrice());
    }

}