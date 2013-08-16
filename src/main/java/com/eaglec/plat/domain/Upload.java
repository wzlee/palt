package com.eaglec.plat.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.eaglec.plat.domain.auth.User;

@Document
public class Upload {
	
	private String id;
	@DBRef
	private User user;
	private String fileName;
	private String imageName;
	
	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Upload(User user, String fileName, String imageName) {
		super();
		this.user = user;
		this.fileName = fileName;
		this.imageName = imageName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "Upload [id=" + id + ", user=" + user + ", fileName=" + fileName
				+ ", imageName=" + imageName + "]";
	}

}
