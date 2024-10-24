package com.CRUD_Operation.CRUD_Operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD_Operation.CRUD_Operation.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
