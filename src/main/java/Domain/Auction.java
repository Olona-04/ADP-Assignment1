package Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Auction {

    private final String auctionID;
    private final String productID;
    private final BigDecimal startingPrice;
    private BigDecimal currentHighestBid;
    private String currentHighestBidderId;
    private final LocalDateTime endTime;
    private boolean isActive;

    public Auction(Builder builder){
        this.auctionID = builder.auctionID;
        this.productID = builder.productID;
        this.startingPrice = builder.startingPrice;
        this.currentHighestBid = builder.currentHighestBid;
        this.currentHighestBidderId =builder.currentHighestBidderID;
        this.endTime = builder.endTime;
        this.isActive = builder.isActive;
    }

    //Builder class
    public static class Builder{
        private String auctionID;
        private String productID;
        private BigDecimal startingPrice;
        private BigDecimal currentHighestBid;
        private String currentHighestBidderID;
        private LocalDateTime endTime;
        private boolean isActive;

        public Builder auctionID(String auctionID){
            this.auctionID =auctionID;
            return this;
        }

        public Builder productID(String productID){
            this.productID = productID;
            return this;
        }

        public Builder startingPrice(BigDecimal startingPrice){
            this.startingPrice = startingPrice;
            return this;
        }

        public Builder currentHighestBidderID(String currentHighestBidderID){
            this.currentHighestBidderID = currentHighestBidderID;
            return this;
        }

        public Builder endTime(LocalDateTime endTime){
            this.endTime = endTime;
            return this;
        }

        public Builder isActive(Boolean isActive){
            this.isActive = isActive;
            return this;
        }

        public Builder currentHighestBid(BigDecimal currentHighestBid){
            this.currentHighestBid = currentHighestBid;
            return this;
        }

        public Auction build(){
            return new Auction(this);
        }

    }
    //getters
    public String getAuctionID() {return auctionID;}
    public String getProductID() {return productID;}
    public BigDecimal getStartingPrice() {return startingPrice;}
    public BigDecimal getCurrentHighestBid() {return currentHighestBid;}
    public String getCurrentHighestBidderID() {return currentHighestBidderId;}
    public boolean isActive() {return isActive;}

    public void placeBid(String bidder, BigDecimal bidPrice){
        if (!isActive) throw new IllegalStateException("Auction is not active");
        if (bidPrice.compareTo(startingPrice) <= 0) throw new IllegalArgumentException("Must be higher than current bid price");
        currentHighestBid = bidPrice;
        currentHighestBidderId = bidder;
    }

    public boolean isAuctionOver() {
        return LocalDateTime.now().isAfter(endTime);
    }
}
