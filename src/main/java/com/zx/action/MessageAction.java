package com.zx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.Message;
import com.opensymphony.xwork2.ActionSupport;
import com.zx.dao.MessageDao;
import com.zx.service.MessageService;

import net.sf.json.JSONArray;

/*
 *留言
 */
public class MessageAction extends ActionSupport{
	MessageService messageService;
	
	private String mcontent;;
	private String name;
	private String phone;
	private String email;
	
	/*
	 * 保存
	 */
	public void save() {
		messageService.save(mcontent,name,phone,email);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		PrintWriter writer;
		try {
			writer = response.getWriter();
			response.setDateHeader("Expires", 0);
			writer.write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	
	
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public MessageService getMessageService() {
		return messageService;
	}


	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
}
