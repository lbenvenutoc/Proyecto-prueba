package bastanteo.cloud.service;

import java.util.List;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.dao.EmpresaDao;
import bastanteo.cloud.dao.EmpresaDaoImp;

public class EmpresaService {
	
	private EmpresaDao dao= new EmpresaDaoImp();
	
	
	public Empresa obtenerEmpresa(Empresa objEmpresa) {
		return  dao.obtenerEmpresa(objEmpresa);
	}
	public int registrarEmpresa(Empresa objEmpresa) {
		return dao.registrarEmpresa(objEmpresa);
	}
	public int modificarEmpresa(Empresa objEmpresa) {
		return dao.modificarEmpresa(objEmpresa);
	}
	public Empresa obtenerEmpresaxRuc(Empresa objEmpresa) {
		return dao.obtenerEmpresaxRuc(objEmpresa);
	}
	public List listar(){
		return dao.listar();
	}
}
