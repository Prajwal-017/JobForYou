package com.example.jobforyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobforyou.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
