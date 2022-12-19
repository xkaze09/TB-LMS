package Models;

import Exceptions.InvalidAccountTypeException;

public abstract class User {
    // required
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Integer age;
    private String type;

    public void viewMyInfo() {
        System.out.printf("""
                \n=======================
                First Name: %s
                Last Name: %s
                Username: %s
                Password: %s
                Age: %d
                Account Type: %s
                =======================
                """, this.getFirstName(), this.getLastName(), this.getUsername(), this.getPassword(), this.getAge(),
                this.getType());
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private String username;
        private String password;
        private Integer age;
        private String type;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public User build(String type) {
            this.type = type.toLowerCase();
            switch (type.toLowerCase()) {
                case "student" -> {
                    return new Student(this);
                }
                case "teacher" -> {
                    return new Teacher(this);
                }
                default -> throw new InvalidAccountTypeException("Invalid account type!");
            }
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public Integer getAge() {
            return age;
        }

        public String getType() {
            return type;
        }
    }
}
