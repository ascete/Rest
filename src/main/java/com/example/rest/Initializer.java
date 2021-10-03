package com.example.rest;


import com.example.rest.model.Role;
import com.example.rest.model.User;
import com.example.rest.service.RoleService;
import com.example.rest.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Initializer {

    private final UserService userService;
    private final RoleService roleService;

    public Initializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void postConstruct() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roleService.addRole(role1);
        roleService.addRole(role2);
        Set<Role> roles_admin = new HashSet<>();
        roles_admin.add(roleService.getRoleByName("ROLE_ADMIN"));
        User admin = new User("admin", "Admin", "1333",
                "admin@yan.ru", "1", roles_admin);
        userService.addUser(admin);
        Set<Role> roles_user = new HashSet<>();
        roles_user.add(roleService.getRoleByName("ROLE_USER"));
        User user = new User("user", "user", "1444",
                "user@yan.ru","1", roles_user);
        userService.addUser(user);
    }
}