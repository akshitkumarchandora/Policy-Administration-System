package com.cognizant.pas.consumer.repository;

import org.hibernate.annotations.DynamicUpdate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.pas.consumer.model.BusinessMaster;

@Repository
@Transactional
@DynamicUpdate
public interface BusinessMasterRepository extends JpaRepository<BusinessMaster, Long> {

	BusinessMaster findByBusinesscategoryAndBusinesstype(String businesscategory, String businesstype);

}
