package com.example.springboottest.controller;

import com.example.springboottest.model.UserRequest;
import com.example.springboottest.service.UserService;
import java.util.List;
import com.example.springboottest.model.User;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<User>> getAllUser() {

    return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<User> getAllUser(@Valid @RequestBody UserRequest user) {

    User result = userService.addNewUser(user);

    return new ResponseEntity<>(result, HttpStatus.OK);

  }

  @GetMapping("/search")
  public ResponseEntity<List<User>> searchByUsernameOrName(@RequestParam String query) {

    return new ResponseEntity<>(userService.searchByUsernameOrName(query), HttpStatus.OK);
  }

}
