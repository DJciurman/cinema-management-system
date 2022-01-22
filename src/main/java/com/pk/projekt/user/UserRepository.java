package com.pk.projekt.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT u FROM User u ORDER BY u.name ASC")
  List<User> findAllUsersNameASC();

  @Query("SELECT u FROM User u WHERE u.id = ?1")
  User findUserById(int id);

  @Query("SELECT u FROM User u WHERE u.email = ?1")
  User findUserByEmail(String email);

  @Query("SELECT u FROM User u WHERE u.name = ?1")
  User findUserByName(String name);
}
