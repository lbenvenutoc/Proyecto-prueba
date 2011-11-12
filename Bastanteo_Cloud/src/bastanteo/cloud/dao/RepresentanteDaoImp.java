package bastanteo.cloud.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bastanteo.cloud.bean.Representante;
import bastanteo.cloud.util.HibernateUtil;

public class RepresentanteDaoImp implements RepresentanteDao{

	public void inscribirRepresentante(Representante objRepresentante) {

		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(objRepresentante);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

	}

}
