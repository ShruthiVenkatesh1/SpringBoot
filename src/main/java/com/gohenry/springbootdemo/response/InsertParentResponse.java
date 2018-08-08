package com.gohenry.springbootdemo.response;

import java.util.List;

import com.gohenry.springbootdemo.request.InsertChildRequest;

public class InsertParentResponse {

	private String id;
	
	private String title;

	private String firstName;

	private String lastName;

	private String emailAddress;

	private String dateOfBirth;

	private String gender;

	private String secondName;

	private List<InsertChildRequest> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public List<InsertChildRequest> getChildren() {
		return children;
	}

	public void setChildren(List<InsertChildRequest> children) {
		this.children = children;
	}
	
	
}
