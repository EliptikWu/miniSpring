package cue.edu.co.mini.repository;

import cue.edu.co.mini.domain.User;
import cue.edu.co.mini.mapping.dtos.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**List<UserDto> listUser();
    void removeUser(Long id);
    void addUser(UserDto user);
    Optional<UserDto> getUserById(Long id);
    void saveUser(UserDto user);
    User findByUser(String email);**/
    //User findByUser(String user);
}

