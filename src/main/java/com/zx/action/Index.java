package com.zx.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Article;
import com.entity.CompanyInfo;
import com.entity.Message;
import com.entity.Notice;
import com.opensymphony.xwork2.ActionSupport;
import com.zx.dao.IndexDao;
import com.zx.service.IndexService;

import net.sf.json.JSONObject;

/**
 * 首页信息
 * @author zx
 *
 */
public class Index extends ActionSupport {
    IndexService indexService;

    
    /*
     * 获得公司信息
     */
	public void companyInfo() {
		ajax(indexService.companyInfo());
	}

	
	/*
	 * 获得第一个新闻信息
	 */
	public void article() {

		ajax(indexService.article());

	}
	/*
	 * 获得第一个公告信息
	 */
	public void notice() {
		ajax(indexService.notice());
	}

	
	

	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	public String ajax(Object out) {
		PrintWriter writer = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json;charset=utf-8");
			writer = response.getWriter();
			response.setDateHeader("Expires", 0);
			JSONObject object = JSONObject.fromObject(out);
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
