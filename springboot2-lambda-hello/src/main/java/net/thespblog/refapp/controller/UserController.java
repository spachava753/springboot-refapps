package net.thespblog.refapp.controller;


import net.thespblog.refapp.model.User;
import net.thespblog.refapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.getOne(id);
    }

    @GetMapping(path = "/user")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/user")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
