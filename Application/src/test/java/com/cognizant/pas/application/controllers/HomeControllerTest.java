package com.cognizant.pas.application.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.cognizant.pas.application.restclients.FeignPolicyClient;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

	@MockBean
	private FeignPolicyClient feignPolicyClient;
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testDisplayHomePage_returnsStatusOk() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
//	@Test
//	public void testViewPolicy() throws Exception {
//		String mock= "asd";
//		Object m = mock;
//		when(feignPolicyClient.viewPolicy(anyString(), anyLong(), any())).thenReturn(new PolicyDetailsResponse((long)1, "mock_id", "mock_type", "mock_type", "mock_type", "mock_type", (long)1, (long)1, "mock_type", "mock_type", (long)1, "mock_type", "mock_type", "mock_type", "mock_type", "mock_type","mock_type", "mock_type"));
//		mockMvc.perform(get("/viewPolicy").sessionAttr("1", m).param("consumerid","asd").param("policyid", "asd")).andExpect(status().isOk());
//	}
}
