package com.cognizant.pas.policy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Consumer_Policy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerPolicy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Long id;
	
	@NotNull
	@Column(name = "Consumer_ID")
	private Long consumerid;
	
	@Size(max = 10)
	@Column(name = "Policy_ID")
	private String policyid;
	
	@NotNull
	@Column(name = "Business_ID")
	private Long businessid;
	
	@Size(max = 10)
	@Column(name = "Payment_Details")
	private String paymentdetails;
	
	@Size(max = 10)
	@Column(name = "Acceptance_Status")
	private String acceptancestatus;
	
	@NotBlank
	@Size(max = 10)
	@Column(name = "Policy_Status")
	private String policystatus;
	
	@Size(max = 20)
	@Column(name = "Effective_Date")
	private String effectivedate;
	
	@Size(max = 15)
	@Column(name = "Covered_Sum")
	private String covered_sum;
	
	
	@Size(max = 15)
	@Column(name = "Duration")
	private String duration;
	
	@NotBlank
	@Size(max = 15)
	@Column(name = "Accepted_Quotes")
	private String acceptedquote;

	public ConsumerPolicy(@NotNull Long consumerid, @NotNull Long businessid,
			@NotBlank @Size(max = 10) String policystatus, @NotBlank @Size(max = 15) String acceptedquote) {
		super();
		this.consumerid = consumerid;
		this.businessid = businessid;
		this.policystatus = policystatus;
		this.acceptedquote = acceptedquote;
	}



	


	
	
}
