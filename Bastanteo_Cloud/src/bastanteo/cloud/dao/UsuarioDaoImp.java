package bastanteo.cloud.dao;

import java.util.List;

import org.hibernate.Query;
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
			System.out.println(ex);
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
		try{
			objUsuarioObt = (Usuario) session.get(Usuario.class, objUsuario.getCUsuario());
		}catch (Exception ex) {
			System.out.println(ex);
		}finally{
			session.close();
		}
	
		return objUsuarioObt;
		
	
	}

	@Override
	public Usuario obtenerUsuarioxDni(Usuario objUsuario) {
		Session session = HibernateUtil.getSessionFactory();
		Query q=null;
		Usuario objUsuarioObt=null;
		try{
			q=session.createQuery("from Usuario where dni=:dni");
			q.setParameter("dni", objUsuario.getDni());
			objUsuarioObt=(Usuario)q.uniqueResult();
		}catch (Exception ex) {
			System.out.println(ex);
		}finally{
			session.close();
		}
		
		return objUsuarioObt;
	}

	@Override
	public Usuario obtenerUsuarioxLogueo(Usuario objUsuario) {
		Session session = HibernateUtil.getSessionFactory();
		Query q=null;
		Usuario objUsuarioObt=null;
		try{
			q=session.createQuery("select u from Usuario u join fetch u.perfil p join fetch p.accesos where u.login=:login and u.clave=:clave");
			q.setParameter("login", objUsuario.getLogin());
			q.setParameter("clave", objUsuario.getClave());
			objUsuarioObt=(Usuario)q.uniqueResult();
		}catch (Exception ex) {
			System.out.println(ex);
		}finally{
			session.close();
		}
		
		return objUsuarioObt;
	}

	@Override
	public List lista() {
		Session session = HibernateUtil.getSessionFactory();
		Query q=null;
		List lstUsuario=null;
		try{
			q=session.createQuery("select u from Usuario u join fetch u.perfil where u.flagActivo<>'M'");
			
			lstUsuario=(List)q.list();
		}catch (Exception ex) {
			System.out.println(ex);
		}finally{
			session.close();
		}
		
		return lstUsuario;
	}
	
}
