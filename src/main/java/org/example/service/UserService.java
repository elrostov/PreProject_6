package org.example.service;

import org.example.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
