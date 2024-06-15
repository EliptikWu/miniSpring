package service;

import mapping.dtos.UserDto;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService{
        List<UserDto> getUsers();
        void removeUser(Long id);
        UserDto addUser(UserDto user);
        Optional<UserDto> getUserById(Long id);
        void saveUser(UserDto user);
        Optional<UserDto> searchByUser(String username) throws SQLException;
}

