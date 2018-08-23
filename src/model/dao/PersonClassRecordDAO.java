package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.PersonClassRecordBean;

public class PersonClassRecordDAO implements IDAO<PersonClassRecordBean> {

	public static SessionFactory factory;
	public static Session session;
	private static Transaction trx;
	
	
	
	@Override
	public PersonClassRecordBean select(PersonClassRecordBean bean) {
 		return null;
	}

	@Override
	public PersonClassRecordBean select(int id) {
 		return null;
	}

	@Override
	public List<PersonClassRecordBean> select() {
 		return null;
	}

	@Override
	public PersonClassRecordBean insert(PersonClassRecordBean bean) {
 		return null;
	}

	@Override
	public Boolean delete(PersonClassRecordBean bean) {
 		return null;
	}

	@Override
	public Boolean delete(int id) {
 		return null;
	}

	@Override
	public PersonClassRecordBean update(PersonClassRecordBean bean) {
 		return null;
	}

	@Override
	public Session getSession() {
 		return null;
	}

}
