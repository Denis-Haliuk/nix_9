package ua.alevel.dao;

import ua.alevel.db.UserDB;
import ua.alevel.entity.User;

import java.util.List;

public class UserDao {

    public void create(User user) {
        UserDB.getInstance().create(user);
    }

    public void update(User user) {
        UserDB.getInstance().update(user);
    }

    public boolean delete(String id) {
        return UserDB.getInstance().delete(id);
    }

    public User findById(String id) {
        return UserDB.getInstance().findById(id);
    }

    public User[] findAll() {
        return UserDB.getInstance().findAll();
    }
}
