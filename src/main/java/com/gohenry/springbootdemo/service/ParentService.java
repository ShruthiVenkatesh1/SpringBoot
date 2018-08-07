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
		
		Parent parent = new Parent();
		parent = parentRepository.saveAndFlush(parent);
		InsertParentResponse insertParentResponse = constructResponse(parent);
		return insertParentResponse;
	}

	private InsertParentResponse constructResponse(Parent parent) { 
		return null;
	}
}
