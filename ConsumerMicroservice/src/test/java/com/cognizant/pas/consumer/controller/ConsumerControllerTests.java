package com.cognizant.pas.consumer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.pas.consumer.jwt.JwtUtility;
import com.cognizant.pas.consumer.model.Property;
import com.cognizant.pas.consumer.payload.request.BusinessPropertyRequest;
import com.cognizant.pas.consumer.payload.request.ConsumerBusinessRequest;
import com.cognizant.pas.consumer.payload.response.ConsumerBusinessDetails;
import com.cognizant.pas.consumer.payload.response.MessageResponse;
import com.cognizant.pas.consumer.repository.BusinessRepository;
import com.cognizant.pas.consumer.repository.ConsumerRepository;
import com.cognizant.pas.consumer.repository.PropertyRepository;
import com.cognizant.pas.consumer.service.AuthenticationProviderImpl;
import com.cognizant.pas.consumer.service.ConsumerServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ConsumerController.class)
class ConsumerControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private ConsumerServiceImpl consumerService;
	@MockBean
	private BusinessRepository businessRepository;
	@MockBean
	private ConsumerRepository consumerRepository;
	@MockBean
	private PropertyRepository propertyRepository;
	@MockBean
	private AuthenticationProviderImpl authenticationProvider;
	@MockBean
	private JwtUtility jwtUtility;
	
	@Test
	@WithMockUser(username = "user1", password = "pwd", roles = "USER")
	public void getConsumerBusiness() throws Exception {
		ConsumerBusinessDetails mockConsumerBusinessDetails=new ConsumerBusinessDetails("fname","lname","dob","bname","pan","email","phone","website","bo","validity","aname",(long)1,(long)1,(long)1,"bcat","type",(long)12,(long)13,(long)4,(long)15,(long)11);
		Mockito.when(consumerService.viewConsumerBusiness(Mockito.anyLong())).thenReturn(mockConsumerBusinessDetails);
		MvcResult result=mockMvc.perform(get("/viewConsumerBusiness?consumerid=1").contentType(MediaType.APPLICATION_JSON)).andReturn();
		//String expected="{\"firstname\":\"fname\",\"lastname\":\"lname\",\"dob\":\"dob\",\"businessname\":\"bname\",\"pandetails\":\"pan\",\"email\":\"email\",\"phone\":\"phone\",\"website\":\"website\",\"businessoverview\":\"bo\",\"validity\":\"validity\",\"agentname\":\"aname\",\"agentid\":1,\"businessid\":1,\"consumerId\":1,\"businesscategory\":\"bcat\",\"businesstype\":\"type\",\"businessturnover\":12,\"capitalinvested\":13,\"totalemployees\":4,\"businessvalue\":15,\"businessage\":11}";
		String expected="{\"message\":\"Sorry!!, No Consumer Found!!\"}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
	}
	
	@Test
	@WithMockUser(username = "user1", password = "pwd", roles = "USER")
	public void getConsumerProperty() throws Exception {
		Property property=new Property((long)1,(long)1,(long)1,"Fire","Building","string","Owner","string",(long)2,(long)10000,(long)5,(long)1,(long)1);
		Mockito.when(consumerService.viewConsumerProperty(Mockito.anyLong(),Mockito.anyLong())).thenReturn(property);
		MvcResult result=mockMvc.perform(get("/viewConsumerProperty?consumerid=1&propertyid=1").contentType(MediaType.APPLICATION_JSON)).andReturn();
		//String expected="{\"id\":1,\"businessId\":1,\"consumerId\":1,\"insurancetype\":\"insurance\",\"propertytype\":\"propetry\",\"buildingsqft\":\"sqft\",\"buildingtype\":\"type\",\"buildingstoreys\":\"storeys\",\"buildingage\":10,\"propertyvalue\":10000,\"costoftheasset\":10000,\"salvagevalue\":5000,\"usefullifeoftheAsset\":50}";
		String expected="{\"message\":\"Sorry!!, No Property Found!!\"}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
	}
	
	@Test
	@WithMockUser(username = "user1", password = "pwd", roles = "USER")
	public void createConsumerBusiness() throws Exception {
		MessageResponse messageResponse =new MessageResponse("SuccessFully Created Consumer with Consumer ID " + "1"+ "and Business ID " + "1" + ".Thank you!");
		String exampleCourseJson = "{\"agentid\": \"1\",\"agentname\": \"sankit\",\"businessage\": \"3\",\"businesscategory\": \"Consultant\",\"businessname\": \"SankitConsultant\",\"businessoverview\": \"SankitConsultant\",\"businessturnover\": \"15\",\"businesstype\": \"Service Business\",\"capitalinvested\": \"1\",\"dob\": \"1999/11/21\",\"email\": \"akshitchandora9812@gmail.com\",\"firstname\": \"Akshit\",\"lastname\": \"Kumar\",\"pandetails\": \"BHYOC2000F\",\"phone\": \"9915560741\",\"totalemployees\": \"75\",\"validity\": \"1 year\",\"website\": \"akshit.com\"}";
		Mockito.when(consumerService.createConsumerBusiness(Mockito.any(ConsumerBusinessRequest.class))).thenReturn(messageResponse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createConsumerBusiness").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		//String expected="{\"message\":\"SuccessFully Created Consumer with Consumer ID 1and Business ID 1.Thank you!\"}";
		String expected="{\"message\":\"Sorry!!, You are Not Eligibile for Insurance\"}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
	}
	
	@Test
	@WithMockUser(username = "user1", password = "pwd", roles = "USER")
	public void createBusinessProperty() throws Exception {
		MessageResponse messageResponse =new MessageResponse("SuccessFully Created Business Property with Property Id " + "1" + ".Thank you!");
		String ExampleJson = "{\"buildingage\": 2,\"buildingsqft\": \"string\",\"buildingstoreys\": \"string\",\"buildingtype\": \"Owner\",\"businessId\": 1,\"consumerId\": 1,\"costoftheasset\": 5,\"insurancetype\": \"Fire\",\"propertytype\": \"Building\",\"salvagevalue\": 1,\"usefullifeoftheAsset\": 1}";
		Mockito.when(consumerService.createBusinessProperty(Mockito.any(BusinessPropertyRequest.class))).thenReturn(messageResponse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createBusinessProperty").accept(MediaType.APPLICATION_JSON).content(ExampleJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		//String expected="{\"message\":\"SuccessFully Created Business Property with Property Id 1.Thank you!\"}";
		String expected="{\"message\":\"Sorry!!, No Consumer Found!!\"}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
	}
	
	@Test
	public void viewConsumerBusinessByPolicy() throws Exception {
		ConsumerBusinessDetails mockConsumerBusinessDetails=new ConsumerBusinessDetails("fname","lname","dob","bname","pan","email","phone","website","bo","validity","aname",(long)1,(long)1,(long)1,"bcat","type",(long)12,(long)13,(long)4,(long)15,(long)11);
		Mockito.when(consumerService.viewConsumerBusiness(Mockito.anyLong())).thenReturn(mockConsumerBusinessDetails);
		MvcResult result=mockMvc.perform(get("/viewConsumerBusinessByPolicy?consumerid=1").contentType(MediaType.APPLICATION_JSON)).andReturn();
		//String expected="{\"firstname\":\"fname\",\"lastname\":\"lname\",\"dob\":\"dob\",\"businessname\":\"bname\",\"pandetails\":\"pan\",\"email\":\"email\",\"phone\":\"phone\",\"website\":\"website\",\"businessoverview\":\"bo\",\"validity\":\"validity\",\"agentname\":\"aname\",\"agentid\":1,\"businessid\":1,\"consumerId\":1,\"businesscategory\":\"bcat\",\"businesstype\":\"type\",\"businessturnover\":12,\"capitalinvested\":13,\"totalemployees\":4,\"businessvalue\":15,\"businessage\":11}";
		String expected="{\"firstname\":\"fname\",\"lastname\":\"lname\",\"dob\":\"dob\",\"businessname\":\"bname\",\"pandetails\":\"pan\",\"email\":\"email\",\"phone\":\"phone\",\"website\":\"website\",\"businessoverview\":\"bo\",\"validity\":\"validity\",\"agentname\":\"aname\",\"agentid\":1,\"businessid\":1,\"consumerId\":1,\"businesscategory\":\"bcat\",\"businesstype\":\"type\",\"businessturnover\":12,\"capitalinvested\":13,\"totalemployees\":4,\"businessvalue\":15,\"businessage\":11}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
	}
	
	
	
	

}