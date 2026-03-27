package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.User;
import za.ac.cput.repositoryImpl.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private IUserRepository repository = UserRepository.getRepository();

    // Example User instances
    private User user1 = new User.Builder()
            .setUserId("U1")
            .setName("John")
            .setSurname("Doe")
            .setEmail("john.doe@example.com")
            .build();

    private User user2 = new User.Builder()
            .setUserId("U2")
            .setName("Jane")
            .setSurname("Smith")
            .setEmail("jane.smith@example.com")
            .build();

    private User user3 = new User.Builder()
            .setUserId("U3")
            .setName("Alice")
            .setSurname("Brown")
            .setEmail("alice.brown@example.com")
            .build();

    @BeforeEach
    void setUp() {
        repository = UserRepository.getRepository();
        repository.getAll().clear(); // clear previous data
    }

    @Test
    void create() {
        User created1 = repository.create(user1);
        User created2 = repository.create(user2);
        User created3 = repository.create(user3);

        assertNotNull(created1);
        assertNotNull(created2);
        assertNotNull(created3);

        List<User> all = repository.getAll();
        assertEquals(3, all.size());
        System.out.println(all);
    }

    @Test
    void read() {
        repository.create(user1);
        User read = repository.read("U1");

        assertNotNull(read);
        assertEquals("John", read.getName());

    }

    @Test
    void update() {
        repository.create(user1);

        User updatedUser = new User.Builder()
                .setUserId("U1")
                .setName("Johnny")
                .setSurname("Doe")
                .setEmail("john.doe@example.com")
                .build();

        User updated = repository.update(updatedUser);
        assertNotNull(updated);
        assertEquals("Johnny", updated.getName());
    }

    @Test
    void delete() {
        repository.create(user1);

        boolean deleted = repository.delete("U1");
        assertTrue(deleted);

        User read = repository.read("U1");
        assertNull(read);
    }

    @Test
    void getAll() {
        repository.create(user1);
        repository.create(user2);

        List<User> all = repository.getAll();
        assertEquals(2, all.size());
        System.out.println(repository.getAll());
    }

    @Test
    void getAllUsers() {
        repository.create(user2);
        repository.create(user3);

        List<User> allUsers = repository.getAllUser();
        assertEquals(2, allUsers.size());
        System.out.println(repository.getAllUser());
    }
}