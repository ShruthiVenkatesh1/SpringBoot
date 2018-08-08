package com.gohenry.springbootdemo.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gohenry.springbootdemo.entity.Child;
import com.gohenry.springbootdemo.entity.Parent;
import com.gohenry.springbootdemo.repository.ParentRepository;
import com.gohenry.springbootdemo.request.InsertChildRequest;
import com.gohenry.springbootdemo.request.InsertParentRequest;
import com.gohenry.springbootdemo.response.ChildResponse;
import com.gohenry.springbootdemo.response.ParentResponse;

@Component
public class ParentService {

	@Autowired
	private ParentRepository parentRepository;
	
	public ParentResponse createParent(InsertParentRequest insertParentRequest){
		Parent parent = constructParent(insertParentRequest);
		parent = parentRepository.save(parent);
		ParentResponse insertParentResponse = constructResponse(parent);
		return insertParentResponse;
	}

	public ParentResponse retrieveParent(String id){
		ParentResponse parentResponse = new ParentResponse();
		if(id!= null ){
			
			Parent parent = parentRepository.findOne(Long.valueOf(id));
			parentResponse = constructResponse(parent);
		}
		return parentResponse;
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

	private ParentResponse constructResponse(Parent parent) { 
		ParentResponse parentResponse = new ParentResponse();
		parentResponse.setId(parent.getId().toString());
		parentResponse.setTitle(parent.getTitle());
		parentResponse.setFirstName(parent.getFirstName());
		parentResponse.setLastName(parent.getLastName());
		parentResponse.setSecondName(parent.getSecondName());
		parentResponse.setEmailAddress(parent.getEmailAddress());
		parentResponse.setGender(parent.getGender());
		parentResponse.setDateOfBirth(parent.getDateOfBirth());
		if(parent.getChildern() != null){
			
		parentResponse.setChildren(parent.getChildern().stream().map(child -> constructChildResponse(child)).collect(Collectors.toList()));
		}
		
		return parentResponse;
	}

	private ChildResponse constructChildResponse(Child child) { 
		ChildResponse childResponse = new ChildResponse();
		childResponse.setId(child.getId().toString()); 
		childResponse.setTitle(child.getTitle()); 
		childResponse.setFirstName(child.getFirstName());
		childResponse.setLastName(child.getLastName());
		childResponse.setSecondName(child.getSecondName());
		childResponse.setEmailAddress(child.getEmailAddress());
		childResponse.setGender(child.getGender());
		childResponse.setDateOfBirth(child.getDateOfBirth());
		return childResponse;
	}
}
