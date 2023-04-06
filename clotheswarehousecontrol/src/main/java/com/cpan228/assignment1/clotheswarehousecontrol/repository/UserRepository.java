package com.cpan228.assignment1.clotheswarehousecontrol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpan228.assignment1.clotheswarehousecontrol.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
