package za.ac.cput.Factory;

import za.ac.cput.Domain.Address;

public class AddressFactory {
    public static Address createAddress(String street, String city, String postalCode) {
        return new Address.Builder()
                .setStreet(street)
                .setCity(city)
                .setPostalCode(postalCode)
                .build();
    }

}
