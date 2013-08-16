package com.eaglec.plat.domain.cms;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "channel", uniqueConstraints = @UniqueConstraint(columnNames = "CCODE"))
public class Channel implements Serializable{
	
	private static final long serialVersionUID = 265145309761620980L;
	
	private int cid;	//频道ID
	private String ccode;	//频道编码
	private String cname;	//频道名称
	private String cdesc;	//频道描述
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	
	@Override
	public String toString() {
		return "Channel [cid=" + cid + ", ccode=" + ccode + ", cname=" + cname
				+ ", cdesc=" + cdesc + "]";
	}
}



