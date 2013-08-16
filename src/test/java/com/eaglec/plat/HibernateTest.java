package com.eaglec.plat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.eaglec.plat.biz.auth.RightsManagerBiz;
import com.eaglec.plat.biz.auth.RoleManagerBiz;
import com.eaglec.plat.biz.auth.UserManagerBiz;
import com.eaglec.plat.biz.service.ServiceBiz;
import com.eaglec.plat.biz.service.ServiceOrgBiz;
import com.eaglec.plat.domain.auth.Rights;
import com.eaglec.plat.domain.auth.Role;
import com.eaglec.plat.domain.auth.User;
import com.eaglec.plat.domain.service.Service;
import com.eaglec.plat.domain.service.ServiceOrg;
import com.eaglec.plat.utils.MD5;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={
//		"file:src/main/resources/shiro.xml", 
        "file:src/main/webapp/WEB-INF/spring/*.xml", 
        "file:src/main/webapp/WEB-INF/spring/appServlet/*.xml"})
public class HibernateTest {

	@Test
	public void test() {
		System.out.println(MD5.toMD5("chens"));
	}

//	@Autowired
//	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private UserManagerBiz userManagerBiz;
	@Autowired
	private RoleManagerBiz roleManagerBiz;
	@Autowired
	private RightsManagerBiz rightsManagerBiz;
	
	@Test
	public void hibernamteTest(){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		/*Rights p = new Rights();
		p.setAuthCode("A");
		p.setText("信息服务");
		p.setLeaf(false);
		p.setPid(0);
		Rights p1 = new Rights();
		p1.setAuthCode("B");
		p1.setText("投融资服务");
		p1.setLeaf(false);
		p1.setPid(0);
		s.save(p1);
		s.save(p);*/
/*		List<Rights> lr =s.createQuery("from Rights r where r.text='信息服务'").list();
		Rights p1 = new Rights();
		p1.setAuthCode("C");
		p1.setText("法律法规信息查询");
		p1.setLeaf(true);
		p1.setPid(lr.get(0).getId());
		Rights p2 = new Rights();
		p2.setAuthCode("C");
		p2.setText("政策信息查询");
		p2.setLeaf(true);
		p2.setPid(lr.get(0).getId());
		Rights p3 = new Rights();
		p3.setAuthCode("C");
		p3.setText("政策信息查询");
		p3.setLeaf(true);
		p3.setPid(lr.get(0).getId());
		s.save(p1);
		s.save(p2);
		s.save(p3);*/
//		List<Rights> list = new ArrayList<Rights>();
//		List<Rights> list=s.createQuery("from Rights").list();
//		
//		Role r = new Role();
//		r.setCreateTime(new Date());
//		
//		r.setRights(list);
//		r.setRolename("管理员");
//		r.setRoledesc("供管理员使用");
//		s.save(r);
		
		User  u = new User();
		u.setPassword(MD5.toMD5("test"));
		u.setUsername("test");
		//u.setRole(r);
		s.save(u);
		s.getTransaction().commit();
		
	}
	@Test
	public void Json(){
		List<Rights> list = new ArrayList<Rights>();
		Rights r1 = new Rights();
		r1.setId(1);
		r1.setLeaf(false);
		r1.setCreateTime(new Date());
		r1.setText("权限1");
		r1.setRemark("菜单");
		r1.setPid(0);
		list.add(r1);
		Rights r2 = new Rights();
		r2.setId(2);
		r2.setLeaf(true);
		r2.setCreateTime(new Date());
		r2.setText("权限2");
		r2.setRemark("菜单");
		r2.setPid(1);
		/*List<Rights> l = new ArrayList<Rights>();
		l.add(r2);
		r1.setChildren(l);*/
		list.add(r1);
		list.add(r2);
		
		List<Rights> xxx = new ArrayList<Rights>();
		for(int i = 0 ;i<list.size();i++){
			for(int t =i+1;t<list.size();t++){
				if(list.get(i).getId()==list.get(t).getPid()){
					list.get(i).setLeaf(false);
					if(list.get(i).getChildren()==null){
						List<Rights> tt = new ArrayList<Rights>();
						tt.add(list.get(t));
						list.get(i).setChildren(tt);
					}else{
						list.get(i).getChildren().add(list.get(t));
					}
					xxx.add(list.get(i));
				}
			}
		}
		
		System.out.println(JSON.toJSONString(xxx.toArray()));
	}
	

	@Test
	public void authTest(){
//		User u = new User();
//		u.setUsername("chens");
//		u.setPassword(MD5.toMD5("chens"));
//		System.out.println(userManagerBiz.findUserByRoleId(1));
//		System.out.println(userManagerBiz.findUserByUsername("chens"));
//		System.out.println(userManagerBiz.findUser().get(0).getUsername());
//		System.out.println(roleManagerBiz.queryRole().get(1).getRights().get(0).getText());
//		System.out.println(JSON.toJSONString(roleManagerBiz.queryRole().toArray(),SerializerFeature.WriteDateUseDateFormat,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.PrettyFormat));
		//System.out.println(getResult(rightsManagerBiz.queryRights()).size());
		//System.out.println(JSON.toJSONString(getResult(rightsManagerBiz.queryRights()),SerializerFeature.WriteDateUseDateFormat,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.PrettyFormat));
		System.out.println(roleManagerBiz.queryRoleByName("管理员").getRolename());
	}
	
	@Autowired
	private ServiceOrgBiz serviceOrgService;
	@Autowired
	private ServiceBiz serviceBiz;
	
	@Test
	public void serviceTest(){
		ServiceOrg org = new ServiceOrg();
		org.setOrgName("dfasdfa");
		serviceOrgService.add(org);
	}
	
	@Test
	public void serviceBizTest(){
		List<Service> list = serviceBiz.queryServiceByStatus("新服务");
		for(Service service:list){
			System.out.println(service.toString());
		}
//		System.out.println(serviceBiz.queryServiceByStatus("新服务").size());
//		serviceBiz.add(new Service("101002",1,null,"中小企业发展规划优惠政策2",new Date(),0,"法律政策资讯2","胡惊涛","010-3838438","hjt@gov.cn","7","上门服务","米撒旦法斯蒂芬2","免费","新服务",null));
	}

	public static List<Rights> getResult(List<Rights> src) {
		List<Rights> parents = new ArrayList<Rights>();
//		for (Rights ent : src) {
//			if (!ent.isLeaf()) {
//				Rights result = ent;
//				result.setChildren(new ArrayList<Rights>());
//				parents.add(result);
//			}
//		}
		List<Rights> last = new ArrayList<Rights>();
		for (Rights ent : src) {
			if (ent.getPid()==0||ent.getPid()==1000||ent.getPid()==1001||ent.getPid()==1002||ent.getPid()==1003) {
				ent.setChildren(new ArrayList<Rights>());
				parents.add(ent);
			}else{
				last.add(ent);
			}
		}
		buildTree(parents, last);
		return parents;
	}

	private static void buildTree(List<Rights> parents, List<Rights> others) {
		List<Rights> record = new ArrayList<Rights>();
		for (Iterator<Rights> it = parents.iterator(); it.hasNext();) {
			Rights vi = it.next();
			if (vi.getId() != null) {
				for (Iterator<Rights> otherIt = others.iterator(); otherIt
						.hasNext();) {
					Rights inVi = otherIt.next();
					if (vi.getId().equals(inVi.getPid())) {
						if (null == vi.getChildren()) {
							vi.setChildren(new ArrayList<Rights>());
						}
						vi.getChildren().add(inVi);
						record.add(inVi);
						otherIt.remove();
					}
				}
			}
		}
		if (others.size() == 0) {
			return;
		} else {
			buildTree(record, others);
		}
	}
}
