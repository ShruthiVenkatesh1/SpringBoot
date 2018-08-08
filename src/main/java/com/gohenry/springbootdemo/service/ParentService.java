package com.gohenry.springbootdemo.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gohenry.springbootdemo.entity.Child;
import com.gohenry.springbootdemo.entity.Parent;
import com.gohenry.springbootdemo.repository.ParentRepository;
import com.gohenry.springbootdemo.request.InsertChildRequest;
import com.gohenry.springbootdemo.request.InsertParentRequest;
import com.gohenry.springbootdemo.response.InsertChildResponse;
import com.gohenry.springbootdemo.response.InsertParentResponse;

@Component
public class ParentService {

	@Autowired
	private ParentRepository parentRepository;
	
	public InsertParentResponse createParent(InsertParentRequest insertParentRequest){
		System.out.println("in service");
		Parent parent = constructParent(insertParentRequest);
		parent = parentRepository.save(parent);
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
		if(insertParentRequest.getChildren() != null){
			parent.setChildern(insertParentRequest.getChildren().stream().map(child -> constructChild(child)).collect(Collectors.toList()));  
		}
		return parent;
	}

	private Child constructChild(InsertChildRequest childRequest) {
		Child child = new Child();
		child.setTitle(childRequest.getTitle()); 
		child.setFirstName(childRequest.getFirstName());
		child.setLastName(childRequest.getLastName());
		child.setSecondName(childRequest.getSecondName());
		child.setEmailAddress(childRequest.getEmailAddress());
		child.setGender(childRequest.getGender());
		child.setDateOfBirth(childRequest.getDateOfBirth());
		return child;
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
		if(parent.getChildern() != null){
			
		insertParentResponse.setChildren(parent.getChildern().stream().map(child -> constructChildResponse(child)).collect(Collectors.toList()));
		}
		
		return insertParentResponse;
	}

	private InsertChildResponse constructChildResponse(Child child) { 
		InsertChildResponse insertChildResponse = new InsertChildResponse();
		insertChildResponse.setId(child.getId().toString()); 
		insertChildResponse.setTitle(child.getTitle()); 
		insertChildResponse.setFirstName(child.getFirstName());
		insertChildResponse.setLastName(child.getLastName());
		insertChildResponse.setSecondName(child.getSecondName());
		insertChildResponse.setEmailAddress(child.getEmailAddress());
		insertChildResponse.setGender(child.getGender());
		insertChildResponse.setDateOfBirth(child.getDateOfBirth());
		return insertChildResponse;
	}
}
