package com.example.rest.dao;


import com.example.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User getUserByUsername(String username);

    User getUserById(long id);

    User findByUsername(String username);

    User findByEmail(String email);

    User findUserById(long id);
}
