package com.zx.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.entity.Article;
import com.zx.dao.ArticleDao;
import com.zx.service.ArticleService;

import net.sf.json.JSONArray;

/**
 * 新闻类Action方法
 * 
 * @author zx
 *
 */
public class ArticleAction {

	ArticleService articleService;
	int aid;
	String atitle;

	/*
	 * 获得所有新闻信息
	 */

	public void info() {

		ajax(articleService.info());

	}

	/*
	 * 根据ID获得新闻信息
	 */

	public void infobyid() {

		ajax(articleService.infobyid(aid));

	}

	/*
	 * 根据标题获得新闻信息
	 */
	public void infobytitle() {
		ajax(articleService.infobytitle(atitle));

	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	// 传递的是数组json

	public String ajax(Object out) {
		PrintWriter writer = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json;charset=utf-8");
			writer = response.getWriter();
			response.setDateHeader("Expires", 0);
			JSONArray object = JSONArray.fromObject(out);
			writer.write(object.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		return null;
	}

}
