package za.ac.cput.repositoryImpl;
/**
 * @author Zahrah Vermaak 221406395
 */

import za.ac.cput.Domain.Address;
import za.ac.cput.Repository.IAddressRepository;

import java.util.ArrayList;
import java.util.List;

public class AddressRepository implements IAddressRepository {

    private static AddressRepository repository = null;
    private List<Address> allAddresses;

    private AddressRepository() { allAddresses = new ArrayList<>();
    }

    public static AddressRepository getRepository() {
        if (repository == null) {
            repository = new AddressRepository();
        }
        return repository;
    }

    @Override
    public Address create(Address address) {
        allAddresses.add(address);
        return address;
    }

    @Override
    public Address read(String id) {
        for (Address address : allAddresses) {
            if (address.getAddressId().equals(id)) {
                return address;
            }
        }
        return null;
    }

    @Override
    public Address update(Address address) {
        Address existingAddress = read(address.getAddressId());
        if (existingAddress != null) {
            allAddresses.remove(existingAddress);
            allAddresses.add(address);
            return address;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Address addressToDelete = read(id);
        if (addressToDelete != null) {
            allAddresses.remove(addressToDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<Address> getAll() {
        return allAddresses;
    }

    @Override
    public List<Address> getAllAddress() {
        return getAll();
    }

}
