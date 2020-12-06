package ru.max.springbootrestapp.service;

import ru.max.springbootrestapp.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findById(long id);

    void deleteUser(long id);

    List<User> findAll();

}

