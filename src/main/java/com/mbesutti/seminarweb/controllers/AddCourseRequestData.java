package com.mbesutti.seminarweb.controllers;

import java.util.HashMap;
import java.util.Map;

import com.mbesutti.seminarweb.validation.DateFormatRule;
import com.mbesutti.seminarweb.validation.MaxLengthRule;
import com.mbesutti.seminarweb.validation.MaxNumRule;
import com.mbesutti.seminarweb.validation.MultiRule;
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
		Map<String,String> errors = new HashMap<String,String>();
		
		new MultiRule().add(new NotEmptyRule())
					   .add(new MaxLengthRule(15))
				.validate("name", name, errors);
		new MultiRule().add(new NotEmptyRule())
					   .add(new MaxLengthRule(20))
				.validate("start", date, errors);
		new NotEmptyRule().validate("location", location, errors);

		new MultiRule().add(new NotEmptyRule())
				         .add(new PositiveRule())
				         .add(new MaxNumRule(100))
				.validate("seats", seats, errors);

		new DateFormatRule().validate("date", date, errors);
		
		return errors;
	}

	public String getName() {
		return name;
	}

	public AddCourseRequestData setName(String name) {
		this.name = name != null ? name : "";
		return this;
	}

	public String getDescription() {
		return description;
	}

	public AddCourseRequestData setDescription(String description) {
		this.description = description != null ? description : "";
		return this;
	}

	public String getDate() {
		return date;
	}

	public AddCourseRequestData setDate(String date) {
		this.date = date != null ? date : "";
		return this;
	}

	public String getSeats() {
		return seats;
	}

	public AddCourseRequestData setSeats(String seats) {
		this.seats = seats != null ? seats : "";
		return this;
	}

	public String getLocation() {
		return location;
	}

	public AddCourseRequestData setLocation(String location) {
		this.location = location != null ? location : "";
		return this;
	}

	public String getPartecipants() {
		return partecipants;
	}

	public AddCourseRequestData setPartecipants(String partecipants) {
		this.partecipants = partecipants != null ? partecipants : "";
		return this;
	}

}
