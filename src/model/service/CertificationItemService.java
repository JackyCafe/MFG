package model.service;

import java.util.List;

import org.hibernate.Transaction;

import misc.HibernateUtil;
import model.CertificationItemBean;
import model.dao.CertificationItemDAO;

public class CertificationItemService implements IService<CertificationItemBean> {
	private static CertificationItemDAO dao; 
	
	public static void main(String[] args) {		
		
		dao = new CertificationItemDAO(HibernateUtil.getSessionFactory());
		CertificationItemService service = new CertificationItemService(dao);
		Transaction trx = dao.getSession().beginTransaction();		
		//insert
		try {
			trx = trx.isActive()?dao.getSession().getTransaction():dao.getSession().beginTransaction();					
			CertificationItemBean bean = new CertificationItemBean("CVD", "HCW 安裝", "HCW 安裝");
			bean.setId(0);
			CertificationItemBean insert = service.insert(bean);
			System.out.println(bean);
			trx.commit();			
		} catch (Exception e) {
			 for(StackTraceElement st:e.getStackTrace())
				 System.out.println(st.toString());
			 trx.rollback();
		}
		 
		
		//update
		try {
			trx = trx.isActive()?dao.getSession().getTransaction():dao.getSession().beginTransaction();					
			CertificationItemBean bean = new CertificationItemBean("CVD", "CWH 安裝", "CWH 安裝");
			bean.setId(2);
			CertificationItemBean update = service.update(bean);
			System.out.println(update);
			trx.commit();			
		} catch (Exception e) {
			 for(StackTraceElement st:e.getStackTrace())
				 System.out.println(st.toString());
			 trx.rollback();
		}
		//delete
		try {
			trx = trx.isActive()?dao.getSession().getTransaction():dao.getSession().beginTransaction();			
		 	Boolean delete = service.delete(1);
			System.out.println(delete);
			trx.commit();			
		} catch (Exception e) {
			 for(StackTraceElement st:e.getStackTrace())
				 System.out.println(st.toString());
			 trx.rollback();
		}
		//read
		try {
			trx = trx.isActive()?dao.getSession().getTransaction():dao.getSession().beginTransaction();
			List<CertificationItemBean> select = service.select();
			System.out.println(select);
			trx.commit();			
		} catch (Exception e) {
			 System.out.println(e.toString());
			 trx.rollback();
		}
		
	}
	
    public CertificationItemService(CertificationItemDAO dao) {
    	this.dao = dao;
	}
	
	
	@Override
	public CertificationItemBean insert(CertificationItemBean bean) {
 		return dao.insert(bean);
	}

	@Override
	public CertificationItemBean select(int id) {
 		return dao.select(id);
	}

	@Override
	public List<CertificationItemBean> select() {
		return dao.select();
	}

	@Override
	public Boolean delete(int id) {		 
		return dao.delete(id);
	}

	@Override
	public CertificationItemBean update(CertificationItemBean bean) {   
		return dao.update(bean);
	}

}
