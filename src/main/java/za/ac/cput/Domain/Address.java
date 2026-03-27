package za.ac.cput.Domain;
/**
 * @author Zahrah Vermaak 221406395
 */

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Address {
    private  String addressId;
    private  String street;
    private  String city;
    private  String postalCode;

    public Address() {
    }

    public Address(Builder builder) {
        this.addressId = builder.addressId;
        this.street = builder.street;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }

    @Override
    public String toString() {
        return "Builder{" +
                "addressId='" + addressId + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class Builder {
        private  String addressId;
        private String street;
        private String city;
        private String postalCode;

        public Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }


    }

}