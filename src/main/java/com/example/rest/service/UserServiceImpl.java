package com.example.rest.service;


import com.example.rest.dao.UserDao;
import com.example.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setUserRepository(UserDao userRepository) {
        this.userDao = userRepository;
    }

    @Override
    public User addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        if(!user.getPassword().equals(getUserById(user.getId()).getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userDao.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserByName(String username) {
        return null;
    }



    @Override
    public void removeUserById(long id) {

    }

    @Override
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public User getUserById(long id) {
        User user = null;
        Optional<User> emp = userDao.findById(id);
        if(emp.isPresent()){
            user = emp.get();
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public boolean existsUserById(long id) {
        if (userDao.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }
}