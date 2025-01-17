package com.xa.pembekalan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xa.pembekalan.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
