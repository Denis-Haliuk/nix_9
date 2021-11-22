package ua.alevel.service.impl;

import ua.alevel.service.UserService;
import ua.alevel.config.ApplicationConfig;
import ua.alevel.dao.UserDao;
import ua.alevel.entity.User;

import java.util.Collection;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = ApplicationConfig.getImpl(UserDao.class);

    @Override
    public void create(User entity) {
        if (!userDao.existByEmail(entity.getEmail())) {
            userDao.create(entity);
        }
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public Collection<User> findAll() {
        return userDao.findAll();
    }
}
