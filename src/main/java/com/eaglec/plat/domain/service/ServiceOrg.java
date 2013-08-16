package com.eaglec.plat.domain.service;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 服务机构<br/>
 * 描述提供服务资源的服务机构的基本情况，用于使中小企业了解服务机构，找到合适的服务资源
 * 
 * @author Xiadi
 * @since 2013-8-9
 * 
 */
@Entity
@Table
public class ServiceOrg implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 机构id
	private Integer id;
	
	// 机构编码
	private String orgNo;
	
	// 单位性质；1企业，2事业单位，3社会团体，4个体工商户，5民办非企业
	// 注意：直接存储中文名称，而不是数字
	private String orgProperty;
	
	// 组织机构代码或者工商注册号
	private String orgCode;
	
	// 机构名称
	private String orgName;
	
	// 法定代表人(负责人、经营者）
	private String leganPerson;
	
	// 企业注册类型
	private String regesterType;
	
	// 行政区划代码
	private String areaCounty;
	
	// 联系人
	private String linkMan;
	
	// 电话
	private String tel;
	
	// 传真
	private String fax;
	
	// 电子邮箱
	private String email;
	
	// 网址
	private String webSite;
	
	// 通讯地址
	private String address;
	
	// 邮政编码
	private String postCode;
	
	// 行业代码
	private String industryCode;
	
	// 主要服务内容和特色
	private String mainRemark;
	
	// 控股情况
	private String shareType;
	
	// 开业时间
	private String openedTime;
	
	// 注册资本；单位：万元
	private Double registerAsset;
	
	// 专业资质情况
	private String qualification;
	
	// 主要服务设备及条件
	private String remark;
	
	// 人员素质构成情况
	private String personnel;
	
	// 服务机构LOGO图片
	private String photo;
	
	public ServiceOrg() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getOrgProperty() {
		return orgProperty;
	}

	public void setOrgProperty(String orgProperty) {
		this.orgProperty = orgProperty;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getLeganPerson() {
		return leganPerson;
	}

	public void setLeganPerson(String leganPerson) {
		this.leganPerson = leganPerson;
	}

	public String getRegesterType() {
		return regesterType;
	}

	public void setRegesterType(String regesterType) {
		this.regesterType = regesterType;
	}

	public String getAreaCounty() {
		return areaCounty;
	}

	public void setAreaCounty(String areaCounty) {
		this.areaCounty = areaCounty;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getMainRemark() {
		return mainRemark;
	}

	public void setMainRemark(String mainRemark) {
		this.mainRemark = mainRemark;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getOpenedTime() {
		return openedTime;
	}

	public void setOpenedTime(String openedTime) {
		this.openedTime = openedTime;
	}

	public Double getRegisterAsset() {
		return registerAsset;
	}

	public void setRegisterAsset(Double registerAsset) {
		this.registerAsset = registerAsset;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPersonnel() {
		return personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "ServiceOrg [id=" + id + ", orgNo=" + orgNo + ", orgProperty="
				+ orgProperty + ", orgCode=" + orgCode + ", orgName=" + orgName
				+ ", leganPerson=" + leganPerson + ", regesterType="
				+ regesterType + ", areaCounty=" + areaCounty + ", linkMan="
				+ linkMan + ", tel=" + tel + ", fax=" + fax + ", email="
				+ email + ", webSite=" + webSite + ", address=" + address
				+ ", postCode=" + postCode + ", industryCode=" + industryCode
				+ ", mainRemark=" + mainRemark + ", shareType=" + shareType
				+ ", openedTime=" + openedTime + ", registerAsset="
				+ registerAsset + ", qualification=" + qualification
				+ ", remark=" + remark + ", personnel=" + personnel
				+ ", photo=" + photo + ", serviceItem=" + "]";
	}

	
}