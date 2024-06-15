package service.impl;

import domain.User;
import mapping.dtos.UserDto;
import mapping.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;
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
        return userRepository.listUser();
    }

    /**
     * Removes a user from the user repository based on the provided user ID.
     *
     * @param id the ID of the user to be removed.
     */
    @Override
    public void removeUser(Long id){
        userRepository.removeUser(id);
    }

    /**
     * Adds a new user to the user repository.
     *
     * @param user the UserDto object to be added.
     * @return
     */
    @Override
    public UserDto addUser(UserDto user){
           userRepository.addUser(user);
        return user;
    }

    /**
     * Saves the provided user to the user repository.
     * If the user already exists, it will be updated; otherwise, a new user will be added.
     *
     * @param user the UserDto object to be saved.
     */
    @Override
    public void saveUser(UserDto user){
        userRepository.saveUser(user);
    }

    /**
     * Retrieves a user from the user repository based on the provided user ID.
     * @param id the ID of the user to be retrieved.
     * @return an Optional containing the UserDto object if found, or an empty Optional if not found.
     */
    @Override
    public Optional<UserDto> getUserById(Long id){
        return userRepository.getUserById(id);
    }

    @Override
    public Optional<UserDto> searchByUser(String username) throws SQLException {
        User user = userRepository.findByUser(username);
        if (user == null){
            return Optional.empty();
        }
        return Optional.of(UserMapper.mapFrom(user));
    }
}
