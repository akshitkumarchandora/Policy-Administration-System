package com.cognizant.pas.consumer.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerBusinessDetails {
	
	@NotBlank
	@Size(max = 50)
	private String firstname;
	@NotBlank
	@Size(max = 50)
	private String lastname;
	@NotBlank
	@Size(max = 20)
	private String dob;
	@NotBlank
	@Size(max = 50)
	private String businessname;
	@NotBlank
	@Size(max = 12)
	private String pandetails;
	@NotBlank
	@Size(max = 50)
	private String email;
	@NotBlank
	@Size(max = 10)
	private String phone;
	@NotBlank
	@Size(max = 40)
	private String website;
	@NotBlank
	@Size(max = 150)
	private String businessoverview;
	@NotBlank
	@Size(max = 30)
	private String validity;
	@NotBlank
	@Size(max = 50)
	private String agentname;
	@NotNull
	private Long agentid;
	@NotNull
	private Long businessid;
	@NotNull
	private Long consumerId;
	@NotBlank
	@Size(max = 40)
	private String businesscategory;
	@NotBlank
	@Size(max = 40)
	private String businesstype;
	@NotNull
	private Long businessturnover;
	@NotNull
	private Long capitalinvested;
	@NotNull
	private Long totalemployees;
	@NotNull
	private Long businessvalue;
	@NotNull
	private Long businessage;

}
