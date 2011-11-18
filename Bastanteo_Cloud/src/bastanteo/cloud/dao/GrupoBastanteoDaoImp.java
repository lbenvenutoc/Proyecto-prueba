package bastanteo.cloud.dao;

import org.hibernate.Session;

import bastanteo.cloud.bean.GrupoBastanteo;
import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.util.HibernateUtil;

public class GrupoBastanteoDaoImp implements GrupoBastanteoDao {

	
	public GrupoBastanteo obtenerGrupoBastanteo(GrupoBastanteo objGrupoBastanteo) {
		Session session = HibernateUtil.getSessionFactory();
		GrupoBastanteo objGrupo=null;
		try{
			objGrupo=(GrupoBastanteo)session.get(GrupoBastanteo.class, objGrupoBastanteo.getId());
		}catch (Exception ex) {
			System.out.println(ex);
		}finally {
			session.close();
		}
		
		return objGrupo;
	}

}
