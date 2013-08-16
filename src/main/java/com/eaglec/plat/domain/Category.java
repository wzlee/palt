package com.eaglec.plat.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 * 平台类别实体类
 * @author wzlee
 * @description 管理平台所有类别
 */
@Entity
@Table
public class Category implements Serializable {
	private static final long serialVersionUID = 7723505770170205140L;
	
	private Integer id; //主键ID
	private String code; //类别编码
	private String text; //类别名称
	private Integer pid; //父类ID
	private Boolean leaf = true; //叶子节点
	private String description; //类别描述
	private String clazz; //所属实体类
	private List<Category> children;
	
	public Category() {
		super();
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@ForeignKey(name = "pid")
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Boolean getLeaf() {
		return leaf;
	}
	
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	@OneToMany(mappedBy = "pid", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", code=" + code + ", text=" + text
				+ ", pid=" + pid + ", leaf=" + leaf + ", description="
				+ description + ", clazz=" + clazz + ", children=" + children
				+ "]";
	}
	
}
