package cue.edu.co.mini.service;

import cue.edu.co.mini.mapping.dtos.UserDto;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService{
        List<UserDto> getUsers();
        void removeUser(long id) throws SQLException;
        void addUser(UserDto user) throws SQLException;
        UserDto getUserById(long id) throws SQLException;
        //Optional<UserDto> getUserByUser(String user) throws SQLException;
}

