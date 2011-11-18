package bastanteo.cloud.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.DBastanteoGrupo;
import bastanteo.cloud.util.HibernateUtil;

public class DBastanteoGrupoDaoImp implements DBastanteoGrupoDao {

	private int verificarDBastanteoGruppo(DBastanteoGrupo objDBastanteoGrupo) {
		int retorno = 0;
		
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		List lstResultado = new ArrayList();
		String select = "";
		Query query = null;		
				
		try {
			tx = session.beginTransaction();
			
			select = "select c_empresa from d_bastanteo_grupo where c_empresa = :c_empresa and c_grupo_bastanteo = :c_grupo_bastanteo and c_poder = :c_poder;";
			
			query = session.createSQLQuery(select).addScalar("C_EMPRESA")
					.setResultTransformer(
							AliasToEntityMapResultTransformer.INSTANCE);
			
			query.setString("c_empresa", objDBastanteoGrupo.getId().getCEmpresa());
			query.setInteger("c_grupo_bastanteo", objDBastanteoGrupo.getId().getCGrupoBastanteo());
			query.setString("c_poder", objDBastanteoGrupo.getId().getCPoder());
	
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
		
	public int insertarDBastanteoGrupo(DBastanteoGrupo objDBastanteoGrupo) {
		int retorno;
		
		retorno = verificarDBastanteoGruppo(objDBastanteoGrupo);
		
		if(retorno != 0){
			return retorno;
		}
		
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(objDBastanteoGrupo);
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

	
	
}
