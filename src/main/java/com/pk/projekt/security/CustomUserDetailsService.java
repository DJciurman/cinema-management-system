package com.pk.projekt.security;

import com.pk.projekt.user.User;
import com.pk.projekt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository repo;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = repo.findUserByEmail(email);
    if (user == null) {
      throw new UsernameNotFoundException("UserNotFound");
    }
    return new CustomUserDetails(user);
  }


}
