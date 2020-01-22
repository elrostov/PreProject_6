package org.example.dao;

import org.example.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
