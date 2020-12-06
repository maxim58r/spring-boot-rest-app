package ru.max.springbootrestapp.dao;

import ru.max.springbootrestapp.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> findAll();

    User findById(long id);

    void deleteUser(long id);

}
