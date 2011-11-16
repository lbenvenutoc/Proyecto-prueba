package bastanteo.cloud.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import bastanteo.cloud.bean.Representante;
import bastanteo.cloud.util.HibernateUtil;
import bastanteo.cloud.util.Utilitario;

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

	@Override
	public List obtenerRepresentantesPorDni(
			Representante objRepresentante) {
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		List lstResultado = new ArrayList();
		String select = "";
		Query query = null;
		
		

		try {

			tx = session.beginTransaction();
			select = "select r.num_doc_id as 'DNI' from representante r where r.num_doc_id=:dni";

			query = session.createSQLQuery(select).addScalar("DNI")
				.setResultTransformer(
							AliasToEntityMapResultTransformer.INSTANCE);
			
			query.setString("dni", objRepresentante.getNumDocId());

			lstResultado = query.list();

		
			tx.commit();
			return lstResultado;

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			try {
				throw e;
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		} finally {
			session.close();

		}
		return null;

	}

}
