package com.zx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.entity.Article;
import com.zx.dao.ArticleDao;

public class ArticleService {
	Article article;
	ArticleDao articleDao;
	
	public List<Article> info() {
		List<Article> s = articleDao.findByExample(article);
	
		return s;
		
	}
	
	public List<Article> infobyid(int aid) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Article.class);
		criteria.add(Restrictions.eq("aid", aid));
		List<Article> s = (List<Article>) articleDao.findByCriteria(criteria);
		//System.out.println(s.toString());
		return s;
		
	}
	
	public 	List<Article> infobytitle(String atitle) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Article.class);
		criteria.add(Restrictions.like("atitle", "%"+atitle+"%"));
		List<Article> s = (List<Article>) articleDao.findByCriteria(criteria);
		//System.out.println(s.toString());
		return s;
		
	}
	
	
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public ArticleDao getArticleDao() {
		return articleDao;
	}
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

}
