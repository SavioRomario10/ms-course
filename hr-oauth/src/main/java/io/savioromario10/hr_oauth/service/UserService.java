package io.savioromario10.hr_oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.savioromario10.hr_oauth.entities.User;
import io.savioromario10.hr_oauth.feignclients.UserFeignClient;

@Service
public class UserService {

  @Autowired
  private UserFeignClient userFeignClient;

  public User findByEmail(String email){
    User user = userFeignClient.findByEmail(email).getBody();

    if(user == null) throw new IllegalArgumentException("Email not found: " + email);

    return user;
  }
}