package com.cognizant.pas.consumer.model;

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
@Table(name = "Property")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotNull
	@Column(name = "Business_ID")
	private Long businessId;

	@NotNull
	@Column(name = "Consumer_ID")
	private Long consumerId;

	@NotBlank
	@Size(max = 30)
	@Column(name = "Insurance_Type")
	private String insurancetype;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "Property_Type")
	private String propertytype;

	@NotBlank
	@Size(max = 30)
	@Column(name = "Building_Sqft")
	private String buildingsqft;

	@NotBlank
	@Size(max = 7)
	@Column(name = "Building_Type")
	private String buildingtype;

	@NotBlank
	@Size(max = 10)
	@Column(name = "Building_Storeys")
	private String buildingstoreys;

	@NotNull
	@Column(name = "Building_Age")
	private Long buildingage;

	@NotNull
	@Column(name = "Property_Value")
	private Long propertyvalue;

	@NotNull
	@Column(name = "Cost_of_the_asset")
	private Long costoftheasset;

	@NotNull
	@Column(name = "Salvage_value")
	private Long salvagevalue;

	@NotNull
	@Column(name = "Useful_Life_of_the_Asset")
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
