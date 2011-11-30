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
	//private List<TipoEmpresa> lstTipoEmpresa = new ArrayList();
	private Empresa objEmpresa;
	private String codEmpresa;
	private List<Empresa> lstEmpresa;
	
	

	



	public String getCodEmpresa() {
		return codEmpresa;
	}



	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}



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
	

	public String muestraEmpresa(){
		
	
		return "muestraEmpresa";
	}
	
	public String muestraEdicionEmpresa(){
		Empresa objEmpresaEnviado= new Empresa();
		System.out.println("CODIGO ENVIADO EMPRESA "+codEmpresa);
		objEmpresaEnviado.setCEmpresa(codEmpresa);
		objEmpresa=servicioEmpresa.obtenerEmpresa(objEmpresaEnviado);
		
		return "muestraEdicionEmpresa";
	}


	public String listaEmpresa(){
		
		lstEmpresa=servicioEmpresa.listar();
		//lstTipoEmpresa=servicioTipoEmpresa.listar();
		return "listaEmpresa";
	}
	
	public String registraEmpresa(){
		System.out.println("ENTRA  A REGISTRA EMPRESA");
		
		//lstTipoEmpresa=servicioTipoEmpresa.listar();
		objEmpresa.setCEmpresa("2");
		TipoEmpresa objEmObt= new TipoEmpresa();
		objEmObt.setCTipoEmpresa(2);
		TipoEmpresa tipoEmpresa=servicioTipoEmpresa.obtenerTipoEmpresa(objEmObt);
		objEmpresa.setTipoEmpresa(tipoEmpresa);
		servicioEmpresa.registrarEmpresa(objEmpresa);
		System.out.println(""+objEmpresa.getCantEmpleado());
		lstEmpresa=servicioEmpresa.listar();
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
	/*
	public List<SelectItem> getListaTipoEmpresa() {
        List<SelectItem> listaTipoEmpresa = new ArrayList();
        
        for (TipoEmpresa objTipoEmpresa : lstTipoEmpresa) {
        	listaTipoEmpresa.add(new SelectItem(objTipoEmpresa.getCTipoEmpresa(), objTipoEmpresa.getNombre()));
        }
        
        return listaTipoEmpresa;
    }
	*/

}
