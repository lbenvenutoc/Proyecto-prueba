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

	public int inscribirRepresentante(Representante objRepresentante) {
		int resultado=0;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(objRepresentante);
			tx.commit();
			resultado=1;
		} catch (Exception ex) {
			System.out.println(ex);
			tx.rollback();
			resultado=0;
		} finally {
			session.close();
		}
		return resultado;
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
			System.out.println(ex);
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
		try{
			objRepresentanteObt=(Representante)session.get(Representante.class, objRepresentante.getId());
		}catch (Exception ex) {
			System.out.println(ex);
		}finally{
			session.close();
		}
		
		return objRepresentanteObt;
	}

	@Override
	public boolean existeDniRepresentante(
			Representante objRepresentante) {
		
		boolean resultado=false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		List lstResultado = new ArrayList();
		String select = "";
		Query query = null;
		
		

		try {

			tx = session.beginTransaction();
			select = "select r.* from representante r where r.num_doc_id=:dni";

			query = session.createSQLQuery(select);
			query.setString("dni", objRepresentante.getNumDocId());

			lstResultado = query.list();

		
			tx.commit();
			
			if(lstResultado.size()>0){
				resultado=true;
			}

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
		return resultado;

	}

	@Override
	public boolean perteneceEmpresaRepresentante(Representante objRepresentante) {
		boolean resultado=false;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		List lstResultado = new ArrayList();
		String select = "";
		Query query = null;
		
		

		try {

			tx = session.beginTransaction();
			//select = "select e.* from representante r inner join empresa e on e.c_empresa=r.c_empresa_fk where r.c_tipo_doc_id=:tipDocId and r.num_doc_id=:dni";
			select = "select e.* from representante r inner join empresa e on e.c_empresa=r.c_empresa where r.c_tipo_doc_id=:tipDocId and r.num_doc_id=:dni";
			
			query = session.createSQLQuery(select);
			query.setInteger("tipDocId", objRepresentante.getTipoDocId().getCTipoDocId());
			query.setString("dni", objRepresentante.getNumDocId());

			lstResultado = query.list();

		
			tx.commit();
			
			if(lstResultado.size()>0){
				resultado=true;
			}

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
		return resultado;
	}

	
	public List listar() {
		List listaRepresentante=null;
		Session session=HibernateUtil.getSessionFactory();
		
		try{
			session.beginTransaction();
			
			
			listaRepresentante=session.createQuery("select r from Representante r join fetch r.empresa join fetch r.grupoBastanteo").list();
				return listaRepresentante;
		
			
		}finally{
			session.close();
		}
	}

}
