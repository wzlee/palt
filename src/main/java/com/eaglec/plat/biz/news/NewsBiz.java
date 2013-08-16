package com.eaglec.plat.biz.news;

import java.util.List;

import com.eaglec.plat.domain.News;

public interface NewsBiz {
	public News get(int id);

	public void addNews(News oh);

	public void deleteNews(int id, String realpath);

	public void updateNews(News news);

	public List<News> findNewsById(int newsNo);

	public List<News> getList();

	public List<News> getNewsList(int start, int limit);

	public List<News> getNewsList(String hql, int start, int limit);

	public long getCount(String hql);

	public List<News> getNewsList(String hql);

	public News getTopNews(Integer cid);

}
