package com.artapp.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @ManyToOne
    @JoinColumn(name = "emailId", nullable = false)
    private Customer emailId;

    private double totalPrice;
    private String city;
    private String state;
    private String country;
    private int pincode;

    private String receiverName;
    private String receiverEmail;
    private Long receiverPhone;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Customer getEmailId() {
		return emailId;
	}
	public void setEmailId(Customer emailId) {
		this.emailId = emailId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	public Long getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(Long receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public Orders(Customer emailId, double totalPrice, String city, String state, String country, int pincode,
			String receiverName, String receiverEmail, Long receiverPhone) {
		super();
		this.emailId = emailId;
		this.totalPrice = totalPrice;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.receiverName = receiverName;
		this.receiverEmail = receiverEmail;
		this.receiverPhone = receiverPhone;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", emailId=" + emailId + ", totalPrice=" + totalPrice + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + ", receiverName="
				+ receiverName + ", receiverEmail=" + receiverEmail + ", receiverPhone=" + receiverPhone + "]";
	}

	

	
    
}
