package za.ac.cput.repositoryImpl;
/**
 * @author Zahrah Vermaak 221406395
 */

import za.ac.cput.Domain.User;
import za.ac.cput.Repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private static UserRepository repository = null;
    private List<User> allUsers;


    private UserRepository() {
        allUsers = new ArrayList<>();
    }


    public static UserRepository getRepository() {
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }

    @Override
    public User create(User user) {
        allUsers.add(user);
        return user;
    }

    @Override
    public User read(String id) {
        for (User user : allUsers) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User update(User user) {
        User existingUser = read(user.getUserId());

        if (existingUser != null) {
            allUsers.remove(existingUser);
            allUsers.add(user);
            return user;
        }

        return null;
    }
    @Override
    public boolean delete(String id) {
        User userToDelete = read(id);

        if (userToDelete != null) {
            allUsers.remove(userToDelete);
            return true;
        }

        return false;
    }

    @Override
    public List<User> getAll() {
        return allUsers;
    }

    @Override
    public List<User> getAllUser() {
        return getAll(); // reuse
    }
}
