package bastanteo.cloud.action;

import java.io.Serializable;
import java.util.List;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.service.EmpresaService;






public class EmpresaAction implements  Serializable{
	
	
	private EmpresaService servicioEmpresa= new EmpresaService();
	

	public Empresa getObjEmpresa() {
		return objEmpresa;
	}


	public void setObjEmpresa(Empresa objEmpresa) {
		this.objEmpresa = objEmpresa;
	}


	private Empresa objEmpresa;
	private List<Empresa> lstEmpresa;
	
	
	
	
	
	public List<Empresa> getLstEmpresa() {
		return lstEmpresa;
	}


	public void setLstEmpresa(List<Empresa> lstEmpresa) {
		this.lstEmpresa = lstEmpresa;
	}


	public String listaEmpresa(){
		
		lstEmpresa=servicioEmpresa.listar();
		
		return "listaEmpresa";
	}
	
	public String registraEmpresa(){
		
		
		
		return "registraEmpresa";
	}
	
	
	

}
