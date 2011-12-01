package bastanteo.cloud.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.TipoEmpresa;
import bastanteo.cloud.service.EmpresaService;
import bastanteo.cloud.service.TipoEmpresaService;

public class EmpresaAction implements Serializable {

	EmpresaService servicioEmpresa = new EmpresaService();
	TipoEmpresaService servicioTipoEmpresa = new TipoEmpresaService();
	private List<TipoEmpresa> lstTipoEmpresa = new ArrayList();
	private Empresa objEmpresa;
	private String codEmpresa;
	private List<Empresa> lstEmpresa;
	private int codTipoEmpresa;

	public int getCodTipoEmpresa() {
		return codTipoEmpresa;
	}

	public void setCodTipoEmpresa(int codTipoEmpresa) {
		this.codTipoEmpresa = codTipoEmpresa;
	}

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

	public String muestraEmpresa() {
		objEmpresa = new Empresa();
		lstTipoEmpresa = servicioTipoEmpresa.listar();

		return "muestraEmpresa";
	}

	public String muestraEdicionEmpresa() {

		Empresa objEmpresaEnviado = new Empresa();

		objEmpresaEnviado.setCEmpresa(codEmpresa);
		objEmpresa = servicioEmpresa.obtenerEmpresa(objEmpresaEnviado);

		return "muestraEdicionEmpresa";
	}

	public String listaEmpresa() {

		lstEmpresa = servicioEmpresa.listar();
		// lstTipoEmpresa=servicioTipoEmpresa.listar();
		return "listaEmpresa";
	}

	public String registraEmpresa() {
		String retorno="";
		System.out.println("ENTRA  A REGISTRA EMPRESA");

		if (servicioEmpresa.obtenerEmpresa(objEmpresa) == null) {
			TipoEmpresa objTipEmpObt = servicioTipoEmpresa
					.obtenerTipoEmpresa(codTipoEmpresa);
			objEmpresa.setTipoEmpresa(objTipEmpObt);
			servicioEmpresa.registrarEmpresa(objEmpresa);

			lstEmpresa = servicioEmpresa.listar();
			retorno="listaEmpresa";
		} else {
			FacesMessage msg = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Error al ingresar empresa, ya que el c�digo ya existe",
					null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			retorno="muestraEmpresa";
		}

		return retorno;
	}

	public String actualizaEmpresa() {

		TipoEmpresa objTipEmpObt = servicioTipoEmpresa
				.obtenerTipoEmpresa(codTipoEmpresa);
		objEmpresa.setTipoEmpresa(objTipEmpObt);
		servicioEmpresa.modificarEmpresa(objEmpresa);
		lstEmpresa = servicioEmpresa.listar();

		return "listaEmpresa";
	}

	public List<SelectItem> getLstTipoEmpresa() {
		List<SelectItem> listaTipoEmpresa = new ArrayList();
		lstTipoEmpresa = servicioTipoEmpresa.listar();
		for (TipoEmpresa objTipoEmpresa : lstTipoEmpresa) {
			listaTipoEmpresa.add(new SelectItem(objTipoEmpresa
					.getCTipoEmpresa(), objTipoEmpresa.getNombre()));
		}

		return listaTipoEmpresa;
	}

	/*
	 * public List<TipoEmpresa> getLstTipoEmpresa() { return lstTipoEmpresa; }
	 */

	public void setLstTipoEmpresa(List<TipoEmpresa> lstTipoEmpresa) {
		this.lstTipoEmpresa = lstTipoEmpresa;
	}

}
