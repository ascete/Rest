package com.example.rest.service;


import com.example.rest.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User updateUser(User user);

    void removeUserById(long id);

    User getUserById(long id);

    List<User> getAllUsers();

    User getUserByName(String username);

    void deleteUserById(long id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    boolean existsUserById(long id);
}
