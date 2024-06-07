package service.impl;

import domain.User;
import mapping.dtos.UserDto;
import mapping.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers(){
        return userRepository.listUser();
    }
    @Override
    public void removeUser(Long id){
        userRepository.removeUser(id);
    }

    @Override
    public void addUser(User user){
        userRepository.addUser(user);
    }
}
