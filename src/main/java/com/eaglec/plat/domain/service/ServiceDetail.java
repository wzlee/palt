package com.eaglec.plat.domain.service;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 服务流水 <br/>
 * 描述服务机构对自己提供的每一类服务项目的操作流水情况
 * 
 * @author Xiadi
 * @since 2013-8-9
 * 
 */
@Entity
@Table
public class ServiceDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 流水id
	private Integer id;
	
	// 流水号
	private String serialId;
	
	// 审核状态 0未通过 1通过
	// 注意：直接存储中文名称，而不是数字
	private Integer operatStatus;
	
	// 操作时间
	private Date operatorTime;
	
	// 服务
	private Service service;
	
	public ServiceDetail() {
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

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public Integer getOperatStatus() {
		return operatStatus;
	}

	public void setOperatStatus(Integer operatStatus) {
		this.operatStatus = operatStatus;
	}

	public Date getOperatorTime() {
		return operatorTime;
	}

	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}

	@ManyToOne
	@JoinColumn(name = "servId")
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "ServiceDetail [id=" + id + ", serialId=" + serialId
				+ ", operatStatus=" + operatStatus + ", operatorTime="
				+ operatorTime + ", service=" + service + "]";
	}

}