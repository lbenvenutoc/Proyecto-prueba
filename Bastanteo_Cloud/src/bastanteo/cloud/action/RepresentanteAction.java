package bastanteo.cloud.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.GrupoBastanteo;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.bean.Representante;
import bastanteo.cloud.bean.RepresentanteId;
import bastanteo.cloud.bean.TipoDocId;
import bastanteo.cloud.bean.TipoEmpresa;

import bastanteo.cloud.service.BastanteoService;
import bastanteo.cloud.service.EmpresaService;
import bastanteo.cloud.service.GrupoBastanteoService;
import bastanteo.cloud.service.RepresentanteService;
import bastanteo.cloud.service.TipoDocIdService;

public class RepresentanteAction implements Serializable {

	RepresentanteService servicioRepresentante = new RepresentanteService();
	EmpresaService servicioEmpresa = new EmpresaService();
	TipoDocIdService servicioTipoDocId = new TipoDocIdService();
	GrupoBastanteoService servicioGrupoBastanteo = new GrupoBastanteoService();

	private Representante objRepresentante;

	private List<Representante> lstRepresentante;

	private int codRepresentante;
	private int codTipDocIdentidad;
	private String codEmpresa;
	private int codGrupoBastanteo;
	private boolean muestraCombo=false;
	
	

	public boolean isMuestraCombo() {
		return muestraCombo;
	}

	public void setMuestraCombo(boolean muestraCombo) {
		this.muestraCombo = muestraCombo;
	}

	public int getCodGrupoBastanteo() {
		return codGrupoBastanteo;
	}

	public void setCodGrupoBastanteo(int codGrupoBastanteo) {
		this.codGrupoBastanteo = codGrupoBastanteo;
	}

	private List<TipoDocId> lstTipDocId = new ArrayList();

	private List<Empresa> lstEmpresa = new ArrayList();

	private List<GrupoBastanteo> lstGrupoBastanteo = new ArrayList();

	public int getCodTipDocIdentidad() {
		return codTipDocIdentidad;
	}

	public void setCodTipDocIdentidad(int codTipDocIdentidad) {
		this.codTipDocIdentidad = codTipDocIdentidad;
	}

	public int getCodRepresentante() {
		return codRepresentante;
	}

	public void setCodRepresentante(int codRepresentante) {
		this.codRepresentante = codRepresentante;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Representante getObjRepresentante() {
		return objRepresentante;
	}

	public void setObjRepresentante(Representante objRepresentante) {
		this.objRepresentante = objRepresentante;
	}

	public List<Representante> getLstRepresentante() {
		return lstRepresentante;
	}

	public void setLstRepresentante(List<Representante> lstRepresentante) {
		this.lstRepresentante = lstRepresentante;
	}

	public String muestraRepresentante() {
		objRepresentante = new Representante();

		return "muestraRepresentante";
	}

	public String muestraEdicionRepresentante() {
		RepresentanteId objRepId = new RepresentanteId(codEmpresa,
				codRepresentante);
		Representante objRepObt = new Representante();
		objRepObt.setId(objRepId);
		objRepresentante = servicioRepresentante
				.obtenerRepresentantes(objRepObt);

		return "muestraEdicionRepresentante";
	}

	public String listaRepresentante() {

		lstRepresentante = servicioRepresentante.listar();

		return "listaRepresentante";
	}

	public void cargaGrupoBastanteo(ValueChangeEvent evento) {

		listaTipDocIdentidad = new ArrayList<SelectItem>();
		listaGrupoBastanteo = new ArrayList<SelectItem>();

		lstTipDocId = servicioTipoDocId.listar();
		for (TipoDocId objTipDocId : lstTipDocId) {
			listaTipDocIdentidad.add(new SelectItem(
					objTipDocId.getCTipoDocId(), objTipDocId.getNombre()));

		}

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
		} /*else {

			codEmpresa = null;
		}
		*/
	}

	public String registraRepresentante() {

		String retorno = "";

		// SETEO LA EMPRESA AL REPRESENTANTE
		Empresa objEmpresa = new Empresa();
		objEmpresa.setCEmpresa(codEmpresa);
		Empresa objEmpresaObt = servicioEmpresa.obtenerEmpresa(objEmpresa);
		objRepresentante.setEmpresa(objEmpresaObt);

		// SETEO L LLAVE PRIMARIA DEL REPRESENTANTE
		RepresentanteId objRepresentanteId = new RepresentanteId(
				objEmpresaObt.getCEmpresa(), codRepresentante);
		objRepresentante.setId(objRepresentanteId);

		// SETEO TIPO DE DOCUMENTO DE IDENTIDAD AL REPRESENTANTE
		TipoDocId objTipDocId = new TipoDocId();

		objTipDocId.setCTipoDocId(codTipDocIdentidad);
		TipoDocId objTipDocIdObt = servicioTipoDocId
				.obtenerTipoDocId(objTipDocId);
		objRepresentante.setTipoDocId(objTipDocIdObt);

		// SETEO GRUPO BASTANTEO EN BRUTO

		GrupoBastanteo objGrupoBastanteo = new GrupoBastanteo();

		GrupoBastanteoId idGrupoBastanteo = new GrupoBastanteoId(
				objEmpresaObt.getCEmpresa(), codGrupoBastanteo);

		objGrupoBastanteo.setId(idGrupoBastanteo);
		GrupoBastanteo objGrupoBastanteoObt = servicioGrupoBastanteo
				.obtenerGrupoBastanteo(objGrupoBastanteo);

		objRepresentante.setGrupoBastanteo(objGrupoBastanteoObt);

		if (servicioRepresentante
				.perteneceEmpresaRepresentante(objRepresentante) == true) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Este representante pertenece a dicha empresa", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			retorno = "muestraEmpresa";

		} else {
			servicioRepresentante.inscribirRepresentante(objRepresentante);
			lstRepresentante = servicioRepresentante.listar();
			retorno = "listaRepresentante";
		}

		return retorno;
	}

	public String actualizaRepresentante() {
		servicioRepresentante.modificarRepresentantes(objRepresentante);

		return "listaRepresentante";

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

	List<SelectItem> listaTipDocIdentidad = new ArrayList();

	public List<SelectItem> getLstTipDocIdentidad() {

		listaTipDocIdentidad = new ArrayList<SelectItem>();

		lstTipDocId = servicioTipoDocId.listar();
		for (TipoDocId objTipDocId : lstTipDocId) {
			listaTipDocIdentidad.add(new SelectItem(
					objTipDocId.getCTipoDocId(), objTipDocId.getNombre()));
		}

		return listaTipDocIdentidad;
	}

	List<SelectItem> listaGrupoBastanteo = new ArrayList();

	public List<SelectItem> getlstGrupoBastanteo() {

		return listaGrupoBastanteo;
	}

}
