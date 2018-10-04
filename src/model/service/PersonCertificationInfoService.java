package model.service;

import java.util.List;

import org.hibernate.Transaction;

import misc.HibernateUtil;
import model.PersonCertificationInfoBean;
import model.dao.PersonCertificationInfoDAO;

public class PersonCertificationInfoService implements IService<PersonCertificationInfoBean> {
	private static PersonCertificationInfoDAO dao;
	private static Transaction trx;
	
	public static void main(String[] args) {
		dao = new PersonCertificationInfoDAO(HibernateUtil.getSessionFactory());
		PersonCertificationInfoService service = new PersonCertificationInfoService(dao);
		try {
			trx = dao.getTransaction();
			PersonCertificationInfoBean bean =
					new PersonCertificationInfoBean("00409", "林彥亨", "CVD", "NB", "安裝", "安裝");
			bean.setId(0);
			PersonCertificationInfoBean insert = dao.insert(bean);
			System.out.println(insert);
 			trx.commit();
		}catch (Exception e) {
			for (StackTraceElement st  : e.getStackTrace()) {
				System.out.println(st.toString());
			}
			trx.rollback();	
		}
		
		try {
			trx = dao.getTransaction();			 
			List<PersonCertificationInfoBean> select = dao.select();
			System.out.println(select);
 			trx.commit();
		}catch (Exception e) {
			for (StackTraceElement st  : e.getStackTrace()) {
				System.out.println(st.toString());
			}
			trx.rollback();	
		}
		
		
	}
	
	public PersonCertificationInfoService(PersonCertificationInfoDAO dao) {
		this.dao = dao;
	}

	
	//判斷學科存在嗎?
	public boolean isKnowledgeExist(String name, String knowledge) {
		boolean isKnowledgeExist = false;
		for (PersonCertificationInfoBean bean : select()) {
			if (bean.getName().equals(knowledge)) {
				if (bean.getKnowledge().equals(knowledge)) {
					return isKnowledgeExist;
				}
			}
		}
		return isKnowledgeExist;
	}

	
	//判斷術科存在嗎?
	public boolean isTechnicalExist(String name, String technical) {
		boolean isTechnicalExist = false;
		for (PersonCertificationInfoBean bean : select()) {
			if (bean.getName().equals(technical)) {
				if (bean.getKnowledge().equals(technical)) {
					return isTechnicalExist;
				}
			}
		}
		return isTechnicalExist;
	}

	

	@Override
	public PersonCertificationInfoBean insert(PersonCertificationInfoBean bean) {
		return dao.insert(bean);
	}

	@Override
	public PersonCertificationInfoBean select(int id) {
		return dao.select(id);
	}

	@Override
	public List<PersonCertificationInfoBean> select() {
		return dao.select();
	}

	@Override
	public Boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public PersonCertificationInfoBean update(PersonCertificationInfoBean bean) {
		return dao.update(bean);
	}

}
