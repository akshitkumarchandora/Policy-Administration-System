package com.cognizant.pas.consumer.payload.request;

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
public class BusinessPropertyRequest {
	
	@NotNull
	private Long businessId;
	
	@NotNull
	private Long consumerId;
	
	@NotBlank
	@Size(max = 30)
	private String insurancetype;
	
	@NotBlank
	@Size(max = 30)
	private String propertytype;
	
	@NotBlank
	@Size(max = 30)
	private String buildingsqft;
	
	@NotBlank
	@Size(max = 7)
	private String buildingtype;
	
	@NotBlank
	@Size(max = 10)
	private String buildingstoreys;
	
	@NotNull
	private Long buildingage;

	@NotNull
	private Long costoftheasset;
	
	@NotNull
	private Long salvagevalue;
	
	@NotNull
	private Long usefullifeoftheAsset;

}
