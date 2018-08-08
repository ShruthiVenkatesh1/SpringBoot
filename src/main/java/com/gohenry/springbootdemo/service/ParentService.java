package com.gohenry.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gohenry.springbootdemo.entity.Parent;
import com.gohenry.springbootdemo.repository.ParentRepository;
import com.gohenry.springbootdemo.request.InsertParentRequest;
import com.gohenry.springbootdemo.response.InsertParentResponse;

@Component
public class ParentService {

	@Autowired
	private ParentRepository parentRepository;
	
	public InsertParentResponse createParent(InsertParentRequest insertParentRequest){
		System.out.println("in service");
		Parent parent = constructParent(insertParentRequest);
		parent = parentRepository.saveAndFlush(parent);
		InsertParentResponse insertParentResponse = constructResponse(parent);
		return insertParentResponse;
	}

	private Parent constructParent(InsertParentRequest insertParentRequest) { 
		Parent parent = new Parent();
		parent.setTitle(insertParentRequest.getTitle()); 
		parent.setFirstName(insertParentRequest.getFirstName());
		parent.setLastName(insertParentRequest.getLastName());
		parent.setSecondName(insertParentRequest.getSecondName());
		parent.setEmailAddress(insertParentRequest.getEmailAddress());
		parent.setGender(insertParentRequest.getGender());
		parent.setDateOfBirth(insertParentRequest.getDateOfBirth());
//		parent.setChildern(insertParentRequest.getChildren());
		return parent;
	}

	private InsertParentResponse constructResponse(Parent parent) { 
		InsertParentResponse insertParentResponse = new InsertParentResponse();
		insertParentResponse.setId(parent.getId().toString());
		insertParentResponse.setTitle(parent.getTitle());
		insertParentResponse.setFirstName(parent.getFirstName());
		insertParentResponse.setLastName(parent.getLastName());
		insertParentResponse.setSecondName(parent.getSecondName());
		insertParentResponse.setEmailAddress(parent.getEmailAddress());
		insertParentResponse.setGender(parent.getGender());
		insertParentResponse.setDateOfBirth(parent.getDateOfBirth());
//		insertParentResponse.setChildren(parent.getChildern());
		
		return insertParentResponse;
	}
}
