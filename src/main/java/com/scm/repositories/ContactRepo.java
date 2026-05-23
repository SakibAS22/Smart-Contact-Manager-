package com.scm.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scm.entities.Contact;
import com.scm.entities.Users;

@Repository
public interface ContactRepo extends JpaRepository<Contact, String> {

    //! find the contact by user

    // ? Custom finder method
    Page<Contact> findByUser(Users user, Pageable pageable);

    // ? Custom querry method
    @Query("SELECT c FROM Contact c WHERE c.user.id=:userId")
    List<Contact> findByUserId(@Param("userId") String userId);

    Page<Contact> findByUserAndNameContainingIgnoreCase(Users user,String nameKeyword ,Pageable pageable);
    Page<Contact> findByUserAndEmailContainingIgnoreCase(Users user,String emailKeyword ,Pageable pageable);
        Page<Contact> findByUserAndPhoneNumberContainingIgnoreCase(Users user,String phoneKeyword ,Pageable pageable);


}
