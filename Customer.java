package com.artapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Customers")
public class Customer {

	@Column
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message="Username must be between 3 and 20 characters")
    private String custName;

    @Id
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @Column
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Column
    private String address;

    @Column
    @NotBlank(message = "Contact number is required")
    private String contactNo;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Customer() {
	
	}

	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", contactNo=" + contactNo + "]";
	}
	
    
}
