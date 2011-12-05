package bastanteo.cloud.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import bastanteo.cloud.bean.Acceso;
import bastanteo.cloud.bean.Perfil;
import bastanteo.cloud.bean.TipoEmpresa;
import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.service.PerfilService;
import bastanteo.cloud.service.UsuarioService;

public class UsuarioAction {

	UsuarioService servicioUsuario = new UsuarioService();
	PerfilService servicioPerfil= new PerfilService();

	private Usuario objUsuario;
	private List lstUsuario;
	private List<Perfil> lstPerfil = new ArrayList();
	public void setLstPerfil(List<Perfil> lstPerfil) {
		this.lstPerfil = lstPerfil;
	}

	private int codPerfil;
	
	

	public int getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(int codPerfil) {
		this.codPerfil = codPerfil;
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	public List getLstUsuario() {
		return lstUsuario;
	}

	public void setLstUsuario(List lstUsuario) {
		this.lstUsuario = lstUsuario;
	}

	public String muestraLogueo() {
		String retorno = "";

		objUsuario = servicioUsuario.obtenerUsuarioxLogueo(objUsuario);

		if (objUsuario != null) {
			retorno = "muestraPrincipal";
		} else {
			retorno = "muestraLogueo";
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Usuario o clave incorrectos", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return retorno;
	}
	
	public String muestraUsuario(){
		objUsuario= new Usuario(); 
		return "muestraUsuario";
	}

	public String listaUsuario() {
		lstUsuario=servicioUsuario.lista();
		return "listaUsuario";
	}

	public String registraUsuario() {
		return "";
	}

	public String modificaUsuario() {

		return "";
	}
	
	public List<SelectItem> getLstPerfil(){
		
		List<SelectItem> listaPerfil = new ArrayList();
		lstPerfil = servicioPerfil.listar();
		for (Perfil objPerfil : lstPerfil) {
			listaPerfil.add(new SelectItem(objPerfil.getCPerfil(),objPerfil.getNombre()));
		}

		return listaPerfil;
		
	}
}
