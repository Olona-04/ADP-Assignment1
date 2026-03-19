
package Domain;

/**
 * @author keano Winnaar 230935869
 */

import java.util.Date;

public class Bid {

    private String auctionId;
    private String userId;
    private String bidId;
    private double bidAmount;
    private Date timestamp;

    private Bid(Builder builder) {
        
        this.auctionId = builder.auctionId;
        this.userId = builder.userId;
        this.bidId = builder.bidId;
        this.bidAmount = builder.bidAmount;
        this.timestamp = builder.timestamp;
    }

    public String getAuctionId() {
        return auctionId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getBidId() {
        return bidId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public static class Builder {
       
        private String auctionId;
        private String userId;
        private String bidId;
        private double bidAmount;
        private Date timestamp;


        public Builder setAuctionId(String auctionId) {
            this.auctionId = auctionId;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }
        
        public Builder setBidId(String bidId) {
            this.bidId = bidId;
            return this;
        }

        public Builder setBidAmount(double bidAmount) {
            this.bidAmount = bidAmount;
            return this;
        }

        public Builder setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Bid build() {
            return new Bid(this);
        }
    }
}
