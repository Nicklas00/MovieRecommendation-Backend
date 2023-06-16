package com.example.movierecommendation.controller;

import com.example.movierecommendation.exception.LoginException;
import com.example.movierecommendation.model.User;
import com.example.movierecommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRESTController {
  private final UserService userService;

  @Autowired
  public UserRESTController(UserService userService){
    this.userService = userService;
  }

  @PostMapping()
  public ResponseEntity<User> createUser(@RequestBody User user){
    return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
  }

  @PostMapping("/verify")
  public ResponseEntity<User> verifyLogin(@RequestBody  User user) throws LoginException {
    return new ResponseEntity<>(userService.verifyLogin(user), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable Long id){
    userService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}

