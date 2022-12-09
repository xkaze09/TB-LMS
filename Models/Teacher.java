package Models;

// For reading CSV files
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    public Teacher(UserBuilder builder) {
        this.setFirstName(builder.getFirstName());
        this.setLastName(builder.getLastName());
        this.setUsername(builder.getUsername());
        this.setPassword(builder.getPassword());
        this.setAge(builder.getAge());
        this.setType(builder.getType());
    }
    // To-do list:
    // Teacher must be able to do the following:
    // a. Create and check assignments
    // b. Create and check feedbacks
}
