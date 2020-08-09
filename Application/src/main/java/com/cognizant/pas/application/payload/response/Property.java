package com.cognizant.pas.application.payload.response;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Property {

	@NotNull
	private Long id;

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
	private Long propertyvalue;

	@NotNull
	private Long costoftheasset;

	@NotNull
	private Long salvagevalue;

	@NotNull
	private Long usefullifeoftheAsset;

	public Property(@NotNull Long businessId, @NotNull Long consumerId, @NotBlank @Size(max = 30) String insurancetype,
			@NotBlank @Size(max = 30) String propertytype, @NotBlank @Size(max = 30) String buildingsqft,
			@NotBlank @Size(max = 7) String buildingtype, @NotBlank @Size(max = 10) String buildingstoreys,
			@NotNull Long buildingage, @NotNull Long propertyvalue, @NotNull Long costoftheasset,
			@NotNull Long salvagevalue, @NotNull Long usefullifeoftheAsset) {
		super();
		this.businessId = businessId;
		this.consumerId = consumerId;
		this.insurancetype = insurancetype;
		this.propertytype = propertytype;
		this.buildingsqft = buildingsqft;
		this.buildingtype = buildingtype;
		this.buildingstoreys = buildingstoreys;
		this.buildingage = buildingage;
		this.propertyvalue = propertyvalue;
		this.costoftheasset = costoftheasset;
		this.salvagevalue = salvagevalue;
		this.usefullifeoftheAsset = usefullifeoftheAsset;
	}





}
