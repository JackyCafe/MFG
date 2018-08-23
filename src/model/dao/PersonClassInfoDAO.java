package model.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import misc.HibernateUtil;
import model.PersonClassInfoBean;
import model.PersonClassRecordBean;

public class PersonClassInfoDAO implements IDAO<PersonClassInfoBean> {
	public static SessionFactory factory;
	private static Session session;
	private static Transaction trx;
	public PersonClassInfoDAO(SessionFactory factory) {this.factory = factory;}
	
	public static void main(String[] args) {
		factory = HibernateUtil.getSessionFactory();
		session = factory.getCurrentSession();
		PersonClassInfoDAO dao = new PersonClassInfoDAO(factory);
		
		/*Insert*/
		try {
			trx = dao.getSession().beginTransaction();
			PersonClassInfoBean bean = new PersonClassInfoBean();
			bean.setId(0);
			bean.setWorkNum("00409");
			bean.setName("林彥亨");
			bean.setClassName("結晶矽作業區介紹");	
			PersonClassRecordBean records = new PersonClassRecordBean();
			records.setId(0);
			records.setClassDate(new Date());
			records.setTestDate(new Date());
			records.setTestScore(100);
	
			Set<PersonClassRecordBean> personClassRecords = new HashSet<>();
			personClassRecords.add(records);
			bean.setPersonClassRecords(personClassRecords );
			PersonClassInfoBean insert = dao.insert(bean);
			System.out.println(insert);
			trx.commit();
		}catch(Exception e) {
			for (StackTraceElement st:e.getStackTrace())
			{
				System.out.println("error :"+st.getLineNumber());
			}
			
			
			trx.rollback();
		}
		
		/*select*/
		try {
			trx = dao.getSession().beginTransaction();
			List<PersonClassInfoBean> select = dao.select();
			System.out.println(select);
			trx.commit();
		}catch(Exception e) {
			for (StackTraceElement st:e.getStackTrace())
			{
				System.out.println("error :"+st.toString());
			}
			trx.rollback();
		} 
		
	}
	
	@Override
	public PersonClassInfoBean select(PersonClassInfoBean bean) {
		PersonClassInfoBean select = null;
		if (bean!=null)
		{
			select = this.getSession().get(PersonClassInfoBean.class, bean.getId());
		}
 		return select;
	}

	@Override
	public PersonClassInfoBean select(int id) {
		PersonClassInfoBean select = null;
		select = this.getSession().get(PersonClassInfoBean.class, id);		
 		return select; 		
	}

	@Override
	public List<PersonClassInfoBean> select() {
 		return this.getSession()
 				.createQuery("from PersonClassInfoBean", PersonClassInfoBean.class)
 				.getResultList();
	}
	
	/*判斷人員課程資料是否存在*/
	public boolean isExist(String name,String className)
	{
		boolean isX = true;
		int size =
		this.getSession().createQuery("from PersonClassInfoBean where name=:name "
				+ "and className =:className", PersonClassInfoBean.class)
		.setParameter("name", name)
		.setParameter("className", className)
		.getResultList()
		.size();
		if (size>0) isX = true;
		else isX = false;				
		return isX;
		
	}

	@Override
	public PersonClassInfoBean insert(PersonClassInfoBean bean) {
		PersonClassInfoBean insert = null;
		if(bean!=null)
		{
			this.getSession().save(bean);
			System.out.println(bean);
		}
 		return bean;
	}

	@Override
	public Boolean delete(PersonClassInfoBean bean) {
		if(bean !=null)
		{
			this.getSession().delete(bean);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean delete(int id) {
		PersonClassInfoBean delete;
		delete = select(id);
		if(delete !=null)
		{
			this.getSession().delete(delete);
		 	return true;
		}else {
			return false;}
	}

	@Override
	public PersonClassInfoBean update(PersonClassInfoBean bean) {
		PersonClassInfoBean tmp = select(bean);
		if(tmp != null) 
		{
		tmp.setWorkNum(bean.getWorkNum());
		tmp.setName(bean.getName());
		tmp.setClassName(bean.getClassName());		
		tmp.setPersonClassRecords(bean.getPersonClassRecords());
 		return tmp;
		}else {
			return null;
		}
	}

	@Override
	public Session getSession() {
 		return factory.getCurrentSession();
	}

}
