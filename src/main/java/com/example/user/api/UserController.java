package com.example.user.api;

import com.example.user.model.User;
import com.example.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService){
    this.userService = userService;
  }

  @RequestMapping("/user/{email}")
  public User getUser(@PathVariable String email) {
    return userService.getUser(email);
  }

  @PostMapping("/user")
  public ResponseEntity<User> addUser(@RequestBody User addUser) {
    User user = userService.addUser(addUser);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

  @PutMapping("/user/{email}")
  public ResponseEntity<User> updateUser(@RequestBody User updateUser, @PathVariable String email){
    User userToBeUpdated =  userService.updateUser(email, updateUser);
    return new ResponseEntity<>(userToBeUpdated, HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/user/{email}")
  public ResponseEntity<User> deleteUser(@PathVariable String email) {
    User userToBeDeleted = userService.deleteUser(email);
    return new ResponseEntity<>(userToBeDeleted, HttpStatus.NO_CONTENT);
  }
}
