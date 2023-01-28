package com.studentmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.studentmanagement.model.User;

public interface UserRepository extends CrudRepository<User,Long>{

}
