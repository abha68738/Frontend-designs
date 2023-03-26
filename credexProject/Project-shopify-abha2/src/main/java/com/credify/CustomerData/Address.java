package com.credify.CustomerData;

public class Address {

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getProvince_code() {
	return province_code;
}
public void setProvince_code(String province_code) {
	this.province_code = province_code;
}
public String getCountry_code() {
	return country_code;
}
public void setCountry_code(String country_code) {
	this.country_code = country_code;
}
public String getCountry_name() {
	return country_name;
}
public void setCountry_name(String country_name) {
	this.country_name = country_name;
}

@Override
public String toString() {
	return "Address [id=" + id + ", city=" + city + ", province=" + province + ", country=" + country
			+ ", province_code=" + province_code + ", country_code=" + country_code + ", country_name=" + country_name
			+ "]";
}
private long id;
private String city;
private String province;
private String country;
private String province_code;
private String country_code;
private String country_name;

}
