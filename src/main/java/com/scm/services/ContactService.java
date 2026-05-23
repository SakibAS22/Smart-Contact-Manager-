package com.scm.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.scm.entities.Contact;
import com.scm.entities.Users;

public interface ContactService {

    // ! Save Contact
    Contact save(Contact contact);

    // ! Update contact
    Contact update(Contact contact);

    // ! get Contact
    List<Contact> getALl();

    //! get contact by id
    Contact getById(String id);
    
    //! delete contact
    void delete(String id); 

    //! search contact
    Page<Contact> searchByName(String nameKeyword, int size, int page, String sortBy, String order, Users user);

    Page<Contact> searchByEmail(String emailKeyword, int size, int page, String sortBy, String order, Users user);

    Page<Contact> searchByPhoneNumber(String phoneNumberKeyword, int size, int page, String sortBy, String order, Users user);

    // ! get contact by userId
    List<Contact> getByUserId(String userId);

    Page<Contact> getByUser(Users user, int page, int size, String sortField, String sortDirection);

}
