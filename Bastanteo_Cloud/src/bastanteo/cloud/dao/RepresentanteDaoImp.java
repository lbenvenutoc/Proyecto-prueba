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

	@Override
	public int modificarRepresentantes(Representante objRepresentante) {
		// TODO Auto-generated method stub
		int indicador=0;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(objRepresentante);
			tx.commit();
			indicador=1;
		} catch (Exception ex) {
			tx.rollback();
			indicador=0;
		} finally {
			session.close();
		}
		
		return indicador;

	}

	@Override
	public Representante obtenerRepresentantes(Representante objRepresentante) {
		Session session = HibernateUtil.getSessionFactory();
		Representante objRepresentanteObt=null;
		objRepresentanteObt=(Representante)session.load(Representante.class, objRepresentante.getId());
		return objRepresentanteObt;
	}

}
