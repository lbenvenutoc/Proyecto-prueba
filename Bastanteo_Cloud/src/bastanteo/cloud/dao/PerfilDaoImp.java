package bastanteo.cloud.dao;

import org.hibernate.Session;

import bastanteo.cloud.bean.Perfil;

import bastanteo.cloud.util.HibernateUtil;

public class PerfilDaoImp implements PerfilDao {

	@Override
	public Perfil obtenerPerfil(Perfil objPerfil) {
		Session session = HibernateUtil.getSessionFactory();
		Perfil objPerfilObt = null;
		try{
			objPerfilObt = (Perfil) session.get(Perfil.class, objPerfil.getCPerfil());
		}catch (Exception ex) {
			System.out.println(ex);
		}finally {
			
			session.close();
			
		}
		
		
		return objPerfilObt;
	}

}
