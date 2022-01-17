package com.example.springboottest.service;

import com.example.springboottest.model.UserRequest;
import java.util.List;
import com.example.springboottest.model.User;

public interface UserService {

  List<com.example.springboottest.model.User> getAllUser();

  User addNewUser(UserRequest user);

  List<User> searchByUsernameOrName(String query);

}
