package com.eaglec.plat.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONObject;
import com.eaglec.plat.biz.news.NewsBiz;
import com.eaglec.plat.biz.publik.FileManagerBiz;
import com.eaglec.plat.domain.FileManager;
import com.eaglec.plat.domain.News;
import com.eaglec.plat.utils.StrUtils;
import com.eaglec.plat.view.JSONData;
import com.eaglec.plat.view.JSONResult;

@Controller
@RequestMapping(value = "/news")
@SessionAttributes("passport")
public class NewsController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(NewsController.class);

	@Autowired
	private NewsBiz newsBiz;
	
	@Autowired
	private FileManagerBiz fileManagerBiz;
	
//	@Action(value = "/searchNews", results = { @Result(name = "success", location = "/WEB-INF/view/search.jsp", type = "dispatcher") })
//	@RequestMapping(value = "/searchNews")
//	public String SearchNews(
//			HttpServletRequest request, HttpServletResponse response, Model model) {
//		// 关键字
//		String keyword = request.getParameter("keyword");
//		// 页码
//		int pageNo = StrUtils.toInt(request.getParameter("ipage"));
//
//		String hql = "from News where 1=1";
//		if (!StrUtils.isNull(keyword)) {
//			hql += " and  title like '%" +keyword.trim()+"%' or content like '%" + keyword.trim() + "%'";
//		}else{
//			return "search";
//		}
//
//		if (pageNo == 0)
//			pageNo = 1;
//		int limit = 6;
//		int start = pageNo * limit - limit;
//
//		List<News> newsList = newsBiz.getNewsList1(hql, start, limit);
//		List<News> searchList = new ArrayList<News>();
//		int total = newsBiz.getNewsList(hql).size();
//
//		PageControl pageControl = new PageControl(newsList, total, pageNo,
//				start, limit);
//		String pageStr = pageControl.getShowPage();
//		// 关键字反红
//
//		for (News o : newsList) {
//			if (!StrUtils.isNull(keyword)) {
//				o.setTitle(o.getTitle().replaceAll(keyword,
//						"<font color='red'>" + keyword + "</font>"));
//			}
//			searchList.add(o);
//
//		}
//		// 关键字
//		request.setAttribute("keyword", keyword);
//		// 分页样式
//		request.setAttribute("pageStr", pageStr);
//		// 查询结果
//		request.setAttribute("searchList", searchList);
//
//		return "search";
//	}

	/**
	 * @author XiaDi
	 * @since 2013-7-18
	 * @eg http://loaclhost/news/article?cid=1&id=23
	 */
	@RequestMapping(value = "/article")
	public String queryNewsArticle(HttpServletRequest request,
			HttpServletResponse response) {
		int id = StrUtils.toInt(request.getParameter("id"));
		int cid = StrUtils.toInt(request.getParameter("cid"));

		String cname = "";
		if (cid == 1) {
			cname = "展会信息";
		} else if (cid == 2) {
			cname = "最新推荐";
		} else if (cid == 3) {
			cname = "政策法规";
		} else if (cid == 4) {
			cname = "新闻动态";
		} else if (cid == 5) {
			cname = "最新公告";
		} else {
			cname = "";
		}
		String hql = "from News where cid=" + cid + "and id<>" + id
				+ " order by pubdate desc";
		News news = newsBiz.get(id);
		List<News> newsList = newsBiz.getNewsList(hql, 0, 15);
		List<String> cnameList = new ArrayList<String>();
		cnameList.add(cname);
		request.setAttribute("newsList", newsList);
		request.setAttribute("news", news);
		request.setAttribute("cname", cname);
		return "article";
	}

	/**
	 * @author XiaDi
	 * @since 2013-7-18
	 * 
	 * @eg http://loaclhost/news/article?cid=1&id=23
	 */
//	@RequestMapping(value = "/list")
//	public String queryNewsList(HttpServletRequest request,
//			HttpServletResponse response) {
//		int cid = StrUtils.toInt(request.getParameter("cid"));
//		int pageNo = StrUtils.toInt(request.getParameter("ipage"));
//
//		if (pageNo == 0)
//			pageNo = 1;
//		int limit = 20;
//		int start = pageNo * limit - limit;
//		// 类别cid 1为经济咨询,2为政治法规,3为企业服务，4为项目咨询，5热点新闻
//		String cname = "";
//		if (cid == 1) {
//			cname = "经济咨询";
//		} else if (cid == 2) {
//			cname = "政治法规";
//		} else if (cid == 3) {
//			cname = "服务动态";
//		} else if (cid == 4) {
//			cname = "服务指南";
//		} else {
//			cname = "";
//		}
//		String hql = "from News where cid=" + cid + " order by pubdate desc";
//		List<News> newsList = newsBiz.getNewsList1(hql, start, limit);
//		int total = newsBiz.getTotal(hql);
//		PageControl pageControl = new PageControl(newsList, total, pageNo,
//				start, limit);
//		String pageStr = pageControl.getShowPage();
//		request.setAttribute("newsList", newsList);
//		request.setAttribute("pageStr", pageStr);
//		request.setAttribute("cname", cname);
//		request.setAttribute("cid", cid);
//
//		return "list_news";
//	}

	/**
	 * 后台新闻查询
	 * 
	 * @author liuliping
	 * @since 2013-07-25
	 * 
	 * @return
	 * @eg	http://localhost/news/queryNews
	 */
	@RequestMapping(value = "/query")
	public void queryNews(/*@ModelAttribute("passport") Passport passport,*/ HttpServletRequest request,
			HttpServletResponse response) {
		/* 由于查询的接口是使用start和limit作为参数, 此处暂时将page,pagesize转换一下 */
		int start = StrUtils.toInt(request.getParameter("start"));
		int limit = StrUtils.toInt(request.getParameter("limit"));

		int cid = StrUtils.toInt(request.getParameter("cid"));
		String title = request.getParameter("title");
		String hql = "from News where 1=1 ";
		if (cid > 0) {
			hql = hql + " and cid=" + cid;
		} else if (!"".equals(title) && title != null) {
			hql = hql + " and title like '%" + title + "%'";
		}
		hql = hql + "order by pubdate desc";
		List<News> list = newsBiz.getNewsList(hql, start, limit);
		long len = newsBiz.getCount(hql);
		super.outJson(response, new JSONData<News>(true, list, (int)len));
	}

	/**
	 * 后台新闻添加
	 * 
	 * @author liuliping
	 * @since 2013-07-25
	 * 
	 * @return
	 * @eg	houjie/admin/news.jsp调用此接口
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addNews(/*@ModelAttribute("passport") Passport passport, */News news, 
			HttpServletRequest request, HttpServletResponse response) {
		FileManager file = null;
		
		news.setPubdate(StrUtils.formateDate("yyyy-MM-dd HH:mm:ss", new Date()));

		/* 首页上的每个新闻模块都只有一条置顶的新闻，所以每个类别的新闻仅能只有一个对象的isTop为true */
		if (news.getIsTop()) {
			News theTop = newsBiz.getTopNews(news.getCid());
			if (theTop != null) { // 当前有置顶的新闻，则把它的isTop修改为false，即取消置顶
				theTop.setIsTop(false);
				try {
					newsBiz.updateNews(theTop); // 更新
				} catch (Exception e) {
					e.printStackTrace();
					StringBuilder sb = new StringBuilder();
					sb.append("修改置顶新闻失败,id为").append(theTop.getId()).append(":")
						.append(e.getLocalizedMessage());
					logger.error(sb.toString());
				}
			}
		}
		
		/* 根据图片id来初始化 */
		if ((news.getPicture() != null) && (!"".equals(news.getPicture()))) {
			List<FileManager> list = fileManagerBiz.findByName(news.getPicture());
			file = list.get(0);
			file.setClazz("News");
			file.setStatus(true);
		}
		try { // 保存新闻对象,并返回结果信息
			newsBiz.addNews(news);
			if (file != null) {
				fileManagerBiz.updateFileManager(file);
			}
			super.outJson(response, JSONObject.parse("{success:true,message:'已成功新增!'}"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("新增新闻失败:" + e.getLocalizedMessage());
			super.outJson(response, JSONObject.parse("{success:false,message:'操作失败!'}"));
		}
	}
	
	/**
	 * 后台新闻删除
	 * 
	 * @author liuliping
	 * @since 2013-07-25
	 * 
	 * @return
	 * @eg	houjie/admin/news.jsp调用此接口
	 */
	@RequestMapping(value = "/delete")
	public void deleteNews(/*@ModelAttribute("passport") Passport passport,*/String data, HttpServletRequest request,
			HttpServletResponse response) {
		News news = JSONObject.parseObject(data, News.class);
		JSONResult jr = null;
		StringBuilder realPath = new StringBuilder(); // 文件上传到这个文件夹里
		String path = realPath
				.append(request.getSession().getServletContext()
						.getRealPath("")).append(File.separator)
						.append("upload").append(File.separator).toString();
		File deletePic = new File(path + news.getPicture());
		try {
			deletePic.delete();
			newsBiz.deleteNews(news.getId(), path);
			jr = new JSONResult(true, "删除成功!");
		} catch (Exception e) {
			jr = new JSONResult(false, "删除失败!");
			e.printStackTrace();
			logger.error("Id为" + news.getId().toString() + "的新闻删除失败:" + e.getLocalizedMessage());
		} finally {
			super.outJson(response, jr);
		}
//		String ids = request.getParameter("id");
//		String array[] = ids.split(",");
//		JSONResult jr = null;
//		StringBuilder realPath = new StringBuilder(); // 文件上传到这个文件夹里
//		String path = realPath
//				.append(request.getSession().getServletContext()
//						.getRealPath("")).append(File.separator)
//						.append("upload").append(File.separator).toString();
//		int id = 0;
//		try {
//			// 删除图片文件
//			for (int i = 0; i < array.length; i++) {
//				id = StrUtils.toInt(array[i]);
//				File deletePic = new File(path + newsBiz.get(id).getPicture());
//				deletePic.delete();
//				newsBiz.deleteNews(id, path);
//			}
//			jr = new JSONResult(true, "删除成功!");
//		} catch (Exception e) {
//			jr = new JSONResult(false, "删除失败!");
//			e.printStackTrace();
//			logger.error("Id为" + id + "的新闻删除失败:" + e.getLocalizedMessage());
//		} finally {
//			super.outJson(response, jr);
//		}
	}

	/**
	 * 后台更新新闻
	 * 
	 * @author liuliping
	 * @since 2013-07-25
	 * 
	 * @return
	 * @eg	houjie/admin/news.jsp调用此接口
	 */
	@RequestMapping(value = "update")
	public void updNews(/*@ModelAttribute("passport") Passport passport,*/ News news, 
			HttpServletRequest request, HttpServletResponse response) {
		JSONResult jr = null;

		/* 如果修改了新闻图片，则把老的图片进行删除 */
		String originalPic = request.getParameter("originalPic");
		if((news.getPicture() != null) && (!news.getPicture().equals(originalPic))) {
			StringBuilder path = new StringBuilder();
			path.append(request.getSession().getServletContext().getRealPath(""))
				.append(File.separator).append("upload").append(File.separator).append(originalPic);
			File file = new File(path.toString());
			file.delete();
			List<FileManager> list = fileManagerBiz.findByName(originalPic);
			if (list.size() > 0) {
				fileManagerBiz.deleteFileManager(list.get(0).getId());
			}
		}
		
		/* 首页上的每个新闻模块都只有一条置顶的新闻，所以每个类别的新闻仅能只有一个对象的isTop为true */
		if (news.getIsTop()) {
			News theTop = newsBiz.getTopNews(news.getCid());
			if (theTop != null) { // 当前有置顶的新闻，则把它的isTop修改为false，即取消置顶
				// 修改的是当前置顶新闻，此时就复制news的属性值给theTop,并更新theTop，返回响应信息
				if (theTop.getId().intValue() == news.getId().intValue()) {
					BeanUtils.copyProperties(news, theTop);
					try {
						newsBiz.updateNews(theTop);
						jr = new JSONResult(true, "更新成功!");
						logger.info("id为" + theTop.getId() + "的新闻更新成功");
						return;
					} catch (Exception e) {
						jr = new JSONResult(false, "更新失败!");
						logger.error("id为" + theTop.getId() + "的新闻更新失败:"
								+ e.getLocalizedMessage());
						return;
					} finally {
						super.outJson(response, jr);
					}
				} else {
					theTop.setIsTop(false);
					newsBiz.updateNews(theTop); // 更新
				}
			}
		}
		try {
			newsBiz.updateNews(news);
			logger.info("id为" + news.getId() + "的新闻更新成功");
			jr = new JSONResult(true, "更新成功!");
		} catch (Exception e) {
			jr = new JSONResult(false, "更新失败!");
			e.printStackTrace();
			logger.error("id为" + news.getId() + "的新闻更新失败:"
					+ e.getLocalizedMessage());
		} finally {
			super.outJson(response, jr);
		}
	}
}
