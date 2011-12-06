package bastanteo.cloud.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.collections.map.HashedMap;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.GrupoBastanteo;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.bean.Representante;
import bastanteo.cloud.bean.RepresentanteId;
import bastanteo.cloud.bean.TipoDocId;
import bastanteo.cloud.bean.TipoIntervencion;
import bastanteo.cloud.service.BastanteoService;
import bastanteo.cloud.service.EmpresaService;
import bastanteo.cloud.service.GrupoBastanteoService;
import bastanteo.cloud.service.PoderService;
import bastanteo.cloud.service.RepresentanteService;
import bastanteo.cloud.service.TipoIntervencionService;

public class BastanteoAction {

	BastanteoService servicioBastanteo = new BastanteoService();
	EmpresaService sevicioEmpresa = new EmpresaService();
	RepresentanteService servicioRepresentante = new RepresentanteService();
	GrupoBastanteoService servicioGrupoBastanteo = new GrupoBastanteoService();
	EmpresaService servicioEmpresa = new EmpresaService();
	PoderService servicioPoder = new PoderService();
	TipoIntervencionService servicioTipoIntervencion = new TipoIntervencionService();

	private String ruc;
	private int codRepresentante;
	private int codGrupoBastanteo;
	private int codTipIntervencion;
	private boolean muestraCombo=false;
	
	

	public boolean isMuestraCombo() {
		return muestraCombo;
	}

	public void setMuestraCombo(boolean muestraCombo) {
		this.muestraCombo = muestraCombo;
	}

	private Bastanteo objBastanteo;
	private String codEmpresa;
	private String codPoder;

	private List<Empresa> lstEmpresa = new ArrayList();
	private List<Poder> lstPoder = new ArrayList();
	private List<GrupoBastanteo> lstGrupoBastanteo = new ArrayList();
	private List<TipoIntervencion> lstTipoIntervencion = new ArrayList();

	public String getCodPoder() {
		return codPoder;
	}

	public void setCodPoder(String codPoder) {
		this.codPoder = codPoder;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Bastanteo getObjBastanteo() {
		return objBastanteo;
	}

	public void setObjBastanteo(Bastanteo objBastanteo) {
		this.objBastanteo = objBastanteo;
	}

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

		if (codGrupoBastanteo == 0 && codTipIntervencion == 0) {
			FacesMessage msg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Debe ingresar el codigo de grupo de bastanteo o el tipo de intervencion",
					null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {

			if (codGrupoBastanteo != 0) {

				objGrupBasId.setCEmpresa(objEmpresaObt.getCEmpresa());
				objGrupBasId.setCGrupoBastanteo(codGrupoBastanteo);

			}

		}

		lstBastanteo = servicioBastanteo.obtenerBastanteosxCriterios(ruc,
				objRepId, objGrupBasId, codTipIntervencion);

		if (lstBastanteo.size() <= 0) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"No hay resultados en la consulta", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		System.out.println("NUMERO DE FILAS " + lstBastanteo.size());
		return "muestraConsultaBastanteo";
	}

	public String muestraBastanteo() {

		return "muestraBastanteo";
	}

	public String registraBastanteo() {

		return "muestraBastanteo";
	}

	List<SelectItem> listaGrupoBastanteo = new ArrayList();

	public List<SelectItem> getlstGrupoBastanteo() {

		return listaGrupoBastanteo;
	}

	public void cargaGrupoBastanteo(ValueChangeEvent evento) {

		listaGrupoBastanteo = new ArrayList<SelectItem>();
		
		codEmpresa = (String) evento.getNewValue();

		Empresa objEmpresa = new Empresa();
		objEmpresa.setCEmpresa(codEmpresa);

		lstGrupoBastanteo = servicioGrupoBastanteo
				.lstGrupoBastanteoxEmpresa(objEmpresa);
		
		if (lstGrupoBastanteo.size() > 0) {

			for (GrupoBastanteo objGrupoBastanteo : lstGrupoBastanteo) {

				listaGrupoBastanteo.add(new SelectItem(objGrupoBastanteo
						.getId().getCGrupoBastanteo(), objGrupoBastanteo
						.getDescripcion()));

				System.out.println("CARGA CODIGOS COMBO GRUPO "
						+ objGrupoBastanteo.getId().getCGrupoBastanteo());

			}
				
			muestraCombo=true;
			
		}//else {

			
		//}

	}

	public List<SelectItem> getLstEmpresa() {
		List<SelectItem> listaEmpresa = new ArrayList();
		lstEmpresa = servicioEmpresa.listar();
		for (Empresa objEmpresa : lstEmpresa) {
			listaEmpresa.add(new SelectItem(objEmpresa.getCEmpresa(),
					objEmpresa.getRazonSocial()));
		}

		return listaEmpresa;
	}

	public List<SelectItem> getLstPoder() {
		List<SelectItem> listaPoder = new ArrayList();
		lstPoder = servicioPoder.listar();
		for (Poder objPoder : lstPoder) {
			listaPoder.add(new SelectItem(objPoder.getCPoder(), objPoder
					.getNombre()));
		}

		return listaPoder;
	}

	public List<SelectItem> getLstTipoIntervencion() {
		List<SelectItem> listaTipoIntervencion = new ArrayList();
		lstTipoIntervencion = servicioTipoIntervencion.listar();
		for (TipoIntervencion objTipoIntervencion : lstTipoIntervencion) {
			listaTipoIntervencion.add(new SelectItem(objTipoIntervencion
					.getCTipoIntervencion(), objTipoIntervencion.getNombre()));
		}

		return listaTipoIntervencion;
	}

}
