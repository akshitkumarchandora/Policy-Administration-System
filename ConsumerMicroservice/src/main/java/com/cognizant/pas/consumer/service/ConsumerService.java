package com.cognizant.pas.consumer.service;

import org.springframework.stereotype.Service;

import com.cognizant.pas.consumer.model.Property;
import com.cognizant.pas.consumer.payload.request.BusinessPropertyRequest;
import com.cognizant.pas.consumer.payload.request.ConsumerBusinessRequest;
import com.cognizant.pas.consumer.payload.response.BusinessPropertyDetails;
import com.cognizant.pas.consumer.payload.response.ConsumerBusinessDetails;
import com.cognizant.pas.consumer.payload.response.MessageResponse;

@Service
public interface ConsumerService {

	MessageResponse createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest);
	
	Long calBusinessValue(Long businessturnover,Long capitalinvested);
	
	Long calPropertyValue(Long costoftheasset, Long salvagevalue, Long usefullifeoftheAsset);

	MessageResponse updateConsumerBusiness(ConsumerBusinessDetails consumerBusinessDetails);

	ConsumerBusinessDetails viewConsumerBusiness(Long consumerid);

	MessageResponse createBusinessProperty(BusinessPropertyRequest businessPropertyRequest);

	MessageResponse updateBusinessProperty(BusinessPropertyDetails businessPropertyDetails);

	Property viewConsumerProperty(Long consumerid, Long propertyid);

	Boolean checkBusinessEligibility(ConsumerBusinessRequest consumerBusinessRequest) throws Exception;

	Boolean checkPropertyEligibility(String propertytype, String insurancetype, String buildingtype, Long buildingage) throws Exception;

	

}
