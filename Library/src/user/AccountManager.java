package user;

import java.util.HashMap;

public class AccountManager {
    HashMap<String, User> users;

    public AccountManager() {
        users = new HashMap<>();
    }

    public User getUser(String id, String name, String contact) {
        if (users.containsKey(id)) {
            return users.get(id);
        }
        User user = new User(id, name, Integer.parseInt(contact));
        users.put(id, user);
        return user;
    }
}
