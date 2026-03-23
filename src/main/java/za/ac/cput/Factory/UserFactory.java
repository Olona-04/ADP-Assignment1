package za.ac.cput.Factory;

import za.ac.cput.Domain.User;

public class UserFactory {
        public static User createUser(String id, String name, String surname, String email) {
            return new User.Builder()
                    .setUserId(id)
                    .setName(name)
                    .setSurname(surname)
                    .setEmail(email)
                    .build();
        }

}
