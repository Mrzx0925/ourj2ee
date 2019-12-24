package com.zx.service;


import java.util.List;

import com.entity.Article;
import com.entity.CompanyInfo;
import com.entity.Notice;
import com.zx.dao.IndexDao;


public class IndexService {
	IndexDao indexDao;
	CompanyInfo companyInfo;
	Notice notice;
	Article article;

	public CompanyInfo companyInfo() {

		List<CompanyInfo> s = indexDao.findByExample(companyInfo);
		companyInfo = s.get(0);
		return companyInfo;

	}

	public Article article() {

		List<Article> s = indexDao.findByExample(article);
		article = s.get(0);
		return article;

	}
	
	public Notice notice() {
		List<Notice> s = indexDao.findByExample(notice);
		notice = s.get(0);
		return notice;
	}

	public IndexDao getIndexDao() {
		return indexDao;
	}

	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}
