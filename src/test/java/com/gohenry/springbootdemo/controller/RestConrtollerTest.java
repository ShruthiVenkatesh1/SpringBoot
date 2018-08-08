package com.gohenry.springbootdemo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.gohenry.springbootdemo.request.InsertParentRequest;
import com.gohenry.springbootdemo.response.InsertParentResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestConrtollerTest {

	@Autowired
	private TestRestTemplate restTemplete;
	
	@Test
	public void testCreateParent() {
		InsertParentRequest request = new InsertParentRequest();
		request.setFirstName("Shruthi"); 
		request.setLastName("Venkatesh");
		request.setEmailAddress("s.v@gmail.com");
		request.setDateOfBirth("01-01-1999");
		request.setGender("Female");
		request.setTitle("Mrs");
//		request.setChildren("");
		request.setSecondName("s"); 
		ResponseEntity<InsertParentResponse> responseEntity = 
				restTemplete.postForEntity("/parents", request, InsertParentResponse.class);
		assertNotNull(responseEntity); 
		InsertParentResponse insertParentResponse = responseEntity.getBody();
		assertEquals("Shruthi", insertParentResponse.getFirstName()); 
		assertEquals("Venkatesh", insertParentResponse.getLastName()); 
		assertEquals("s.v@gmail.com", insertParentResponse.getEmailAddress()); 
		assertEquals("01-01-1999", insertParentResponse.getDateOfBirth()); 
		assertEquals("Female", insertParentResponse.getGender()); 
//		assertEquals("", insertParentResponse.getFirstName()); 
		assertEquals("s", insertParentResponse.getSecondName()); 
	}

	
}
