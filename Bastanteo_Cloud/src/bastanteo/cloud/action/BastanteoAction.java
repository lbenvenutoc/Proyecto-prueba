package bastanteo.cloud.action;

import java.util.List;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.bean.RepresentanteId;
import bastanteo.cloud.service.BastanteoService;
import bastanteo.cloud.service.EmpresaService;

public class BastanteoAction {

	BastanteoService servicioBastanteo = new BastanteoService();
	EmpresaService sevicioEmpresa = new EmpresaService();

	private String ruc;
	private int codRepresentante;
	private int codGrupoBastanteo;
	private int codTipIntervencion;

	private List lstBastanteo;

	public List getLstBastanteo() {
		return lstBastanteo;
	}

	public void setLstBastanteo(List lstBastanteo) {
		this.lstBastanteo = lstBastanteo;
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

	public String consultaBastanteo() {

		Empresa objEmpresa = new Empresa();
		objEmpresa.setRuc(ruc);
		Empresa objEmpresaObt = new Empresa();
		objEmpresaObt = sevicioEmpresa.obtenerEmpresaxRuc(objEmpresa);

		RepresentanteId objRepId = new RepresentanteId();
		objRepId.setCRepresentante(codRepresentante);
		objRepId.setCEmpresa(objEmpresaObt.getCEmpresa());

		GrupoBastanteoId objGrupBasId = new GrupoBastanteoId();
		objGrupBasId.setCEmpresa(objEmpresaObt.getCEmpresa());
		objGrupBasId.setCGrupoBastanteo(codGrupoBastanteo);

		lstBastanteo = servicioBastanteo.obtenerBastanteosxCriterios(ruc,
				objRepId, objGrupBasId, codTipIntervencion);

		return "muestraConsultaBastanteo";
	}

}
