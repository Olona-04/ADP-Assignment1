package za.ac.cput.Domain;
/**
 * @author Elona Sinjica
 */

import java.util.List;

public class Order {
    private final String orderId;
    private final String userId;
    private final List<String> productList;
    private final double totalAmount;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.userId = builder.userId;
        this.productList = builder.productList;
        this.totalAmount = builder.totalAmount;
    }

    public String getOrderId() { return orderId; }
    public String getUserId() { return userId; }
    public List<String> getProductList() { return productList; }
    public double getTotalAmount() { return totalAmount; }

    public static class Builder {
        private String orderId;
        private String userId;
        private List<String> productList;
        private double totalAmount;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setProductList(List<String> productList) {
            this.productList = productList;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}