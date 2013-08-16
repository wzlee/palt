package com.eaglec.plat.domain.auth;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String rolename;
	private String roledesc;
	private Date createTime;
	private List<Rights> rights;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledesc() {
		return roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@ManyToMany(fetch=FetchType.EAGER)
//	@JoinTable(name = "t_s", joinColumns = { @JoinColumn(name = "teacher_idddd") }, inverseJoinColumns = { @JoinColumn(name = "student_idddd") })
	public List<Rights> getRights() {
		return rights;
	}

	public void setRights(List<Rights> rights) {
		this.rights = rights;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", roledesc="
				+ roledesc + ", createTime=" + createTime + ", rights="
				+ rights + "]";
	}

}
