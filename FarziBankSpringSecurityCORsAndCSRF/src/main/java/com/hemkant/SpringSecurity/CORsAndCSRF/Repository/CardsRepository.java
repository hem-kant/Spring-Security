package com.hemkant.SpringSecurity.CORsAndCSRF.Repository;

import java.util.List;

import com.hemkant.SpringSecurity.CORsAndCSRF.Model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {
	
	List<Cards> findByCustomerId(int customerId);

}
