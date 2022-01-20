package com.JPA_practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.JPA_practice.JPA_User;

public interface UserRepo extends CrudRepository<JPA_User, String> {

}
