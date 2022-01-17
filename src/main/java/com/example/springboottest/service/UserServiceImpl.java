package com.example.springboottest.service;

import com.example.springboottest.jpa.UserRepository;
import com.example.springboottest.model.User;
import com.example.springboottest.model.UserRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public List<User> getAllUser() {
    return userRepository.getAll();
  }

  @Override
  @Transactional
  public User addNewUser(UserRequest user) {

    User newUser = new User();
    newUser.setUserId(0);
    newUser.setUsername(user.getUsername());
    newUser.setFirstName(user.getFirstName());
    newUser.setLastName(user.getLastName());
    newUser.setBirth(user.getBirth());
    newUser.setCreatedDate(Timestamp.from(Instant.now()));

    return userRepository.save(newUser);
  }

  @Override
  @Transactional
  public List<User> searchByUsernameOrName(String query) {
    return userRepository.getAllByUsernameOrFirstNameOrLastName(query);
  }
}
