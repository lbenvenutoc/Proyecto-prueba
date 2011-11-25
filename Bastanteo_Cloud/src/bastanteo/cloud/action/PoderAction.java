package bastanteo.cloud.action;

import java.io.Serializable;
import java.util.List;

import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.service.PoderService;



public class PoderAction implements  Serializable{
	
	
	private Poder objPoder;
	private List<Poder> lstPoder;
	PoderService servicioPoder= new PoderService();
	
	
	
	
	
	public Poder getObjPoder() {
		return objPoder;
	}

	public void setObjPoder(Poder objPoder) {
		this.objPoder = objPoder;
	}

	public List<Poder> getLstPoder() {
		return lstPoder;
	}

	public void setLstPoder(List<Poder> lstPoder) {
		this.lstPoder = lstPoder;
	}

	public String muestraListado(){
		System.out.println("ENTRO A LISTAR");
		lstPoder=servicioPoder.listar();
		return "listaPoder";
	}
	
	public String muestraPoder(){
		
		return "muestraPoder";
	}
	
	
	
	public String registraPoder(){
		System.out.println("DESCRIPCION DE PRODUCTO ENVIADO ");
		servicioPoder.registrarPoder(objPoder);
		
		//lstProducto=servicioProducto.listar();
		//return "ingresaLista";
		//return muestraListado();
		return "muestraPoder";
	}
	
	/*
	public String actualizaPoder(){
		servicioPoder.(objPoder);
		return "actualizaPoder";
	}
	*/

	

}
