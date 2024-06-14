package service;

import domain.User;
import domain.Vehicle;
import mapping.dtos.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService{
        List<UserDto> getUsers();
        void removeUser(Long id);
        void addUser(UserDto user);
        Optional<UserDto> getUserById(Long id);
        void saveUser(UserDto user);
}

