package com.cognizant.pas.consumer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ConsumerServiceTests {
	
	@InjectMocks
	private ConsumerServiceImpl consumerService;
	
	
	@Test
    public void testCalculateBusinessValue() throws Exception {
		long res=consumerService.calBusinessValue((long)1,(long)2);
		assertEquals((long)20, res);
    }
	
	@Test
    public void testCalculatePropertyValue() throws Exception {
		long res=consumerService.calPropertyValue((long)200,(long)20,(long)13);
		assertEquals((long)9, res);
    }
	
	
	

}
