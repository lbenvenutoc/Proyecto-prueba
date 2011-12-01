package bastanteo.cloud.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.Query;
import org.hibernate.Session;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.TipoEmpresa;
import bastanteo.cloud.util.HibernateUtil;

public class TipoEmpresaDaoImp implements TipoEmpresaDao{

	@Override
	public TipoEmpresa obtenerTipoEmpresa(TipoEmpresa objTipoEmpresa) {
		Session session = HibernateUtil.getSessionFactory();
		TipoEmpresa objTipoEmpresaObt=null;
		try{
			objTipoEmpresaObt=(TipoEmpresa)session.get(TipoEmpresa.class, objTipoEmpresa.getCTipoEmpresa());
		}catch (Exception ex) {
			System.out.println(ex);
		}finally{
			session.close();
		}
		
		return objTipoEmpresaObt;
	}
	
	public List listar() {
		List listaEmpresa=null;
		Session session=HibernateUtil.getSessionFactory();
		
		try{
			session.beginTransaction();
			
			
			listaEmpresa=session.createQuery("select te from TipoEmpresa te").list();
				return listaEmpresa;
		
			
		}finally{
			session.close();
		}
	}

	@Override
	public TipoEmpresa obtenerTipoEmpresa(int codigo) {
		Session sesion=HibernateUtil.getSessionFactory();
		TipoEmpresa objTipoEmpresaObt=null;
		try{
			Query q= null;
			q= sesion.createQuery("from TipoEmpresa te where te.CTipoEmpresa=:cod");
			q.setParameter("cod", codigo);
			objTipoEmpresaObt=(TipoEmpresa)q.uniqueResult();
		}catch (Exception ex) {
			System.out.println(ex);
		}finally {
			sesion.close();
		}
	
		return objTipoEmpresaObt;
	}

	


}
