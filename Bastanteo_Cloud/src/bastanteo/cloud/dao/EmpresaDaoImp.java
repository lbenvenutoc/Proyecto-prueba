package bastanteo.cloud.dao;

import org.hibernate.Session;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.util.HibernateUtil;

public class EmpresaDaoImp implements EmpresaDao {

	@Override
	public Empresa obtenerEmpresa(Empresa objEmpresa) {
		Session sesion=HibernateUtil.getSessionFactory();
		Empresa objEmpresaObt=null;
		objEmpresaObt=(Empresa)sesion.get(Empresa.class, objEmpresa.getCEmpresa());
		return objEmpresaObt;
	}

}
