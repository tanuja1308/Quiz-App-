package com.quizeapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contacttable")
public class contactform {

@Id
private Long phoneno;
private String uname;
private String email;
private String feedback;
public Long getPhoneno() {
	return phoneno;
}
public void setPhoneno(Long phoneno) {
	this.phoneno = phoneno;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}
public contactform() {
	super();
}

}
