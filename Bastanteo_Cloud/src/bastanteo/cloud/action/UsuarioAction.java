package bastanteo.cloud.action;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import bastanteo.cloud.bean.Acceso;
import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.service.UsuarioService;

public class UsuarioAction {
	
	UsuarioService servicioUsuario= new UsuarioService();
	
	private Usuario objUsuario;
	private List lstUsuario;
	
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
	
	public String muestraLogueo(){
		String retorno="";
		
		objUsuario=servicioUsuario.obtenerUsuarioxLogueo(objUsuario);
		List<Acceso> lista=objUsuario.getPerfil().getAccesosList();
		System.out.println("TIENE "+lista.size());
		Acceso objAc=lista.get(0);
		System.out.println("NOMBRE DE ACCESO "+objAc.getNombre());
		if(objUsuario!=null){
			retorno="muestraPrincipal";
		}else{
			retorno="muestraLogueo";
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Usuario o clave incorrectos", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return retorno;
	}

}
