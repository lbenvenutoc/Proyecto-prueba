package bastanteo.cloud.dao;

import org.hibernate.Session;

import bastanteo.cloud.bean.Perfil;

import bastanteo.cloud.util.HibernateUtil;

public class PerfilDaoImp implements PerfilDao {

	@Override
	public Perfil obtenerPerfil(Perfil objPerfil) {
		Session session = HibernateUtil.getSessionFactory();
		Perfil objPerfilObt = null;
		objPerfilObt = (Perfil) session.load(Perfil.class, objPerfil.getCPerfil());
		return objPerfilObt;
	}

}
