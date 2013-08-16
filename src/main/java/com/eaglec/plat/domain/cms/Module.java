package com.eaglec.plat.domain.cms;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "module", uniqueConstraints = @UniqueConstraint(columnNames = "MCODE"))
public class Module implements Serializable{
	
	private static final long serialVersionUID = 2114328435255915600L;
	
	private int mid;		//主键ID
	private String mcode;	//模块编码
	private String mname;	//模块名称
	private String mchannel; //模块所属频道
	private int mposition; //模块位置索引
	private String mdesc;	//模块描述
	private String micon = "";	//色块图标
	private String mindex;	//模块链接首页
	private String mdirect;	//授权回调地址
	private String linktype;//链接方式：1.弹窗，2.跳转
	private boolean nlogin = false;//进入模块时是否需要登录
	private boolean nauthor = false;	//进入模块时是否需要授权
	private String status = "建设中"; //服务模块状态
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMchannel() {
		return mchannel;
	}
	public void setMchannel(String mchannel) {
		this.mchannel = mchannel;
	}
	public int getMposition() {
		return mposition;
	}
	public void setMposition(int mposition) {
		this.mposition = mposition;
	}
	public String getMdesc() {
		return mdesc;
	}
	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}
	public String getMicon() {
		return micon;
	}
	public void setMicon(String micon) {
		this.micon = micon;
	}
	public String getMindex() {
		return mindex;
	}
	public String getMdirect() {
		return mdirect;
	}
	public void setMdirect(String mdirect) {
		this.mdirect = mdirect;
	}
	public void setMindex(String mindex) {
		this.mindex = mindex;
	}
	public String getLinktype() {
		return linktype;
	}
	public void setLinktype(String linktype) {
		this.linktype = linktype;
	}
	public boolean getNlogin() {
		return nlogin;
	}
	public void setNlogin(boolean nlogin) {
		this.nlogin = nlogin;
	}
	public boolean getNauthor() {
		return nauthor;
	}
	public void setNauthor(boolean nauthor) {
		this.nauthor = nauthor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
