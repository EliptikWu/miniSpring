package cue.edu.co.mini.service.impl;

import cue.edu.co.mini.domain.User;
import cue.edu.co.mini.mapping.dtos.UserDto;
import cue.edu.co.mini.mapping.mapper.UserMapper;
import cue.edu.co.mini.repository.UserRepository;
import cue.edu.co.mini.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
/**
 * @author <a href="https://github.com/EliptikWu"
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves a list of users from the user repository.
     *
     * @return a list of UserDto objects.
     */
    @Override
    public List<UserDto> getUsers(){
        return userRepository.findAll().stream()
                .map(UserMapper::mapFrom)
                .toList();
    }

    /**
     * Removes a user from the user repository based on the provided user ID.
     *
     * @param id the ID of the user to be removed.
     */
    public void removeUser(long id) throws SQLException {
        userRepository.delete(UserMapper.mapFrom(getUserById(id)));
    }
    /**
     * Adds a new user to the user repository.
     *
     * @param user the UserDto object to be added.
     * @return
     */
    @Override
    public void addUser(UserDto user) throws SQLException {
        userRepository.save(UserMapper.mapFrom(user));
    }

    /**
     * Retrieves a user from the user repository based on the provided user ID.
     * @param id the ID of the user to be retrieved.
     * @return an Optional containing the UserDto object if found, or an empty Optional if not found.
     */
    public UserDto getUserById(long id) throws SQLException {
        return userRepository.findById(id)
                .map(UserMapper::mapFrom)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
   /** @Override
    public Optional<UserDto> getUserByUser(String user) throws SQLException {
        return Optional.ofNullable(userRepository.findByUser(user))
                .map(UserMapper::mapFrom);
    }**/
}
