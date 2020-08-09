package com.cognizant.pas.policy.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePolicyRequest {
	
	@NotNull
	private Long consumerid;
	@NotBlank
	private String acceptedquotes;
}
