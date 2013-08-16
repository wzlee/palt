package com.eaglec.plat.biz.impl.publik;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eaglec.plat.biz.publik.FileManagerBiz;
import com.eaglec.plat.dao.publik.FileManagerDao;
import com.eaglec.plat.domain.FileManager;

/**
 * 资源文件业务层实现类
 * 
 * @author liuliping
 * @since 2013-07-25
 * */
@Service
public class FileManagerBizImpl implements FileManagerBiz {
	@Autowired
	private FileManagerDao fileManagerDao;

	public FileManagerDao getFileManagerDao() {
		return fileManagerDao;
	}

	public void setFileManagerDao(FileManagerDao fileManagerDao) {
		this.fileManagerDao = fileManagerDao;
	}

	/**
	 * 新增文件对象
	 * 
	 * @author liuliping
	 * @since 2013-07-25
	 * 
	 * @param fileManager
	 *            文件对象
	 * @return 无返回值
	 * */
	public void saveFileManager(FileManager fileManager) {
		fileManagerDao.save(fileManager);
	}

	/**
	 * 通过主键id删除单个文件对象
	 * 
	 * @author liuliping
	 * @since 2013-07-25
	 * 
	 * @param id
	 * @return 无返回值
	 * */
	public void deleteFileManager(int id) {
		fileManagerDao.delete(id);
	}

	/**
	 * 更新文件对象
	 * 
	 * @author liuliping
	 * @since 2013-07-25
	 * 
	 * @param fileManager
	 *            文件对象
	 * @return 无返回值
	 * */
	public void updateFileManager(FileManager fileManager) {
		fileManagerDao.update(fileManager);
	}

	/**
	 * 通过主键id获取单个文件对象
	 * 
	 * @author liuliping
	 * @since 2013-07-25
	 * 
	 * @param id
	 * @return FileManager对象
	 * */
	public void get(int id) {
		fileManagerDao.get(id);
	}

	@Override
	public List<FileManager> findByName(String fileName) {
		String hql = "from FileManager where fname='" + fileName + "'";
		return fileManagerDao.findList(hql);
	}

	@Override
	public FileManager findOne(String fileName) {
		return fileManagerDao.findOne(fileName);
	}

}
