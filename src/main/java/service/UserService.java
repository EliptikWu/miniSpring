package service;

import domain.User;

import java.util.List;

public interface UserService{
        List<User> getUsers();
        void removeUser(Long id);
        void addUser(User user);
}

