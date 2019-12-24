package com.zx.action;

import java.io.PrintWriter;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.entity.Notice;
import com.entity.ProductInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.zx.dao.ProductDao;
import com.zx.service.ProductService;

import net.sf.json.JSONArray;
/*
 * 产品
 */
public class ProductAction extends ActionSupport {
	ProductService productService;
	String pname;
	public void info() {

		ajax(productService.info());

	}

	public void infobyname() {
		ajax(productService.infobyname(pname));
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
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
