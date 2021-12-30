package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}
