package service;

import domain.User;
import domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface UserService{
        List<User> getUsers();
        void removeUser(Long id);
        void addUser(User user);
        Optional<User> getUserById(Long id);
        void saveUser(User user);
}

