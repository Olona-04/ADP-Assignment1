package za.ac.cput.Repository;
/**
 * @author Zahrah Vermaak 221406395
 */
import za.ac.cput.Domain.User;

import java.util.List;

public interface IUserRepository extends IRepository<User, String> {
    List<User> getAllUser();
}
