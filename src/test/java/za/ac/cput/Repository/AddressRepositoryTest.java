package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Address;
import za.ac.cput.repositoryImpl.AddressRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressRepositoryTest {
    private IAddressRepository repository = AddressRepository.getRepository();

    private Address address1 = new Address.Builder()
            .setAddressId("A1")
            .setStreet("123 Main St")
            .setCity("Cape Town")
            .setPostalCode("8000")
            .build();

    private Address address2 = new Address.Builder()
            .setAddressId("A2")
            .setStreet("456 Oak Ave")
            .setCity("Stellenbosch")
            .setPostalCode("7600")
            .build();

    private Address address3 = new Address.Builder()
            .setAddressId("A3")
            .setStreet("789 Pine Rd")
            .setCity("Durbanville")
            .setPostalCode("7550")
            .build();

    @BeforeEach
    void setUp() {
        repository = AddressRepository.getRepository();
        repository.getAll().clear(); // clear previous data
    }

    @Test
    void create() {
        Address created1 = repository.create(address1);
        Address created2 = repository.create(address2);
        Address created3 = repository.create(address3);

        assertNotNull(created1);
        assertNotNull(created2);
        assertNotNull(created3);

        assertEquals("123 Main St", created1.getStreet());
        assertEquals("456 Oak Ave", created2.getStreet());
        assertEquals("789 Pine Rd", created3.getStreet());

        List<Address> allAddresses = repository.getAll();
        assertEquals(3, allAddresses.size());
        System.out.println(allAddresses);
    }

    @Test
    void read() {
        repository.create(address1);
        Address read = repository.read("A1");

        assertNotNull(read);
        assertEquals("123 Main St", read.getStreet());
    }

    @Test
    void update() {
        repository.create(address1);

        Address updatedAddress = new Address.Builder()
                .setAddressId("A1")
                .setStreet("321 Updated St")
                .setCity("Cape Town")
                .setPostalCode("8000")
                .build();

        Address updated = repository.update(updatedAddress);
        assertNotNull(updated);
        assertEquals("321 Updated St", updated.getStreet());

    }

    @Test
    void delete() {
        repository.create(address1);

        Boolean deleted = repository.delete("A1");
        assertTrue(deleted);

        Address read = repository.read("A1");
        assertNull(read);

    }

    @Test
    void getAll() {
        repository.create(address1);
        repository.create(address2);

        List<Address> all = repository.getAll();
        assertEquals(2, all.size(), "Should return all addresses");
        assertTrue(all.contains(address1));
        assertTrue(all.contains(address2));
        System.out.println(repository.getAll());
    }

    @Test
    void getAllAddress() {
        repository.create(address1);
        repository.create(address3);

        List<Address> allAddresses = repository.getAllAddress();
        assertEquals(2, allAddresses.size(), "Should return all addresses");
        assertTrue(allAddresses.contains(address1));
        assertTrue(allAddresses.contains(address3));
        System.out.println(repository.getAllAddress());
    }
}