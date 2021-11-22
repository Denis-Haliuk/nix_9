package ua.alevel.dao.impl;

import ua.alevel.config.ApplicationConfig;
import ua.alevel.dao.UserDao;
import ua.alevel.entity.User;
import ua.alevel.db.UserDB;

import java.util.Collection;

public class UserDaoImpl implements UserDao {

    private final UserDB instanceDB = ApplicationConfig.getImpl(UserDB.class);

    @Override
    public void create(User entity) {
        instanceDB.create(entity);
    }

    @Override
    public void update(User entity) {
        instanceDB.update(entity);
    }

    @Override
    public void delete(String id) {
        instanceDB.delete(id);
    }

    @Override
    public User findById(String id) {
        return instanceDB.findById(id);
    }

    @Override
    public Collection<User> findAll() {
        return instanceDB.findAll();
    }

    @Override
    public boolean existByEmail(String email) {
        return instanceDB.existByEmail(email);
    }
}
