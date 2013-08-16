package com.eaglec.plat.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 数据字典<br/>
 * 用于存储系统中使用的简单状态及类型
 * 
 * @author Xiadi
 * @since 2013-8-13
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "type", "value" }))
public class SysCode implements Serializable {

	private static final long serialVersionUID = 1L;
	// 字典id
	private Integer id;
	
	// 类型
	private String type;
	
	// 值
	private String value;
	
	// 显示文本
	private String remark;

	public SysCode() {
		// TODO Auto-generated constructor stub
	}
	
	public SysCode(String type, String value, String remark) {
		super();
		this.type = type;
		this.value = value;
		this.remark = remark;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysCode [id=" + id + ", type=" + type + ", value=" + value
				+ ", remark=" + remark + "]";
	}
	
}
