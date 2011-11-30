package bastanteo.cloud.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.Session;

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

	


}
