package bastanteo.cloud.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.BastanteoId;
import bastanteo.cloud.util.HibernateUtil;



public class BastanteoDaoImp implements BastanteoDao {

	private int verificarBastanteo(Bastanteo objBastanteo) {
		int retorno = 0;
		
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		List lstResultado = new ArrayList();
		String select = "";
		Query query = null;		
				
		try {
			tx = session.beginTransaction();
			
			select = "select c_empresa from bastanteo where c_empresa = :c_empresa and c_grupo_bastanteo = :c_grupo_bastanteo and c_poder = :c_poder and c_tipo_intervencion = :c_tipo_intervencion;";
			
			query = session.createSQLQuery(select).addScalar("C_EMPRESA")
					.setResultTransformer(
							AliasToEntityMapResultTransformer.INSTANCE);
			
			query.setString("c_empresa", objBastanteo.getId().getCEmpresa());
			query.setInteger("c_grupo_bastanteo", objBastanteo.getId().getCGrupoBastanteo());
			query.setString("c_poder", objBastanteo.getId().getCPoder());
			query.setInteger("c_tipo_intervencion", objBastanteo.getTipoIntervencion().getCTipoIntervencion());
			
			lstResultado = query.list();
			
			if(lstResultado.size() > 0) {
				retorno = -1;
			}else {
				retorno = 1;
			}
			
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			try {
				throw e;
			} catch (Exception e1) {

				e1.printStackTrace();
			}
			retorno = 0;
		} finally{
			session.close();
		}
		
		return retorno;
	}
	
	public int insertarBastanteo(Bastanteo objBastanteo) {
		
		int retorno;
		
		retorno = verificarBastanteo(objBastanteo);
		if(retorno != 0){
			return retorno;
		}
		
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(objBastanteo);
			tx.commit();
			retorno = 1;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			tx.rollback();
			retorno = 0;
		} finally {
			session.close();
		}
		
		return retorno;
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
