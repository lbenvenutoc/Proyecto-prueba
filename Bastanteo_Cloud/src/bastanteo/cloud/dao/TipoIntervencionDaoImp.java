package bastanteo.cloud.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bastanteo.cloud.bean.TipoIntervencion;
import bastanteo.cloud.util.HibernateUtil;

public class TipoIntervencionDaoImp implements TipoIntervencionDao {

	/**
	 * Función que registra un nuevo Tipo de Intervención.
	 * 
	 * @return int Valor de retorno de la función, sale 1 cuando es correcto y 
	 * 0 cuando existe algun error.
	 */
	public int registrarTipoIntervencion(TipoIntervencion objtipoIntervencion) {
		
		int retorno = 0;
		
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(objtipoIntervencion);
			tx.commit();
			retorno = 1;
		} catch (Exception ex) {
			tx.rollback();
			retorno = 0;
		} finally {
			session.close();
		}
		return retorno;

	}

	
	public int modificarTipoIntervencion(TipoIntervencion objtipoIntervencion) {

		int retorno = 0;
		
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(objtipoIntervencion);
			tx.commit();
			retorno = 1;
		} catch (Exception ex) {
			tx.rollback();
			retorno = 0;
		} finally {
			session.close();
		}
		return retorno;

	}

	
	public TipoIntervencion obtenerTipoIntervencion(String codigo) {
		
		Session session = HibernateUtil.getSessionFactory();
		TipoIntervencion objTipoIntervencion = null;
		try{
			objTipoIntervencion = (TipoIntervencion) session.get(TipoIntervencion.class, codigo);
		}catch (Exception ex) {
			System.out.println(ex);
		}finally{
			session.close();
		}
		

		return objTipoIntervencion;
	}

}
