package com.eaglec.plat.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eaglec.plat.biz.auth.UserManagerBiz;
import com.eaglec.plat.biz.publik.FileManagerBiz;
import com.eaglec.plat.domain.FileManager;
import com.eaglec.plat.domain.Upload;
import com.eaglec.plat.domain.auth.User;
import com.eaglec.plat.repositories.UploadRepository;
import com.eaglec.plat.repositories.UserRepository;
import com.eaglec.plat.utils.Common;
import com.eaglec.plat.utils.StrUtils;
import com.eaglec.plat.view.JSONResult;
import com.mongodb.gridfs.GridFSDBFile;

@Controller
@RequestMapping(value = "/public")
public class PublicController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
	
	@Autowired
	GridFsOperations operations;
	@Autowired
	private UploadRepository uploadRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserManagerBiz userManagerBiz;
	@Autowired
	private FileManagerBiz fileManagerBiz;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadCode(@RequestParam MultipartFile file,@RequestParam MultipartFile image,HttpServletRequest request,HttpServletResponse response,Model model) {
		User user = userRepository.findOne("51da703bc1f346fb5351fe8a");
//		String md5_file ="",
//				md5_image = "";
//		try {
//			md5_file = operations.store(file.getInputStream(),file.getOriginalFilename()).getMD5();
//			md5_image = operations.store(file.getInputStream(),image.getOriginalFilename()).getMD5();
//		} catch (IOException e) {
//			logger.info(e.getLocalizedMessage());
//		}
		
		String uploadPath = "upload";
		String contextPath = request.getSession().getServletContext().getRealPath(uploadPath);
		File filepath = new File(contextPath);
		if (!filepath.exists()) {
			filepath.mkdir();
			logger.info("["+filepath.getAbsolutePath()+"]创建成功!");
		}
		File _file = new File(contextPath+"/files",file.getOriginalFilename());
		File _image = new File(contextPath+"/images",image.getOriginalFilename());
		try {
			file.transferTo(_file);
			image.transferTo(_image);
		} catch (IllegalStateException e1) {
			logger.info("IllegalStateException异常:"+e1.getLocalizedMessage());
		} catch (IOException e1) {
			logger.info("IOException异常:"+e1.getLocalizedMessage());
		}
//		uploadRepository.save(new Upload(user,md5_file,md5_image));
		Upload upload = new Upload(user,file.getOriginalFilename(),image.getOriginalFilename());
		uploadRepository.save(upload);
		model.addAttribute("upload", upload);
		return "result";
	}
	
	@RequestMapping(value = "/download/{filename}", method = RequestMethod.GET)
	public GridFSDBFile loadFile(@PathVariable String filename,HttpServletRequest request,HttpServletResponse response) {
		GridFSDBFile gfsdbf = operations.findOne(new Query(GridFsCriteria.whereFilename().is(filename)));
		return gfsdbf;
	}
	
	@RequestMapping("check")
	public void validatelogin(HttpServletResponse response,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			this.outJson(response,new JSONResult(false,"会话未创建或已过期!"));
		}else{
			this.outJson(response,new JSONResult(true,"会话验证成功!"));
		}
	}

	@RequestMapping("login")
	public void userlogin(HttpServletResponse response,HttpServletRequest request,String password,String username){
		if(username!=null){
			User u =userManagerBiz.findUserByUsername(username);
			if("".equals(username)||u==null){
				this.outJson(response, new JSONResult(false,"账号错误!"));
			}else if(u.getPassword().equals(password)){
				request.getSession().setAttribute("user", u);
				this.outJson(response, new JSONResult(true,"登陆成功!"));
			}else{
				this.outJson(response, new JSONResult(false,"密码错误!"));
				}
			}else{
				this.outJson(response, new JSONResult(false,"用户名不能为空"));
			}
	}

	@RequestMapping("userlogout")
	public void userlogout(HttpServletResponse response,HttpServletRequest request,User user){
		try {
			request.getSession().removeAttribute("user");
			this.outJson(response, new JSONResult(true, "退出登录成功!"));
		} catch (Exception e) {
			this.outJson(response, new JSONResult(false, "退出登录失败!"));
		}
	}

	/**
	 * 异步文件上传处理，返回文件名
	 * @author XiaDi
	 * @since 2013-7-23
	 * 
	 * @param file 文件
	 * @eg admin/channel.jsp 
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public void uploadFile(@RequestParam MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		String contextPath = request.getSession().getServletContext().getRealPath(Common.uploadPath);
		File filepath = new File(contextPath);
		FileManager fileManager = new FileManager();
		
		if (!filepath.exists()) {
			filepath.mkdir();
			logger.info("[" + filepath.getAbsolutePath() + "]创建成功!");
		}
		try {
			int index = file.getOriginalFilename().lastIndexOf(".");
			long timestamp = System.currentTimeMillis();
			String orgFileName = timestamp + file.getOriginalFilename().substring(index);
			File orgFile = new File(contextPath, orgFileName);
			file.transferTo(orgFile);
			
			/*保存文件对象信息*/
			String date = StrUtils.formateDate("yyyy-MM-dd HH:mm:ss", new Date());
			fileManager.setFname(orgFileName);
			fileManager.setDate(date);
			fileManagerBiz.saveFileManager(fileManager);
			super.outJson(response, new JSONResult(true, orgFile.getName()));
		} catch (Exception e) {
			logger.info("Exception异常:" + e.getLocalizedMessage());
			super.outJson(response, new JSONResult(true, "上传失败"));
		}
	}
	
	/**
	 * 异步删除文件，返回状态（true or false）
	 * @author XiaDi
	 * @since 2013-7-24
	 * 
	 * @param fileName 文件名
	 * @param response
	 */
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public void deleteFile(@RequestParam String fileName, HttpServletRequest request, HttpServletResponse response){
		String contextPath = request.getSession().getServletContext().getRealPath(Common.uploadPath);
		File orgFile = new File(contextPath, fileName);
		boolean b = false;
		if (orgFile.exists()) {
			b = orgFile.delete();
		}
		super.outJson(response, new JSONResult(true, b + ""));
	}
	
}
