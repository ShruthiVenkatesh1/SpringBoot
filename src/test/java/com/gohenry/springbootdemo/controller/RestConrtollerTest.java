package com.gohenry.springbootdemo.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.gohenry.springbootdemo.request.InsertChildRequest;
import com.gohenry.springbootdemo.request.InsertParentRequest;
import com.gohenry.springbootdemo.response.InsertChildResponse;
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
		request.setSecondName("s");
		ResponseEntity<InsertParentResponse> responseEntity = restTemplete.postForEntity("/parents", request,
				InsertParentResponse.class);
		assertNotNull(responseEntity);
		InsertParentResponse insertParentResponse = responseEntity.getBody();
		assertEquals("Shruthi", insertParentResponse.getFirstName());
		assertEquals("Venkatesh", insertParentResponse.getLastName());
		assertEquals("s.v@gmail.com", insertParentResponse.getEmailAddress());
		assertEquals("01-01-1999", insertParentResponse.getDateOfBirth());
		assertEquals("Female", insertParentResponse.getGender());
		assertEquals("s", insertParentResponse.getSecondName());
	}

	@Test
	public void testCreateParentWithOneChild() {
		InsertParentRequest request = new InsertParentRequest();
		request.setFirstName("Shruthi");
		request.setLastName("Venkatesh");
		request.setEmailAddress("s.v@gmail.com");
		request.setDateOfBirth("01-01-1999");
		request.setGender("Female");
		request.setTitle("Mrs");
		InsertChildRequest childRequest = new InsertChildRequest();
		childRequest.setFirstName("Shru");
		childRequest.setLastName("V");
		childRequest.setEmailAddress("s.v12@gmail.com");
		childRequest.setDateOfBirth("01-01-2016");
		childRequest.setGender("Female");
		childRequest.setTitle("ms");
		List<InsertChildRequest> childList = new ArrayList<InsertChildRequest>();
		childList.add(childRequest);
		request.setChildren(childList);
		request.setSecondName("s");
		ResponseEntity<InsertParentResponse> responseEntity = restTemplete.postForEntity("/parents", request,
				InsertParentResponse.class);
		assertNotNull(responseEntity);
		InsertParentResponse insertParentResponse = responseEntity.getBody();
		assertEquals("Shruthi", insertParentResponse.getFirstName());
		assertEquals("Venkatesh", insertParentResponse.getLastName());
		assertEquals("s.v@gmail.com", insertParentResponse.getEmailAddress());
		assertEquals("01-01-1999", insertParentResponse.getDateOfBirth());
		assertEquals("Female", insertParentResponse.getGender());
		assertEquals("s", insertParentResponse.getSecondName());
		assertEquals("Mrs", insertParentResponse.getTitle());
		insertParentResponse.getChildren().forEach(child -> verifyChild(child)); 
	}

	private Object verifyChild(InsertChildResponse child) {
		// TODO Auto-generated method stub
		assertEquals("Shru", child.getFirstName());
		assertEquals("V", child.getLastName());
		assertEquals("s.v12@gmail.com", child.getEmailAddress());
		assertEquals("01-01-2016", child.getDateOfBirth());
		assertEquals("Female", child.getGender());
		assertEquals("ms", child.getTitle());
		return null;
	}
}
