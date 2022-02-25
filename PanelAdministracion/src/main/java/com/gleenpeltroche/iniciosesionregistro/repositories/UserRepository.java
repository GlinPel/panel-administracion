package com.gleenpeltroche.iniciosesionregistro.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gleenpeltroche.iniciosesionregistro.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

 User findByUsername(String username);
 List<User> findAll();
}
