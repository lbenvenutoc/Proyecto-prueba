package bastanteo.cloud.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.TipoEmpresa;
import bastanteo.cloud.service.EmpresaService;
import bastanteo.cloud.service.TipoEmpresaService;






public class EmpresaAction implements  Serializable{
	
	
	EmpresaService servicioEmpresa= new EmpresaService();
	TipoEmpresaService servicioTipoEmpresa= new TipoEmpresaService();
	private List<TipoEmpresa> lstTipoEmpresa = new ArrayList();
	private Empresa objEmpresa=null;
	private List<Empresa> lstEmpresa;
	
	

	public Empresa getObjEmpresa() {
		return objEmpresa;
	}

	
	
	public void setObjEmpresa(Empresa objEmpresa) {
		this.objEmpresa = objEmpresa;
	}


	
	
	
	
	
	
	public List<Empresa> getLstEmpresa() {
		return lstEmpresa;
	}


	public void setLstEmpresa(List<Empresa> lstEmpresa) {
		this.lstEmpresa = lstEmpresa;
	}


	public String listaEmpresa(){
		
		lstEmpresa=servicioEmpresa.listar();
		lstTipoEmpresa=servicioTipoEmpresa.listar();
		return "listaEmpresa";
	}
	
	public String registraEmpresa(){
		System.out.println("ENTRA  A REGISTRA EMPRESA");
		
		//lstTipoEmpresa=servicioTipoEmpresa.listar();
		
		servicioEmpresa.registrarEmpresa(objEmpresa);
		System.out.println(""+objEmpresa.getCantEmpleado());
		return "listaEmpresa";
	}
	
	public String actualizaEmpresa(){
		
		System.out.println("ENTRA  A MODIFICAR EMPRESA");
		//lstTipoEmpresa=servicioTipoEmpresa.listar();
		System.out.println(""+objEmpresa.getCEmpresa());
		//objEmpresa.setCantEmpleado(77);
		int i=servicioEmpresa.modificarEmpresa(objEmpresa);
		System.out.println(""+objEmpresa.getCantEmpleado());
		System.out.println(i);
		
		return "listaEmpresa";
	}
	
	public List<SelectItem> getListaTipoEmpresa() {
        List<SelectItem> listaTipoEmpresa = new ArrayList();
        
        for (TipoEmpresa objTipoEmpresa : lstTipoEmpresa) {
        	listaTipoEmpresa.add(new SelectItem(objTipoEmpresa.getCTipoEmpresa(), objTipoEmpresa.getNombre()));
        }
        
        return listaTipoEmpresa;
    }
	

}
