package com.eaglec.plat.biz.publik;

import java.util.List;

import com.eaglec.plat.domain.FileManager;

public interface FileManagerBiz {
	public void saveFileManager(FileManager fileManager);
	
	public void deleteFileManager(int id);
	
	public void updateFileManager(FileManager fileManager);
	
	public void get(int id);
	
	public List<FileManager> findByName(String fileName);
	
	public FileManager findOne(String fileName);
}
