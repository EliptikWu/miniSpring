package controllers;

import domain.User;
import mapping.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get-users")
    public List<UserDto> getAllUsers() {
        return userService.getUsers();
    }

    @DeleteMapping(value = "/delete-users/{id}")
    public void removeUser(@PathVariable Long id) {
        userService.removeUser(id);
    }

    @PostMapping(value = "/add-user")
    public void addUser(@RequestBody UserDto user) {
        userService.addUser(user);
    }

    @GetMapping(value = "/get-user/{id}")
    public Optional<UserDto> getUserById(Long id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/save-user")
    public void saveUser(@RequestBody UserDto user){
        userService.saveUser(user);
    }
}
