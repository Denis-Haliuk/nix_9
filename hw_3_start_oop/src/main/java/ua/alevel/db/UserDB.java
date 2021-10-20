package ua.alevel.db;

import ua.alevel.entity.User;

import java.util.Arrays;
import java.util.UUID;

public final class UserDB {

    private int size = 0;
    private User[] users;

    private static UserDB instance;

    private UserDB() {
        users = new User[size];
    }

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    public void create(User user) {
        user.setId(generateId());
        users[size] = user;
        users = new User[size + 1];
    }

//    public void update(User user) {
//        User current = findById(user.getId());
//        current.setAge(user.getAge());
//        current.setName(user.getName());
//    }

//    public void delete(String id) {
//        users.removeIf(user -> user.getId().equals(id));
//    }
//
//    public User findById(String id) {
//        return users.stream()
//                .filter(u -> u.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("user not found by id"));
//    }
//
//    public User[] findAll() {
//        return users;
//    }
//
    private String generateId() {
        String id = UUID.randomUUID().toString();
        if(Arrays.stream(users).anyMatch(user -> user.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
