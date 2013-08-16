package com.eaglec.plat;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eaglec.plat.domain.Category;
import com.eaglec.plat.domain.IpData;
import com.eaglec.plat.repositories.CategoryRepository;
import com.eaglec.plat.repositories.IpDataRepository;
import com.eaglec.plat.repositories.ServiceRepository;
import com.eaglec.plat.repositories.UploadRepository;
import com.eaglec.plat.repositories.UserRepository;
import com.mongodb.gridfs.GridFSDBFile;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={
        "file:src/main/webapp/WEB-INF/spring/*.xml", 
        "file:src/main/webapp/WEB-INF/spring/appServlet/*.xml"})
public class MongoDBTest {
	private static final Logger logger = LoggerFactory.getLogger(MongoDBTest.class);
	
	@Autowired
	GridFsOperations operations;
	@Autowired 
	IpDataRepository ipdataRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UploadRepository uploadRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ServiceRepository serviceRepository;
	@Test
	public void test() {
		fail("Not yet implemented");
	}


    @Test
    public void repositoryTest(){
    	ipdataRepository.save(new IpData(null,"113.57.216.67","100026","联通","CN","中国","400000","华中","420000","湖北省","420100","武汉市","","-1","wzlee","2013-07-03 18:29:22"));
////    	ipdataRepository.delete("51d65784c1f390e31d12eaf8");
    	logger.info("ipdata's count："+ipdataRepository.count());
//    	userRepository.save(new User("eaglec","ehas12312sdfa"));
//    	logger.info(uploadRepository.findOne("51da7197c1f372fcae14ca74").getUser().toString());
    }
	
    @Test
    public void categoryRepositoryTest(){
//    	categoryRepository.save(new Category("1002","政策信息查询","51fb567241d3db04a87b4d25",true,"政策信息查询","service"));
    	System.out.println(categoryRepository.count());
    }
    
    @Test
    public void serviceRepositoryTest(){
//    	serviceRepository.save(new Service("1002001","2013中小企业扶持咨询申报","51fb775a41d3e2cba254661a","国家工信部中小企业服务中心","2013-08-05 09:54"));
    	System.out.println(serviceRepository.count());
    }
    
	@Test
	public void GridFsTest(){
//		Resource file = new Resource();
//		operations.store(new File("E:/Cracked.zip")., "text.text");
//		FileMetadata metadata = new FileMetadata();
//	    // populate metadata
//	    Resource file = new File("E:/Cracked.zip"); // lookup File or Resource
//
//	    operations.store(file.getInputStream(), "filename.txt", metadata);
		GridFSDBFile gfsf =  operations.findOne(new Query(GridFsCriteria.whereFilename().is("test.txt")));
		System.out.println(gfsf.getMD5());
	}
	
}
