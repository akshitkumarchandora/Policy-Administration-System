package com.cognizant.pas.quotes.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import com.cognizant.pas.quotes.models.QuotesMaster;
import com.cognizant.pas.quotes.repository.QuotesMasterRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = QuotesController.class)
class QuotesMicroserviceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private QuotesMasterRepository quotesMasterRepository;

	@Test
	public void getQuotesForPolicy() throws Exception {
		QuotesMaster quotes = new QuotesMaster((long) 11, (long) 1, (long) 1, "type", "quotes");
		Mockito.when(quotesMasterRepository.findByBusinessValueAndPropertyValueAndPropertyType(Mockito.anyLong(),
				Mockito.anyLong(), Mockito.anyString())).thenReturn(quotes);
		MvcResult result = mockMvc.perform(get("/getQuotesForPolicy?businessValue=1&propertyValue=1&propertyType=type"))
				.andReturn();
		String expected = "quotes";
		System.out.println(result.getResponse().getContentAsString());
		System.out.println(expected);
		assertEquals(expected, result.getResponse().getContentAsString());
	}

	@Test
	public void getQuotesForPolicyError() throws Exception {
		MvcResult result = mockMvc
				.perform(get("/getQuotesForPolicy?businessValue=1000&propertyValue=91&propertyType=types")).andReturn();
		assertEquals("No Quotes, Contact Insurance Provider", result.getResponse().getContentAsString());
	}

}
