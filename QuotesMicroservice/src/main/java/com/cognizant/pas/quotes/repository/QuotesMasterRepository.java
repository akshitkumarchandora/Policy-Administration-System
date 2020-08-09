package com.cognizant.pas.quotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.pas.quotes.models.QuotesMaster;

@Repository
@Transactional
public interface QuotesMasterRepository extends JpaRepository<QuotesMaster, Long> {

	QuotesMaster findByBusinessValueAndPropertyValueAndPropertyType(Long businessValue,Long propertyValue,String propertyType);
}
