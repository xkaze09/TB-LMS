package Models;

import Controllers.StudentController;

// For reading CSV files
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private StudentController myController;

    public Student(UserBuilder builder) {
        this.setFirstName(builder.getFirstName());
        this.setLastName(builder.getLastName());
        this.setUsername(builder.getUsername());
        this.setPassword(builder.getPassword());
        this.setAge(builder.getAge());
        this.setType(builder.getType());
    }

    // To-do list:
    // Student must be able to do the following:
    // a. View assignments by teacher
    // b. View feedbacks by teacher
    // c. Mark assignments as done

    public void setMyController(StudentController myController) {
        this.myController = myController;
    }
}
