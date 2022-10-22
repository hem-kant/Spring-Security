package com.hemkant.SpringSecurity.CORsAndCSRF.Repository;

import com.hemkant.SpringSecurity.CORsAndCSRF.Model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
