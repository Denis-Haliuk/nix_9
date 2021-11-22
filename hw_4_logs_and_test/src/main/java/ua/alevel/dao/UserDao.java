package ua.alevel.dao;

import ua.alevel.entity.User;

public interface UserDao extends BaseDao<User> {

    boolean existByEmail(String email);
}
