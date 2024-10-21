package com.CRUD_Operation.CRUD_Operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD_Operation.CRUD_Operation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
