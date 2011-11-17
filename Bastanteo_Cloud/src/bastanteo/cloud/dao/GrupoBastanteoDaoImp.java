package bastanteo.cloud.dao;

import org.hibernate.Session;

import bastanteo.cloud.bean.GrupoBastanteo;
import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.util.HibernateUtil;

public class GrupoBastanteoDaoImp implements GrupoBastanteoDao {

	
	public GrupoBastanteo obtenerGrupoBastanteo(GrupoBastanteo objGrupoBastanteo) {
		Session session = HibernateUtil.getSessionFactory();
		GrupoBastanteo objGrupo=null;
		objGrupo=(GrupoBastanteo)session.get(GrupoBastanteo.class, objGrupoBastanteo.getId());
		return objGrupo;
	}

}
