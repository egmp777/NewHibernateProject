package com.cc.example.hibernate;

public class Employee {
	
		  private String firstName;
		  private String lastName;
		  private String email;
		  private long id;
		//  public Employee(int i, String string, String string2, String string3) {
			//super();
			//this.setId(i);
			
			//this.setFirstName(string);
			//this.setLastName(string2);
			//this.setEmail(string3);
		//}
       
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
		public String getEmail() {
		return email;
		}
		public void setEmail(String email) {
		this.email = email;
		}
		public long getId() {
		return id;
		}
		public void setId(long id) {
		this.id = id;
		}
}
