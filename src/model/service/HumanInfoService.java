package model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import misc.HibernateUtil;
import model.HumanInfoBean;
import model.dao.HumanInfoDAO;

public class HumanInfoService implements IService<HumanInfoBean> {

	private static HumanInfoDAO dao;
	
	public static void main(String[] args) {
		Session session = HibernateUtil.createSessionFactoty().getCurrentSession();
		dao = new HumanInfoDAO(HibernateUtil.getSessionFactory());
		HumanInfoService service = new HumanInfoService(dao);
		//Transaction trx = dao.getSession().beginTransaction();
		/* Test insert function OK
		try {
			List<HumanInfoBean> select = service.select();
			System.out.println(select);
			//trx.commit();
		} catch (Exception e) {
			for (StackTraceElement s: e.getStackTrace())
			{
				System.out.println(s.toString());
			}
			System.out.println(e.toString());

			//trx.rollback();
		}*/
		
		
		
	}

	
	public HumanInfoService(HumanInfoDAO dao) {
		this.dao = dao;
	}
	
	
	@Override
	public HumanInfoBean insert(HumanInfoBean bean) {
		
		return dao.insert(bean);
	}

	@Override
	public HumanInfoBean select(int id) {
 		return dao.select(id);
	}

	@Override
	public List<HumanInfoBean> select() {
 		return dao.select();
	}

	@Override
	public Boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public HumanInfoBean update(HumanInfoBean bean) {		 
		return dao.update(bean);
	}
	
	 

}
