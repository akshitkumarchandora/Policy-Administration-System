package com.cognizant.pas.policy.payload.response;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)

class QuotesDetailsResponseTest {
	private QuotesDetailsResponse qdr;

	@Test
	public void testAllGettersAndSettersOfQuotesDetailsResponse() {
		qdr = new QuotesDetailsResponse();
		qdr.setQuotes("Quotes");
		assertEquals("Quotes",qdr.getQuotes());
	}
	
	@Test
	public void testQuotesDetailsResponseConstructor() {
		qdr = new QuotesDetailsResponse("Quotes");
		assertEquals("Quotes",qdr.getQuotes());
	}
	

}
