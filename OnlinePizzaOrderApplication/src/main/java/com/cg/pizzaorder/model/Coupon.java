package com.cg.pizzaorder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Coupon_Table")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int couponId;
	@NotBlank(message="Coupon Name Should not be null")
private String couponName;
private String couponType;
private String couponDescription;
private int couponPizzaId;
public int getCouponId() {
	return couponId;
}
public void setCouponId(int couponId) {
	this.couponId = couponId;
}
public String getCouponName() {
	return couponName;
}
public void setCouponName(String couponName) {
	this.couponName = couponName;
}
public String getCouponType() {
	return couponType;
}
public void setCouponType(String couponType) {
	this.couponType = couponType;
}
public String getCouponDescription() {
	return couponDescription;
}
public void setCouponDescription(String couponDescription) {
	this.couponDescription = couponDescription;
}
public int getCouponPizzaId() {
	return couponPizzaId;
}
public void setCouponPizzaId(int couponPizzaId) {
	this.couponPizzaId = couponPizzaId;
}
}
