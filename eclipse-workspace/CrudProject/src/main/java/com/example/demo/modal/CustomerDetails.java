package com.example.demo.modal;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.example.demo.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CustomerDetails")
public class CustomerDetails {

	

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "Id", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name = "FirstName", columnDefinition = "VARCHAR(50)", nullable = false)
	private String firstName;

	@Column(name = "LastName", columnDefinition = "VARCHAR(50)", nullable = false)
	private String lastName;

	@Column(name = "DateOfBirth")
	private Date dob;

	@Column(name = "MobileNumber", columnDefinition = "VARCHAR(10)", nullable = false)
	private String mobileNumber;

	@Column(name = "AadharNumber", columnDefinition = "VARCHAR(12)", nullable = false)
	private String aadharNumber;

	@Column(name = "Gender" ,columnDefinition = "VARCHAR(10)", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Gender gender;

	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
