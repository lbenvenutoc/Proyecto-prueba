package bastanteo.cloud.service;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.dao.EmpresaDao;
import bastanteo.cloud.dao.EmpresaDaoImp;

public class EmpresaService {
	
	private EmpresaDao dao= new EmpresaDaoImp();
	
	
	public Empresa obtenerEmpresa(Empresa objEmpresa) {
		return  dao.obtenerEmpresa(objEmpresa);
	}
	

}
