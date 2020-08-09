package com.cognizant.pas.consumer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pas.consumer.exception.BusinessPropertyNotFoundException;
import com.cognizant.pas.consumer.exception.ConsumerBusinessNotFoundException;
import com.cognizant.pas.consumer.model.Business;
import com.cognizant.pas.consumer.model.BusinessMaster;
import com.cognizant.pas.consumer.model.Consumer;
import com.cognizant.pas.consumer.model.Property;
import com.cognizant.pas.consumer.model.PropertyMaster;
import com.cognizant.pas.consumer.payload.request.BusinessPropertyRequest;
import com.cognizant.pas.consumer.payload.request.ConsumerBusinessRequest;
import com.cognizant.pas.consumer.payload.response.BusinessPropertyDetails;
import com.cognizant.pas.consumer.payload.response.ConsumerBusinessDetails;
import com.cognizant.pas.consumer.payload.response.MessageResponse;
import com.cognizant.pas.consumer.repository.BusinessMasterRepository;
import com.cognizant.pas.consumer.repository.BusinessRepository;
import com.cognizant.pas.consumer.repository.ConsumerRepository;
import com.cognizant.pas.consumer.repository.PropertyMasterRepository;
import com.cognizant.pas.consumer.repository.PropertyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	BusinessRepository businessRepository;

	@Autowired
	ConsumerRepository consumerRepository;

	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	BusinessMasterRepository businessMasterRepository;

	@Autowired
	PropertyMasterRepository propertyMasterRepository;

	@Override
	public MessageResponse createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest) {
		log.info("Start createConsumerBusiness Service");
		Consumer consumer = new Consumer(consumerBusinessRequest.getFirstname(), consumerBusinessRequest.getLastname(),
				consumerBusinessRequest.getDob(), consumerBusinessRequest.getBusinessname(),
				consumerBusinessRequest.getPandetails(), consumerBusinessRequest.getEmail(),
				consumerBusinessRequest.getPhone(), consumerBusinessRequest.getWebsite(),
				consumerBusinessRequest.getBusinessoverview(), consumerBusinessRequest.getValidity(),
				consumerBusinessRequest.getAgentname(), consumerBusinessRequest.getAgentid());
		log.debug("Consumer: {}", consumer);
		Consumer consumersave = consumerRepository.save(consumer);
		log.debug("Consumer Save: {}", consumersave);
		Long businessvalue = calBusinessValue(consumerBusinessRequest.getBusinessturnover(),
				consumerBusinessRequest.getCapitalinvested());
		log.debug("BusinessValue: {}", businessvalue);
		Business business = new Business(consumersave.getId(), consumerBusinessRequest.getBusinesscategory(),
				consumerBusinessRequest.getBusinesstype(), consumerBusinessRequest.getBusinessturnover(),
				consumerBusinessRequest.getCapitalinvested(), consumerBusinessRequest.getTotalemployees(),
				businessvalue, consumerBusinessRequest.getBusinessage());
		log.debug("Business: {}", business);
		Business businesssave = businessRepository.save(business);
		log.debug("Business Save: {}", businesssave);
		log.info("End createConsumerBusinessService");
		return new MessageResponse("SuccessFully Created Consumer with Consumer ID :" + consumersave.getId()
				+ " and Business ID :" + businesssave.getId() + " . Thank you!!");
	}

	@Override
	public Long calBusinessValue(Long businessturnover, Long capitalinvested) {
		log.info("Start CalBusinessValue");
		if (businessturnover == 0 || capitalinvested == 0 || (businessturnover == capitalinvested)) {
			throw new NullPointerException("NullPointerException in CalBusinessValue");
		}

		Double x_ratio = (double) (businessturnover / capitalinvested);
		log.debug("X_ratio: {}", x_ratio);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) businessturnover;
		Double x_min = (double) capitalinvested;
		Double range_diff = (double) (Range_max - Range_min);
		log.debug("range_diff : {}", range_diff);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		log.debug("(x_ratio - x_min) / (x_max - x_min): {}", sat);
		Double businessvalue = (range_diff * sat);
		log.debug("BusinessValue: {}", businessvalue);
		log.info("End CalBusinessValue");
		return (long)  Math.abs(Math.round(businessvalue));
	}

	@Override
	public MessageResponse updateConsumerBusiness(ConsumerBusinessDetails consumerBusinessDetails)
			throws BusinessPropertyNotFoundException {
		log.info("Start updateConsumerBusinessService");
		Optional<Consumer> consumer = consumerRepository.findById(consumerBusinessDetails.getConsumerId());
		log.debug("Consumer Set: {}", consumer);
		Consumer consumers = consumer.get();
		log.debug("Consumer: {}", consumers);

		Business business = businessRepository.findByConsumerId(consumerBusinessDetails.getConsumerId());
		log.debug("Business: {}", business);
		consumers.setFirstname(consumerBusinessDetails.getFirstname());
		consumers.setLastname(consumerBusinessDetails.getLastname());
		consumers.setDob(consumerBusinessDetails.getDob());
		consumers.setBusinessname(consumerBusinessDetails.getBusinessname());
		consumers.setPandetails(consumerBusinessDetails.getPandetails());
		consumers.setEmail(consumerBusinessDetails.getEmail());
		consumers.setPhone(consumerBusinessDetails.getPhone());
		consumers.setWebsite(consumerBusinessDetails.getWebsite());
		consumers.setBusinessname(consumerBusinessDetails.getBusinessname());
		consumers.setBusinessoverview(consumerBusinessDetails.getBusinessoverview());
		consumers.setValidity(consumerBusinessDetails.getValidity());
		consumers.setAgentname(consumerBusinessDetails.getAgentname());
		consumers.setAgentid(consumerBusinessDetails.getAgentid());

		Consumer consumersave = consumerRepository.save(consumers);
		log.debug("Consumer Save: {}", consumersave);
		business.setBusinesscategory(consumerBusinessDetails.getBusinesscategory());
		business.setBusinesstype(consumerBusinessDetails.getBusinesscategory());
		business.setBusinessturnover(consumerBusinessDetails.getBusinessturnover());
		business.setCapitalinvested(consumerBusinessDetails.getCapitalinvested());
		business.setTotalemployees(consumerBusinessDetails.getTotalemployees());
		business.setBusinessvalue(calBusinessValue(business.getBusinessturnover(), business.getCapitalinvested()));
		business.setBusinessage(consumerBusinessDetails.getBusinessage());

		Business businesssave = businessRepository.save(business);
		log.debug("Business Save: {}", businesssave);
		log.info("End updateConsumerBusinessService");
		return new MessageResponse("Successfully Updated Consumer with Consumer ID: " + consumersave.getId()
				+ "and Business ID: " + businesssave.getId() + " . Thank you!");
	}

	@Override
	public ConsumerBusinessDetails viewConsumerBusiness(Long consumerid) throws ConsumerBusinessNotFoundException {
		log.info("Start viewConsumerBusinessService");
		Optional<Consumer> consumer = Optional.ofNullable(
				consumerRepository.findById(consumerid).orElseThrow(() -> new ConsumerBusinessNotFoundException()));
		log.debug("Consumer List : {}", consumer);
		Consumer consumers = consumer.get();
		log.debug("Consumer : {}", consumers);
		Business business = businessRepository.findByConsumerId(consumerid);
		log.debug("Business : {}", business);
		ConsumerBusinessDetails consumerBusinessDetails = new ConsumerBusinessDetails(consumers.getFirstname(),
				consumers.getLastname(), consumers.getDob(), consumers.getBusinessname(), consumers.getPandetails(),
				consumers.getEmail(), consumers.getPhone(), consumers.getWebsite(), consumers.getBusinessoverview(),
				consumers.getValidity(), consumers.getAgentname(), consumers.getAgentid(), business.getId(),
				business.getConsumerId(), business.getBusinesscategory(), business.getBusinesstype(),
				business.getBusinessturnover(), business.getCapitalinvested(), business.getTotalemployees(),
				business.getBusinessvalue(), business.getBusinessage()

		);
		log.debug("ConsumerBusinessDetails : {}", consumerBusinessDetails);
		log.info("End viewConsumerBusinessService");
		return consumerBusinessDetails;
	}

	@Override
	public MessageResponse createBusinessProperty(BusinessPropertyRequest businessPropertyRequest) {
		log.info("Start createConsumerBusinessService");
		Long propertyValue = calPropertyValue(businessPropertyRequest.getCostoftheasset(),
				businessPropertyRequest.getSalvagevalue(), businessPropertyRequest.getUsefullifeoftheAsset());
		log.debug("propertyValue : {}", propertyValue);
		Property property = new Property(businessPropertyRequest.getBusinessId(),
				businessPropertyRequest.getConsumerId(), businessPropertyRequest.getInsurancetype(),
				businessPropertyRequest.getPropertytype(), businessPropertyRequest.getBuildingsqft(),
				businessPropertyRequest.getBuildingtype(), businessPropertyRequest.getBuildingstoreys(),
				businessPropertyRequest.getBuildingage(), propertyValue, businessPropertyRequest.getCostoftheasset(),
				businessPropertyRequest.getSalvagevalue(), businessPropertyRequest.getUsefullifeoftheAsset());
		log.debug("property : {}", property);
		Property propertysave = propertyRepository.save(property);
		log.debug("propertysave : {}", propertysave);
		log.info("End createConsumerBusinessService");
		return new MessageResponse(
				"SuccessFully Created Business Property with Property Id: " + propertysave.getId() + " . Thank you!!");
	}

	@Override
	public Long calPropertyValue(Long costoftheasset, Long salvagevalue, Long usefullifeoftheAsset) {
		log.info("Start calPropertyValue");
		if (usefullifeoftheAsset == 0 || salvagevalue == 0 || costoftheasset == 0 || (costoftheasset == salvagevalue)) {
			throw new NullPointerException("NullPointerException in calPropertyValue");
		}
		Double x_ratio = (double) ((costoftheasset - salvagevalue) / usefullifeoftheAsset);
		log.debug("x_ratio : {}", x_ratio);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) (costoftheasset / usefullifeoftheAsset);
		log.debug("x_max : {}", x_max);
		Double x_min = (double) (salvagevalue / usefullifeoftheAsset);
		log.debug("x_min : {}", x_min);
		Double range_diff = (Range_max - Range_min);
		log.debug("range_diff : {}", range_diff);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		log.debug("(x_ratio - x_min) / (x_max - x_min): {}", sat);
		Double propertyvalue = range_diff * sat;
		log.debug("propertyvalue  : {}", propertyvalue);
		log.info("End calPropertyValue");
		return (long) Math.abs(Math.round(propertyvalue));
	}

	@Override
	public MessageResponse updateBusinessProperty(BusinessPropertyDetails businessPropertyDetails) {
		log.info("Start updateBusinessPropertyService");
		Property property = propertyRepository.findByConsumerId(businessPropertyDetails.getConsumerId());
		log.debug("property  : {}", property);
		Long propertyValue = calPropertyValue(businessPropertyDetails.getCostoftheasset(),
				businessPropertyDetails.getSalvagevalue(), businessPropertyDetails.getUsefullifeoftheAsset());
		log.debug("propertyValue  : {}", propertyValue);
		property.setInsurancetype(businessPropertyDetails.getInsurancetype());
		property.setPropertytype(businessPropertyDetails.getPropertytype());
		property.setBuildingsqft(businessPropertyDetails.getBuildingsqft());
		property.setBuildingtype(businessPropertyDetails.getBuildingtype());
		property.setBuildingstoreys(businessPropertyDetails.getBuildingstoreys());
		property.setBuildingage(businessPropertyDetails.getBuildingage());
		property.setPropertyvalue(propertyValue);
		property.setCostoftheasset(businessPropertyDetails.getCostoftheasset());
		property.setSalvagevalue(businessPropertyDetails.getSalvagevalue());
		property.setUsefullifeoftheAsset(businessPropertyDetails.getUsefullifeoftheAsset());

		Property propertysave = propertyRepository.save(property);
		log.debug("propertysave  : {}", propertysave);
		log.info("End updateBusinessPropertyService");
		return new MessageResponse(
				"SuccessFully Updated Business Property with Property Id :" + propertysave.getId() + " . Thank you!");
	}

	@Override
	public Property viewConsumerProperty(Long consumerid, Long propertyid) {
		log.info("Start viewConsumerPropertyService");
		Property property = propertyRepository.findByConsumerId(consumerid);
		log.debug("property  : {}", property);
		log.info("End viewConsumerPropertyService");
		return property;
	}

	@Override
	public Boolean checkBusinessEligibility(ConsumerBusinessRequest consumerBusinessRequest) throws Exception{
		Boolean check = false;
		log.info("Start checkBusinessEligibility");
		
		BusinessMaster businessMaster = businessMasterRepository.findByBusinesscategoryAndBusinesstype(
				consumerBusinessRequest.getBusinesscategory(), consumerBusinessRequest.getBusinesstype());
		if(businessMaster==null)
		{
			return check;
		}
		log.debug("Business Master {}", businessMaster);
		if (businessMaster.getTotalemployees() <= consumerBusinessRequest.getTotalemployees()
				|| businessMaster.getBusinessage() <= consumerBusinessRequest.getBusinessage()) {
			check = true;
			log.debug("Vaule of Check {}", check);
		}
		log.debug("Vaule of Check {}", check);
		log.info("End checkBusinessEligibility");
		return check;
	}

	@Override
	public Boolean checkPropertyEligibility(String propertytype, String insurancetype, String buildingtype, Long buildingage)throws Exception{
		log.info("Start checkPropertyEligibility");
		Boolean check = false;
		PropertyMaster propertyMaster = propertyMasterRepository.findByPropertytypeAndInsurancetypeAndBuildingtype(
				propertytype, insurancetype,
				buildingtype);
		if(propertyMaster==null)
		{
			return check;
		}
		log.debug("propertyMaster {}", propertyMaster);
		if (propertyMaster.getBuildingage() <= buildingage) {
			check = true;
			log.debug("Vaule of Check {}", check);
		}
		log.debug("Vaule of Check {}", check);
		log.info("End checkPropertyEligibility");
		return check;
	}

}
