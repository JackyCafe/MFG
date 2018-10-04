package model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import misc.HibernateUtil;
import model.ClassInfoBean;
import model.HumanInfoBean;
import model.dao.ClassInfoDAO;
import model.dao.HumanInfoDAO;

public class ClassInfoService implements IService<ClassInfoBean> {

	private static ClassInfoDAO dao;
	
	public static void main(String[] args) {
		Session session = HibernateUtil.createSessionFactoty().getCurrentSession();
		dao = new ClassInfoDAO(HibernateUtil.createSessionFactoty());
		ClassInfoService service = new ClassInfoService(dao);
		Transaction trx = dao.getSession().beginTransaction();
		try {
			List<?> levelCount = service.getLevelCount();
			trx.commit();
			for(int i = 0;i<levelCount.size();i++)
			{
				Object [] row = (Object [])levelCount.get(i);
				String level = (String) row[0];
				long level_count = (long) row[1]; 
				System.out.println(level+":"+level_count);
 			}
			
		}catch(Exception e)
		{
			for(StackTraceElement st : e.getStackTrace())
			{
				System.out.println(st.getLineNumber());
			}
			System.out.println(e.toString());
			trx.rollback();
		}
		
		try {
			trx = dao.getSession().beginTransaction();
			List<ClassInfoBean> select = service.select();			
 			trx.commit();
		} catch (Exception e) {
			for (StackTraceElement s: e.getStackTrace())
			{
				System.out.println(s.toString());
			}
			System.out.println(e.toString());

			trx.rollback();
		}
		
	}

	
	public ClassInfoService(ClassInfoDAO dao) {
		this.dao = dao;
	}
	
	public List<?> getLevelCount()
	{
		String hql = "select level,count(level) as count from ClassInfoBean group by level";
		return dao.getSession().createQuery(hql).list();
	}
	
	@Override
	public ClassInfoBean insert(ClassInfoBean bean) {
		
		return dao.insert(bean);
	}

	@Override
	public ClassInfoBean select(int id) {
 		return dao.select(id);
	}

	@Override
	public List<ClassInfoBean> select() {
 		return dao.select();
	}

	@Override
	public Boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public ClassInfoBean update(ClassInfoBean bean) {		 
		return dao.update(bean);
	}

}
