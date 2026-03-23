package za.ac.cput.Factory;

import za.ac.cput.Domain.Auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuctionFactory {


    public static Auction createAuction(
            Long auctionID,
            Long productID,
            Long sellerID,
            BigDecimal startingPrice,
            LocalDateTime endTime ) {

        if (auctionID == null || productID == null || sellerID == null || startingPrice == null || endTime == null) {
            throw new IllegalArgumentException("Invalid auction data");
        }

        return new Auction.Builder()
                .auctionID(auctionID)
                .productID(productID)
                .sellerId(sellerID)
                .startingPrice(startingPrice)
                .endTime(endTime)
                .build();
    }
}
