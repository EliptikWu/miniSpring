package cue.edu.co.mini.controllers;

import jakarta.validation.Valid;
import cue.edu.co.mini.mapping.dtos.LoginDto;
import cue.edu.co.mini.mapping.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import cue.edu.co.mini.service.UserService;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
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
    public void removeUser(@Valid @PathVariable Long id)  throws SQLException {
        userService.removeUser(id);
    }

    @PostMapping(value = "/add-user")
    public void addUser(@RequestBody UserDto user)  throws SQLException {
        userService.addUser(user);
    }

    @GetMapping(value = "/get-user/{id}")
    public Optional<UserDto> getUserById(Long id) throws SQLException {
        return Optional.ofNullable(userService.getUserById(id));
    }

   /** @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDto loginRequest, BindingResult result) throws SQLException {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid login request");
        }
        Optional<UserDto> userDto = userService.getUserByUser(loginRequest.username());
        if (userDto.isEmpty()) {
            return ResponseEntity.badRequest().body("Login failed");
        } else if (!Objects.equals(userDto.get().password(), loginRequest.password())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }
        return ResponseEntity.ok("Login succesful");
    }**/
}
