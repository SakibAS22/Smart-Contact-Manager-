package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.Users;
import com.scm.forms.UserForm;

public interface UserService {

    // Users saveUser(UserForm userForm);

    Optional<Users> getUserById(String id);

    Optional<Users> updateUser(Users user);

    void deleteUser(String id);

    boolean isUserExist(String userId);

    boolean isUserExistByEmail(String email);

    List<Users> getAllUsers();

    Users saveUser(Users user);

    Users getUserByEmail(String email);

    // ? Add more methods related to user service[logic]

}
