package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
}
