package com.revature.cryptoknights.controller;

import com.revature.cryptoknights.dto.UserDTO;
import com.revature.cryptoknights.service.UserService;
import com.revature.cryptoknights.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    User findUserById(@PathVariable String id){
        return userService.getUserByUserId(Integer.parseInt(id));
    }

    @GetMapping("/username/{username}")
    public @ResponseBody
    User findUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public @ResponseBody
    User createUser(@RequestBody UserDTO u)
    {
        User newUser = u.mapToUser();
        return userService.saveUser(newUser);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteUser(@PathVariable String id){
        userService.deleteUser(Integer.parseInt(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    User updateUser(@RequestBody UserDTO u)
    {
        User updatedUser = u.mapToUser();
        return userService.saveUser(updatedUser);
    }
}

