//junit of class ConsumerBusinessDetails

package com.cognizant.pas.application.payload.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jparams.verifier.tostring.ToStringVerifier;

@ExtendWith(MockitoExtension.class)
class ConsumerBusinessDetailsTest {

	private ConsumerBusinessDetails consumerBusinessDetails;
	private ConsumerBusinessDetails cbd;

	@BeforeEach()
	public void setUp() {
		consumerBusinessDetails = new ConsumerBusinessDetails();
		consumerBusinessDetails.setAgentid((long)1);
		consumerBusinessDetails.setAgentname("test");
		consumerBusinessDetails.setBusinessage((long)1);
		consumerBusinessDetails.setBusinesscategory("test");
		consumerBusinessDetails.setBusinessname("test");
		consumerBusinessDetails.setBusinessoverview("test");
		consumerBusinessDetails.setBusinessturnover((long)1);
		consumerBusinessDetails.setBusinesstype("test");
		consumerBusinessDetails.setCapitalinvested((long)1);
		consumerBusinessDetails.setDob("test");
		consumerBusinessDetails.setEmail("test");
		consumerBusinessDetails.setFirstname("test");
		consumerBusinessDetails.setLastname("test");
		consumerBusinessDetails.setPandetails("test");
		consumerBusinessDetails.setPhone("test");
		consumerBusinessDetails.setTotalemployees((long)1);
		consumerBusinessDetails.setValidity("test");
		consumerBusinessDetails.setWebsite("test");
		consumerBusinessDetails.setBusinessid((long)1);
		consumerBusinessDetails.setConsumerId((long)1);
		cbd = new ConsumerBusinessDetails("demo", "demo", "demo", "demo", "demo", "demo", "demo", "demo", "demo",
				"demo", "demo", 1L, 2L, 3L, "demo", "demo", 1L, 2L, 3L, 4L, 5L);
	}

	@Test
	public void testtoStringOfConsumerBusiness() {
		assertEquals("demo", cbd.getAgentname());
	}

	@Test
	public void testAllArgsConstructorOfConsumerBusiness() {
		ToStringVerifier.forClass(ConsumerBusinessDetails.class).verify();
	}

	@Test
	public void testAllGettersAndSettersOfConsumerBusiness() {

		assertEquals((long)1,consumerBusinessDetails.getAgentid());
		assertEquals("test",consumerBusinessDetails.getAgentname());
		assertEquals((long)1,consumerBusinessDetails.getBusinessage());
		assertEquals("test",consumerBusinessDetails.getBusinesscategory());
		assertEquals("test",consumerBusinessDetails.getBusinessname());
		assertEquals("test",consumerBusinessDetails.getBusinessoverview());
		assertEquals((long)1,consumerBusinessDetails.getBusinessturnover());
		assertEquals("test",consumerBusinessDetails.getBusinesstype());
		assertEquals((long)1,consumerBusinessDetails.getCapitalinvested());
		assertEquals("test",consumerBusinessDetails.getDob());
		assertEquals("test",consumerBusinessDetails.getEmail());
		assertEquals("test",consumerBusinessDetails.getFirstname());
		assertEquals("test",consumerBusinessDetails.getLastname());
		assertEquals("test",consumerBusinessDetails.getPandetails());
		assertEquals("test",consumerBusinessDetails.getPhone());
		assertEquals((long)1,consumerBusinessDetails.getTotalemployees());
		assertEquals("test",consumerBusinessDetails.getValidity());
		assertEquals("test",consumerBusinessDetails.getWebsite());
		assertEquals((long)1,consumerBusinessDetails.getBusinessid());
		assertEquals((long)1,consumerBusinessDetails.getConsumerId());

	}

}
