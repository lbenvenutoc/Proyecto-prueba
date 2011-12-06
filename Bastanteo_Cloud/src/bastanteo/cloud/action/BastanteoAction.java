package bastanteo.cloud.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.collections.map.HashedMap;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.bean.Representante;
import bastanteo.cloud.bean.RepresentanteId;
import bastanteo.cloud.service.BastanteoService;
import bastanteo.cloud.service.EmpresaService;
import bastanteo.cloud.service.RepresentanteService;

public class BastanteoAction {

	BastanteoService servicioBastanteo = new BastanteoService();
	EmpresaService sevicioEmpresa = new EmpresaService();
	RepresentanteService servicioRepresentante = new RepresentanteService();
	
	private String ruc;
	private int codRepresentante;
	private int codGrupoBastanteo;
	private int codTipIntervencion;

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public int getCodRepresentante() {
		return codRepresentante;
	}

	public void setCodRepresentante(int codRepresentante) {
		this.codRepresentante = codRepresentante;
	}

	public int getCodGrupoBastanteo() {
		return codGrupoBastanteo;
	}

	public void setCodGrupoBastanteo(int codGrupoBastanteo) {
		this.codGrupoBastanteo = codGrupoBastanteo;
	}

	public int getCodTipIntervencion() {
		return codTipIntervencion;
	}

	public void setCodTipIntervencion(int codTipIntervencion) {
		this.codTipIntervencion = codTipIntervencion;
	}

	public String muestraConsultaBastanteo() {

		return "muestraConsultaBastanteo";
	}

	private List lstBastanteo;

	public List getLstBastanteo() {
		return lstBastanteo;
	}

	public void setLstBastanteo(List lstBastanteo) {
		this.lstBastanteo = lstBastanteo;
	}

	public String consultaBastanteo() {
		
		Empresa objEmpresaObt = new Empresa();
		RepresentanteId objRepId = new RepresentanteId();
		
		Empresa objEmpresa = new Empresa();
		objEmpresa.setRuc(ruc);
		objEmpresaObt = sevicioEmpresa.obtenerEmpresaxRuc(objEmpresa);
		
		
		
		objRepId.setCRepresentante(codRepresentante);
		objRepId.setCEmpresa(objEmpresaObt.getCEmpresa());
		
		GrupoBastanteoId objGrupBasId = new GrupoBastanteoId();
	
		if(codGrupoBastanteo==0 && codTipIntervencion==0){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Debe ingresar el codigo de grupo de bastanteo o el tipo de intervencion", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}else{
			
			if(codGrupoBastanteo!=0){
			
				objGrupBasId.setCEmpresa(objEmpresaObt.getCEmpresa());
				objGrupBasId.setCGrupoBastanteo(codGrupoBastanteo);
				
			}
			
		}
		
	

		lstBastanteo = servicioBastanteo.obtenerBastanteosxCriterios(ruc,
				objRepId, objGrupBasId, codTipIntervencion);

		if(lstBastanteo.size()<=0){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"No hay resultados en la consulta", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		System.out.println("NUMERO DE FILAS " + lstBastanteo.size());
		return "muestraConsultaBastanteo";
	}

}
