package ua.alevel.db;

import ua.alevel.entity.User;

public interface UserDB extends BaseDB<User> {

    boolean existByEmail(String email);
}
