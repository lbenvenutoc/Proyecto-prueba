package bastanteo.cloud.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.util.HibernateUtil;

public class PoderDaoImp implements PoderDao {

	public void registrarPoder(Poder objPoder) {

		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(objPoder);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

	}

	
	public Poder obtenerPoder(String codigo) {
		
		Session session = HibernateUtil.getSessionFactory();
		Poder objPoder=null;
		objPoder=(Poder) session.load(Poder.class, codigo);
			
		return objPoder;
		
	}

}
