package com.cognizant.pas.application.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PolicyDetailsResponse {
	
	@NotNull
	private Long consumerid;
	
	@NotBlank
	@Size(max = 10)
	private String policyid;
	
	@NotBlank
	@Size(max = 30)
	private String property_type;
	
	@NotBlank
	@Size(max = 30)
	private String consumer_type;

	@NotBlank
	@Size(max = 40)
	private String assured_sum;

	@NotBlank
	@Size(max = 30)
	private String tenure;

	@NotNull
	private Long business_value;

	@NotNull
	private Long property_value;

	@NotBlank
	@Size(max = 30)
	private String base_location;
	
	@NotBlank
	@Size(max = 30)
	private String type;
	
	@NotNull
	private Long businessid;
	
	@NotBlank
	@Size(max = 10)
	private String paymentdetails;
	
	@NotBlank
	@Size(max = 10)
	private String acceptancestatus;
	
	@NotBlank
	@Size(max = 10)
	private String policystatus;
	
	@NotBlank
	@Size(max = 15)
	private String effectivedate;
	
	@NotBlank
	@Size(max = 15)
	private String covered_sum;
	
	@NotBlank
	@Size(max = 15)
	private String duration;
	
	@NotBlank
	@Size(max = 15)
	private String acceptedquote;
	

}
