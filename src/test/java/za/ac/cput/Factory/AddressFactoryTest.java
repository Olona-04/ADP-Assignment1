package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void createAddress() {
        Address address = AddressFactory.createAddress(
                "123 Main St",
                "Cape Town",
                "8000"
        );

        assertNotNull(address, "Address should not be null");
        assertEquals("123 Main St", address.getStreet());
        assertEquals("Cape Town", address.getCity());
        assertEquals("8000", address.getPostalCode());
        System.out.println(address);
    }

    @Test
    void createAddress_nullStreet() {
        Address address = AddressFactory.createAddress(
                null,
                "Cape Town",
                "8000"
        );

        assertNull(address, "null Street name");
    }

    @Test
    void createAddress_fail_nullCity() {
        Address address = AddressFactory.createAddress(
                "123 Main St",
                null,
                "8000"
        );

        assertNull(address, "null City");
    }

    @Test
    void createAddress_fail_nullPostalCode() {
        Address address = AddressFactory.createAddress(
                "123 Main St",
                "Cape Town",
                null
        );

        assertNull(address, "null Postal code");
    }
}