package Models;

// Constructor to instantiate an Admin object with default username and password credentials
public class Admin extends User {
    public Admin() {
        this.setUsername("admin");
        this.setPassword("admin");
        this.setType("admin");
    }
}
