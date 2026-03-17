package Domain;

public class User {
    private String userID;
    private String name;
    private String surname;
    private String email;

    public User() {
    }

    private User(Builder builder) {
        this.userID = builder.userID;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
    }

    public String getUserID() {
        return userID;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEmail(){
        return email;
    }

    public String getFullName() {
        return "Name: " + name + " " + "Surname: " + surname;
    }

    public static class Builder {
        private String userID;
        private String name;
        private String surname;
        private String email;

        public Builder setUserId(String userId) {
            this.userID = userId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }


    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
