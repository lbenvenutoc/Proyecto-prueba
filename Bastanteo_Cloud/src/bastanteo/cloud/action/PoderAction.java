package bastanteo.cloud.action;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.service.PoderService;

/*Clase elaborada por Luis Benvenuto*/


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
		
		if(servicioPoder.obtenerPoder(objPoder)!=null){
			FacesMessage msg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"No puede registrar poder con el mismo codigo",
					null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}else{
			servicioPoder.registrarPoder(objPoder);
		}
		
		
		lstPoder=servicioPoder.listar();
		
		return "muestraPoder";
	}
	
	private String ruc;
	private String dni;
	private String codigoPoder;
	private double importe;
	private String mensajeValidacion="";
	
	
	
	
	public String getMensajeValidacion() {
		return mensajeValidacion;
	}

	public void setMensajeValidacion(String mensajeValidacion) {
		this.mensajeValidacion = mensajeValidacion;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodigoPoder() {
		return codigoPoder;
	}

	public void setCodigoPoder(String codigoPoder) {
		this.codigoPoder = codigoPoder;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String validaPoder(){
		
		
		
		String resultado = servicioPoder.verificarPoder(ruc, dni, codigoPoder, importe);
		String cadenaArmada="";		

		if (resultado != null) {
			String[] resMensaje = resultado.split("#");
			for (int i = 0; i < resMensaje.length; i++) {
				cadenaArmada+=" "+resMensaje[i];
			}
		
		}
				
		mensajeValidacion=cadenaArmada;
		
		return "muestraValidacionPoder";
	
	}
	
	/*
	public String actualizaPoder(){
		servicioPoder.(objPoder);
		return "actualizaPoder";
	}
	*/

	

}
