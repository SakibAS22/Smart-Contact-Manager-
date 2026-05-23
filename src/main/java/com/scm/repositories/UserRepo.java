package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.Users;

@Repository
public interface  UserRepo extends JpaRepository<Users,String> {
    // Extra methods db rleatedoperations
    // custom query methods
    // custorm finder methods
    
    Optional<Users> findByEmail(String email);
    Optional<Users> findByEmailAndPassword(String email, String password);

}
