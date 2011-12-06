package bastanteo.cloud.dao;

import java.util.List;

import org.hibernate.Session;

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

}
