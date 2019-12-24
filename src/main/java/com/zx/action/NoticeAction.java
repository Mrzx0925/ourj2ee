package com.zx.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.entity.Notice;
import com.opensymphony.xwork2.ActionSupport;
import com.zx.dao.NoticeDao;
import com.zx.service.NoticeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 公告
 */
public class NoticeAction extends ActionSupport{

	NoticeService noticeService;
	int nid;
	String ntitle;
	

	public void info() {
		ajax(noticeService.info());
		
	}
	
	public void infobyid() {
		
		ajax(noticeService.infobyid(nid));
		
	}
	
	public void infobytitle() {
		ajax(noticeService.infobytitle(ntitle));
	}
	
	
	
	
	
	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	
	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	
	//传递的是数组json

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
