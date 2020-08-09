package com.cognizant.pas.consumer.repository;

import org.hibernate.annotations.DynamicUpdate;

import com.cognizant.pas.consumer.model.PropertyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@DynamicUpdate
public interface PropertyMasterRepository extends JpaRepository<PropertyMaster, Long> {

	PropertyMaster findByPropertytypeAndInsurancetypeAndBuildingtype(String propertytype, String insurancetype,
			String buildingtype);

}
