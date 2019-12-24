package com.zx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.entity.ProductInfo;
import com.zx.dao.ProductDao;

public class ProductService {
	ProductInfo product;
	ProductDao productDao;
	public List<ProductInfo> info() {
		List<ProductInfo> s = productDao.findByExample(product);
		return s;
		
	}
	public List<ProductInfo> infobyname(String pname) {
		DetachedCriteria criteria=DetachedCriteria.forClass(ProductInfo.class);
		criteria.add(Restrictions.like("pname", "%"+pname+"%"));
		List<ProductInfo> s = (List<ProductInfo>) productDao.findByCriteria(criteria);
		return s;
		
	}
	
	public ProductInfo getProduct() {
		return product;
	}

	public void setProduct(ProductInfo product) {
		this.product = product;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	
}
