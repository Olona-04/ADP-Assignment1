package za.ac.cput.Domain;

/**
 * @author Aiden Wallace 222471174
 */

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Auction {

        private final Long auctionID;
        private final Long productID;
        private final Long sellerID;
        private final BigDecimal startingPrice;
        private BigDecimal currentHighestBid;
        private Long currentHighestBidderId;
        private final LocalDateTime endTime;
        private boolean isActive;

        public Auction(Builder builder){
            this.auctionID = builder.auctionID;
            this.productID = builder.productID;
            this.sellerID = builder.sellerID;
            this.startingPrice = builder.startingPrice;
            this.currentHighestBid = builder.currentHighestBid;
            this.currentHighestBidderId =builder.currentHighestBidderID;
            this.endTime = builder.endTime;
            this.isActive = builder.isActive;
        }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionId=" + auctionID +
                ", productId=" + productID +
                ", sellerId=" + sellerID +
                ", startingPrice=" + startingPrice +
                ", endTime=" + endTime +
                '}';
    }

        //Builder class
        public static class Builder{
            private Long auctionID;
            private Long productID;
            private Long sellerID;
            private BigDecimal startingPrice;
            private BigDecimal currentHighestBid;
            private Long currentHighestBidderID;
            private LocalDateTime endTime;
            private boolean isActive;

            public Builder auctionID(Long auctionID){
                this.auctionID =auctionID;
                return this;
            }

            public Builder productID(Long productID){
                this.productID = productID;
                return this;
            }

            public Builder sellerId(Long sellerID){
                this.sellerID =sellerID;
                return this;
            }

            public Builder startingPrice(BigDecimal startingPrice){
                this.startingPrice = startingPrice;
                return this;
            }

            public Builder currentHighestBidderID(Long currentHighestBidderID){
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
        public Long getAuctionID() {return auctionID;}
        public Long getProductID() {return productID;}
        public Long getSellerID() {return sellerID;}
        public BigDecimal getStartingPrice() {return startingPrice;}
        public BigDecimal getCurrentHighestBid() {return currentHighestBid;}
        public Long getCurrentHighestBidderID() {return currentHighestBidderId;}
        public boolean isActive() {return isActive;}

        public void placeBid(Long bidder, BigDecimal bidPrice){
            if (!isActive) throw new IllegalStateException("Auction is not active");
            if (bidPrice.compareTo(startingPrice) <= 0) throw new IllegalArgumentException("Must be higher than current bid price");
            currentHighestBid = bidPrice;
            currentHighestBidderId = bidder;
        }

        public boolean isAuctionOver() {
            return LocalDateTime.now().isAfter(endTime);
        }
    }


