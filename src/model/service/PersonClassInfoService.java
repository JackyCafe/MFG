package model.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import misc.HibernateUtil;
import model.PersonClassInfoBean;
import model.dao.PersonClassInfoDAO;

public class PersonClassInfoService implements IService<PersonClassInfoBean>{

	private static PersonClassInfoDAO dao;
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		PersonClassInfoDAO dao = new PersonClassInfoDAO(factory);
		PersonClassInfoService service = new PersonClassInfoService(dao);
		Transaction trx = dao.getSession().beginTransaction();
		/*  Test insert & Select 
		 	try {
			PersonClassInfoBean bean = new PersonClassInfoBean();
			bean.setId(0);
			bean.setWorkNum("00409");
			bean.setName("林彥亨");
			bean.setClassName("製造組人員規範");
			bean.setPersonClassRecords(null);
			service.insert(bean);
			trx.commit();
		}catch(Exception e) {
			trx.rollback();
		}		
		
		
		try {
			trx = dao.getSession().beginTransaction();
			List<PersonClassInfoBean> select = service.select();
			System.out.println(select);
			trx.commit();
		}catch(Exception e) {
			trx.rollback();
		}*/
		
		try {
			trx = dao.getSession().getTransaction();					
			boolean isX = service.isExist("林彥亨", "製造組人員規範");
			System.out.println(isX);
			trx.commit();
		}catch(Exception e)
		{
			System.out.println(e.toString());
			trx.rollback();
		}
	
	}
	
	public PersonClassInfoService(PersonClassInfoDAO dao) {
		this.dao = dao;
	}
	


	
	@Override
	public PersonClassInfoBean insert(PersonClassInfoBean bean) {
 		return dao.insert(bean);
	}

	@Override
	public PersonClassInfoBean select(int id) {
 		return dao.select(id);
	}

	@Override
	public List<PersonClassInfoBean> select() {
 		return dao.select();
	}

	@Override
	public Boolean delete(int id) {
 		return dao.delete(id);
	}

	@Override
	public PersonClassInfoBean update(PersonClassInfoBean bean) {
 		return dao.update(bean);
	}
	
	public boolean isExist(String name,String className)
	{
		return dao.isExist(name, className);
	}

}
