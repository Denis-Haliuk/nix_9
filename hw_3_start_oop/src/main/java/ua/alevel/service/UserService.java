package ua.alevel.service;

import ua.alevel.dao.UserDao;
import ua.alevel.entity.User;

public class UserService {
    
    private final UserDao userDao = new UserDao();

    public void create(User user) {
        userDao.create(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public boolean delete(String id) {
        return userDao.delete(id);
    }

    public User findById(String id) {
        return userDao.findById(id);
    }

    public User[] findAll() {
        return userDao.findAll();
    }
}