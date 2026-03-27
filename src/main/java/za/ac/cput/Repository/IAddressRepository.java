package za.ac.cput.Repository;
/**
 * @author Zahrah Vermaak 221406395
 */

import za.ac.cput.Domain.Address;

import java.util.List;

public interface IAddressRepository extends IRepository<Address,String>{

    List<Address>getAllAddress(); // create other lists
}
