package io.savioromario10.hr_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.savioromario10.hr_user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

  User findByEmail(String email);
}