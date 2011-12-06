package bastanteo.cloud.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bastanteo.cloud.bean.TipoIntervencion;
import bastanteo.cloud.util.HibernateUtil;

public class TipoIntervencionDaoImp implements TipoIntervencionDao{


	public List listar() {
		List listaEmpresa=null;
		Session session=HibernateUtil.getSessionFactory();
		
		try{
			session.beginTransaction();
			
			
			listaEmpresa=session.createQuery("select ti from TipoIntervencion ti").list();
				return listaEmpresa;
		
			
		}finally{
			session.close();
		}
	}

	@Override
	public TipoIntervencion obtenerTipoIntervencion(TipoIntervencion objTipoInt) {
		TipoIntervencion objObt=null;
		Session session=HibernateUtil.getSessionFactory();
		Query q= null;
		try{
			session.beginTransaction();
			
			
			q=session.createQuery("select ti from TipoIntervencion ti where ti.CTipoIntervencion=:cod");
			q.setParameter("cod", objTipoInt.getCTipoIntervencion());
			objObt=(TipoIntervencion) q.uniqueResult();
			return objObt;
		
			
		}finally{
			session.close();
		}
	}

}
