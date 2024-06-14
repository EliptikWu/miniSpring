package repository;

import domain.User;
import mapping.dtos.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<UserDto> listUser();
    void removeUser(Long id);
    void addUser(UserDto user);
    Optional<UserDto> getUserById(Long id);
    void saveUser(UserDto user);
}

