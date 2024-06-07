package repository;

import domain.User;
import mapping.dtos.UserDto;

import java.util.List;

public interface UserRepository {
    List<User> listUser();
    void removeUser(Long id);
    void addUser(User user);
}

