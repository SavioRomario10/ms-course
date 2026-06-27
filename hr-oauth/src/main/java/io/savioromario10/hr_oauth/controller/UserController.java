package io.savioromario10.hr_oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.savioromario10.hr_oauth.entities.User;
import io.savioromario10.hr_oauth.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping("/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    User user = service.findByEmail(email);
    
    return ResponseEntity.ok(user);
  }
}