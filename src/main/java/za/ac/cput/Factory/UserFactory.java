package za.ac.cput.Factory;
/**
 * @author Zahrah Vermaak 221406395
 */

import za.ac.cput.Domain.User;

import java.util.UUID;

public class UserFactory {
    public static User createUser(String name, String surname, String email, String password) {

        if (name == null || name.isEmpty())
            return null;

        if (surname == null || surname.isEmpty())
            return null;

        if (email == null || email.isEmpty())
            return null;

        if (password == null || password.isEmpty())
            return null;

        String userId = UUID.randomUUID().toString();

        return new User.Builder()
                .setUserId(userId)
                .setSurname(surname)
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}