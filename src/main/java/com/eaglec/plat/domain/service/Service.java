package com.eaglec.plat.domain.service;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eaglec.plat.domain.Category;
import com.eaglec.plat.utils.Constant;

/**
 * 服务 <br/>
 * 描述枢纽平台、窗口平台或者服务机构对自己提供的每一类服务项目的情况，用于使中小企业了解由枢纽平台、窗口平台或者服务机构提供的服务内容 、方式和过程。
 * 
 * @author Xiadi
 * @since 2013-8-9
 * 
 */
@Entity
@Table
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 服务id
	private Integer id;
	
	// 服务项目编码
	private String serviceNo;
	
	// 服务来源；1服务机构 
	private Integer serviceSource;
	
	// 服务分类
	private Category category;
	
	// 服务机构
	private ServiceOrg serviceOrg;
	
	// 服务名称
	private String serviceName;
	
	// 注册时间
	private Date registerTime = new Date();
	
	// 服务次数
	private Integer serviceNum;
	
	// 服务联系人
	private String linkMan;
	
	// 联系电话
	private String tel;
	
	// 电子邮箱
	private String email;
	
	// 服务对象；1微型企业，2小型企业，3中型企业，4大型企业，5创业个人或团队，6个体工商户，7事业单位 ，8
	// 社会团体，9民办非企业，0其他（可多选，“,”分隔）
	// 注意：直接存储中文名称，而不是数字
	private String serviceObject;
	
	// 服务方式；1柜台式服务；2电话服务；3上门服务；4刊物服务；5信函服务；6网络服务；7其他服务；（填写文字，可以多选，服务之间用“,”分隔）
	// 注意：直接存储中文名称，而不是数字
	private String serviceMethod;
	
	// 服务和服务流程描述
	private String serviceProcedure;
	
	// 收费模式
	private String chargeMethod;
	
	// 服务状态:1新服务,2上架审核中，3已上架，4变更审核中，5已删除,6已下架,7下架审核中
	// 注意：直接存储中文名称，而不是数字
	private String currentStatus = Constant.SERVICE_STATUS_NEW;
	
	// 上次服务状态: 1新服务,2上架审核中，3已上架，4变更审核中，5已删除,6已下架,7下架审核中
	// 注意：直接存储中文名称，而不是数字
	private String lastStatus = "";
	

	public Service() {
		// TODO Auto-generated constructor stub
	}

	public Service(String serviceNo, Integer serviceSource, Category category,
			ServiceOrg serviceOrg, String serviceName, Date registerTime,
			Integer serviceNum, String serviceClass, String linkMan,
			String tel, String email, String serviceObject,
			String serviceMethod, String serviceProcedure, String chargeMethod,
			String currentStatus, String lastStatus) {
		super();
		this.serviceNo = serviceNo;
		this.serviceSource = serviceSource;
		this.category = category;
		this.serviceOrg = serviceOrg;
		this.serviceName = serviceName;
		this.registerTime = registerTime;
		this.serviceNum = serviceNum;
		this.linkMan = linkMan;
		this.tel = tel;
		this.email = email;
		this.serviceObject = serviceObject;
		this.serviceMethod = serviceMethod;
		this.serviceProcedure = serviceProcedure;
		this.chargeMethod = chargeMethod;
		this.currentStatus = currentStatus;
		this.lastStatus = lastStatus;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public Integer getServiceSource() {
		return serviceSource;
	}

	public void setServiceSource(Integer serviceSource) {
		this.serviceSource = serviceSource;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "orgId")
	public ServiceOrg getServiceOrg() {
		return serviceOrg;
	}

	public void setServiceOrg(ServiceOrg serviceOrg) {
		this.serviceOrg = serviceOrg;
	}
	public String getServiceName() {
		return serviceName;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "catId")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(Integer serviceNum) {
		this.serviceNum = serviceNum;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getServiceObject() {
		return serviceObject;
	}


	public void setServiceObject(String serviceObject) {
		this.serviceObject = serviceObject;
	}


	public String getServiceMethod() {
		return serviceMethod;
	}


	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}


	public String getServiceProcedure() {
		return serviceProcedure;
	}


	public void setServiceProcedure(String serviceProcedure) {
		this.serviceProcedure = serviceProcedure;
	}


	public String getChargeMethod() {
		return chargeMethod;
	}


	public void setChargeMethod(String chargeMethod) {
		this.chargeMethod = chargeMethod;
	}


	public String getCurrentStatus() {
		return currentStatus;
	}


	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}


	public String getLastStatus() {
		return lastStatus;
	}


	public void setLastStatus(String lastStatus) {
		this.lastStatus = lastStatus;
	}


	@Override
	public String toString() {
		return "Service [id=" + id + ", serviceNo=" + serviceNo
				+ ", serviceSource=" + serviceSource + ", category=" + category
				+ ", serviceOrg=" + serviceOrg + ", serviceName=" + serviceName
				+ ", registerTime=" + registerTime + ", serviceNum="
				+ serviceNum + ", linkMan="
				+ linkMan + ", tel=" + tel + ", email=" + email
				+ ", serviceObject=" + serviceObject + ", serviceMethod="
				+ serviceMethod + ", serviceProcedure=" + serviceProcedure
				+ ", chargeMethod=" + chargeMethod + ", currentStatus="
				+ currentStatus + ", lastStatus=" + lastStatus + "]";
	}

}