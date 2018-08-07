package com.gohenry.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gohenry.springbootdemo.service.ParentService;

@RestController
public class RestConrtoller {
	
	@Autowired
	private ParentService parentService;
	
	

}
