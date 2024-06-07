package controllers;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get-users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @DeleteMapping(value = "/delete-users/{id}")
    public void removeUser(@PathVariable Long id) {
        userService.removeUser(id);
    }

    @PostMapping(value = "/add-user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
