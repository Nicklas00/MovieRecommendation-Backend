package com.example.movierecommendation.service;

import com.example.movierecommendation.exception.LoginException;
import com.example.movierecommendation.model.User;
import com.example.movierecommendation.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;


@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public User save(User user){
    user.setPassword(hash(user.getPassword()));
    return userRepository.save(user);
  }

  public User verifyLogin(User user) throws LoginException {
    return userRepository.findByUsenamePasswordMatch(user.getUsername(), hash(user.getPassword()))
        .orElseThrow(() -> new LoginException("Bruger ikke fundet"));
  }
  public void deleteById(Long id){
    userRepository.deleteById(id);
  }

  public String hash(String string){
    return Hashing.sha256().hashString(string, StandardCharsets.UTF_8).toString();
  }
}
