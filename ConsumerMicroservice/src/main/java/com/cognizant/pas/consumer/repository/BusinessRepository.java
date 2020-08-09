package com.cognizant.pas.consumer.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.pas.consumer.model.Business;

@Repository
@Transactional
@DynamicUpdate
public interface BusinessRepository extends JpaRepository<Business, Long> {

	Business findByConsumerId(Long consumerId);

	boolean existsById(Long id);

	Boolean existsByConsumerId(Long consumerId);

}
