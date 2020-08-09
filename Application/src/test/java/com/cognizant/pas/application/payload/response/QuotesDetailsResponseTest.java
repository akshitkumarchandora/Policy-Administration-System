
//junit of class QuotesDetailsResponse

package com.cognizant.pas.application.payload.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jparams.verifier.tostring.ToStringVerifier;


@ExtendWith(MockitoExtension.class)
class QuotesDetailsResponseTest {


	private QuotesDetailsResponse qr;
	private QuotesDetailsResponse qdr;
	@BeforeEach()
    public void setUp() {
		qr=new QuotesDetailsResponse();
		qr.setQuotes("quotes");
		qdr=new QuotesDetailsResponse("demo");
		}
	
	
	 @Test
	    public void testAllGettersAndSettersOfQuotes() {
	       
	        assertEquals("quotes",qr.getQuotes());
	        
	    }
		@Test
		 public void testAllArgsConstructorOfQuotes() {
			 assertEquals("demo",qdr.getQuotes());
		}
		@Test
		 public void testToStringConstructorOfQuotes() {
			ToStringVerifier.forClass(QuotesDetailsResponse.class).verify();
		}

}
