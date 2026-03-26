

/**
 *
 * @author keano
 */
package factory;

import Domain.Bid;
import java.util.Date;
import java.util.UUID;

public class BidFactory {

    public static Bid createBid(String auctionId, String userId, double bidAmount) {

        if (auctionId == null || userId == null || bidAmount <= 0) {
            return null;
        }

        return new Bid.Builder()
                .setBidId(UUID.randomUUID().toString())
                .setAuctionId(auctionId)
                .setUserId(userId)
                .setBidAmount(bidAmount)
                .setTimestamp(new Date())
                .build();
    }
}