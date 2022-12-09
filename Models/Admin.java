package Models;

public class Admin extends User {
    public Admin() {
        this.setUsername("admin");
        this.setPassword("admin");
        this.setType("admin");
    }
}
