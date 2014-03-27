package com.cc.example.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;




public class Person {

	private Long id;
	private String firstName;
	private String lastName;
	@ManyToOne( targetEntity= Address.class,fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ADDR_ID")
    @Fetch(FetchMode.JOIN)
	private Address address = new Address() ;
	
	public Long getId() {
		return id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setId(Long id) {
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
	
	
	
}
