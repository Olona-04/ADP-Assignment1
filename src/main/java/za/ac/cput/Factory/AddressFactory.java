package za.ac.cput.Factory;
/**
 * @author Zahrah Vermaak 221406395
 */

import za.ac.cput.Domain.Address;

public class AddressFactory {
    public static Address createAddress(String street, String city, String postalCode) {
        if (street == null || city == null || postalCode == null) return null;


        return new Address.Builder()
                .setStreet(street)
                .setCity(city)
                .setPostalCode(postalCode)
                .build();
    }

}
