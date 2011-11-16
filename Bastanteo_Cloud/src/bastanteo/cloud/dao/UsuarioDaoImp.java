package bastanteo.cloud.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bastanteo.cloud.bean.Acceso;
import bastanteo.cloud.bean.AccesoId;
import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.util.HibernateUtil;


public class UsuarioDaoImp  implements UsuarioDao{

	public int controlarUsuario (Usuario objusuario){
		int retorno = 0;
		
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(objusuario);
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
	
	public int modificarUsuario (Usuario objusuario){
		int retorno = 0;
		
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(objusuario);
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

	@Override
	public Acceso obtenerAcceso(AccesoId objAccesoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerUsuario(Usuario objUsuario) {
		Session session = HibernateUtil.getSessionFactory();
		Usuario objUsuarioObt = null;
		objUsuarioObt = (Usuario) session.load(Usuario.class, objUsuario.getCUsuario());
		return objUsuarioObt;
	}
	
}
