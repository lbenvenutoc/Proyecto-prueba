package bastanteo.cloud.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.BastanteoId;
import bastanteo.cloud.util.HibernateUtil;



public class BastanteoDaoImp implements BastanteoDao {

	public int insertarBastanteo(Bastanteo objBastanteo) {
		
		int li_retorno;
		
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(objBastanteo);
			tx.commit();
			li_retorno = 1;
		} catch (Exception ex) {
			tx.rollback();
			li_retorno = 0;
		} finally {
			session.close();
		}
		
		return li_retorno;
	}

	public int actualizarBastanteo(Bastanteo objBastanteo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Bastanteo obtenerBastanteo(BastanteoId objBastanteoId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
