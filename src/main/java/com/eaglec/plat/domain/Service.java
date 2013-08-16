package com.eaglec.plat.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 服务实体类
 * @author wzlee
 *
 */
@Document
public class Service implements Serializable {
	private static final long serialVersionUID = -3769855146201727321L;
	
	private Integer id; //主键ID
	private String scode; // 服务编码
	private String sname; //服务名称
	private String source; //服务来源
	private String regdate; //服务注册时间
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Service(String scode, String sname, String source, String regdate) {
		super();
		this.scode = scode;
		this.sname = sname;
		this.source = source;
		this.regdate = regdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", scode=" + scode + ", sname=" + sname
				+ ", source=" + source + ", regdate=" + regdate + "]";
	}
	
}
