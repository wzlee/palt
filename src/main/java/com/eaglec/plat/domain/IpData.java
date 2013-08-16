package com.eaglec.plat.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IpData implements Serializable{
	
	private static final long serialVersionUID = 6096807560296765103L;
	private String id;
	private String ip;
	private String isp_id;
	private String isp;
	private String country_id;
	private String country;
	private String area_id;
	private String area;
	private String region_id;
	private String region;
	private String city_id;
	private String city;
	private String county;
	private String county_id;
	private String passpord_id;
	private String record_date;
	
	public IpData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IpData(String id, String ip, String isp_id, String isp,
			String country_id, String country, String area_id, String area,
			String region_id, String region, String city_id, String city,
			String county, String county_id, String passpord_id,String record_date) {
		super();
		this.id = id;
		this.ip = ip;
		this.isp_id = isp_id;
		this.isp = isp;
		this.country_id = country_id;
		this.country = country;
		this.area_id = area_id;
		this.area = area;
		this.region_id = region_id;
		this.region = region;
		this.city_id = city_id;
		this.city = city;
		this.county = county;
		this.county_id = county_id;
		this.passpord_id = passpord_id;
		this.record_date = record_date;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIsp_id() {
		return isp_id;
	}

	public void setIsp_id(String isp_id) {
		this.isp_id = isp_id;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCounty_id() {
		return county_id;
	}

	public void setCounty_id(String county_id) {
		this.county_id = county_id;
	}

	public String getPasspord_id() {
		return passpord_id;
	}

	public void setPasspord_id(String passpord_id) {
		this.passpord_id = passpord_id;
	}

	public String getRecord_date() {
		return record_date;
	}

	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}
	
}
