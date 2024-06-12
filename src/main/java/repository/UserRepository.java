package repository;

import domain.User;
import mapping.dtos.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> listUser();
    void removeUser(Long id);
    void addUser(User user);
    Optional<User> getUserById(Long id);
    void saveUser(User user);
}

