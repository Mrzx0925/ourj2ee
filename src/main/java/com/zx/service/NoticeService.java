package com.zx.service;


import java.util.List;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.entity.Notice;
import com.zx.dao.NoticeDao;



public class NoticeService {
	Notice notice;
	NoticeDao noticeDao;
	
	public List<Notice> info() {
		List<Notice> s = noticeDao.findByExample(notice);
		return s;		
   }
	
	public List<Notice> infobyid(int nid) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Notice.class);
		criteria.add(Restrictions.eq("nid", nid));
		List<Notice> s = (List<Notice>) noticeDao.findByCriteria(criteria);
		//System.out.println(s.toString());
		return s;
		
	}
	
	public List<Notice> infobytitle(String ntitle) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Notice.class);
		criteria.add(Restrictions.like("ntitle", "%"+ntitle+"%"));
		List<Notice> s = (List<Notice>) noticeDao.findByCriteria(criteria);
		//System.out.println(s.toString());
		return s;
		
	}
	
	
	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
}
