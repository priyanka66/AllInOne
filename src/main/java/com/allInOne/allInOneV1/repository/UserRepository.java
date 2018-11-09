package com.allInOne.allInOneV1.repository;


import org.springframework.data.repository.CrudRepository;

import com.allInOne.allInOneV1.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    Iterable<User> findAll();

    List<User> findByLastName(@Param("name") String name);
}