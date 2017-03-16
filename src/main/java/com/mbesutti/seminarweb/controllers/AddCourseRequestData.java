package com.mbesutti.seminarweb.controllers;

import java.util.HashMap;
import java.util.Map;

import com.mbesutti.seminarweb.validation.DateFormatRule;
import com.mbesutti.seminarweb.validation.NotEmptyRule;
import com.mbesutti.seminarweb.validation.PositiveRule;

public class AddCourseRequestData {
	private String name;
	private String description;
	private String date;
	private String seats;
	private String location;
	private String partecipants;
	
	public Map<String,String> validate(){
		Map<String,String> errors = new HashMap<>();
		
		new NotEmptyRule("name", errors).validate(name);
		new NotEmptyRule("start", errors).validate(date);
		new NotEmptyRule("location", errors).validate(location);
		new NotEmptyRule("seats", errors).validate(seats);
		
		new PositiveRule("seats", errors).validate(seats);
		
		new DateFormatRule("date", errors).validate(date);
		
		return errors;
	}

	public String getName() {
		return name;
	}

	public AddCourseRequestData setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public AddCourseRequestData setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getDate() {
		return date;
	}

	public AddCourseRequestData setDate(String date) {
		this.date = date;
		return this;
	}

	public String getSeats() {
		return seats;
	}

	public AddCourseRequestData setSeats(String seats) {
		this.seats = seats;
		return this;
	}

	public String getLocation() {
		return location;
	}

	public AddCourseRequestData setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getPartecipants() {
		return partecipants;
	}

	public AddCourseRequestData setPartecipants(String partecipants) {
		this.partecipants = partecipants;
		return this;
	}

}
