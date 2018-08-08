package com.gohenry.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gohenry.springbootdemo.request.InsertParentRequest;
import com.gohenry.springbootdemo.response.InsertParentResponse;
import com.gohenry.springbootdemo.service.ParentService;

@RestController
public class RestConrtoller {
	
	@Autowired
	private ParentService parentService;
	
	@RequestMapping(value = "/parents", method = RequestMethod.POST, produces = "APPLICATION/JSON", consumes="APPLICATION/JSON")
	public InsertParentResponse createParent(@RequestBody InsertParentRequest insertParentRequest){
		System.out.println("in rest controller"); 
		 return parentService.createParent(insertParentRequest);
		
	}
	

}
