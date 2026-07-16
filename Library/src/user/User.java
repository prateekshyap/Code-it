package user;

public class User {
    String id;
    String name;
    int contact;

    public User(String id, String name, int contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }
}
