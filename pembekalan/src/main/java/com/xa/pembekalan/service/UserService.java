package com.xa.pembekalan.service;

import java.util.List;

import com.xa.pembekalan.entity.User;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUserById(Integer id);
}
