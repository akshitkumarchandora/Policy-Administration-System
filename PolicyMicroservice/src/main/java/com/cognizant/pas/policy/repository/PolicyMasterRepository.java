package com.cognizant.pas.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.pas.policy.models.PolicyMaster;

@Repository
@Transactional
public interface PolicyMasterRepository extends JpaRepository<PolicyMaster, Long> {

	PolicyMaster findByPid(String policyid);

	Boolean existsByPid(String policyid);

}
