package io.savioromario10.hr_user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.savioromario10.hr_user.entities.User;
import io.savioromario10.hr_user.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository repository;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll(){
    List<User> list = repository.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id){
    User user = repository.findById(id).orElse(null);
    return ResponseEntity.ok().body(user);
  }

  @GetMapping(value = "/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email){
    User user = repository.findByEmail(email);
    return ResponseEntity.ok(user);
  }
}