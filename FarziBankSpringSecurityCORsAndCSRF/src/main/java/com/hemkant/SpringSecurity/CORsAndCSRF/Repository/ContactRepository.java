package com.hemkant.SpringSecurity.CORsAndCSRF.Repository;

import com.hemkant.SpringSecurity.CORsAndCSRF.Model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
