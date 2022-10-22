package com.hemkant.SpringSecurity.CORsAndCSRF.Repository;

import java.util.List;

import com.hemkant.SpringSecurity.CORsAndCSRF.Model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
