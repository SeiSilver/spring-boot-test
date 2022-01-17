package com.example.springboottest.jpa;

import com.example.springboottest.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT DISTINCT u FROM User u " +
      "WHERE u.username LIKE %?1% OR u.firstName LIKE %?1% OR u.lastName LIKE %?1% ")
  List<User> getAllByUsernameOrFirstNameOrLastName(String query);

  @Query("SELECT DISTINCT u FROM User u")
  List<User> getAll();

}
