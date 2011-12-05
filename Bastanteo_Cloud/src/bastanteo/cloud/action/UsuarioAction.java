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
	PerfilService servicioPerfil = new PerfilService();

	private Usuario objUsuario;
	private List lstUsuario;
	private List<Perfil> lstPerfil = new ArrayList();

	public void setLstPerfil(List<Perfil> lstPerfil) {
		this.lstPerfil = lstPerfil;
	}

	private int codPerfil;

	// DATOS A INGRESAR DE USUARIO
	private int codUsuario;
	private String apePat;
	private String apeMat;
	private String nombre;
	private String usuario;
	private String clave;
	private String dni;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

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
			objUsuario = new Usuario();
		}

		return retorno;
	}

	public String muestraUsuario() {

		return "muestraUsuario";
	}

	public String muestraEdicion() {

		Usuario objUsuarioEditar = new Usuario();
		Usuario objUsuarioParam = new Usuario();
		objUsuarioParam.setCUsuario(codUsuario);
		objUsuarioEditar = servicioUsuario.obtenerUsuario(objUsuarioParam);

		clave = objUsuarioEditar.getClave();

		usuario = objUsuarioEditar.getLogin();
		apePat = objUsuarioEditar.getPaterno();
		apeMat = objUsuarioEditar.getMaterno();
		nombre = objUsuarioEditar.getNombre();
		dni = objUsuarioEditar.getDni();
		codPerfil = objUsuarioEditar.getPerfil().getCPerfil();

		return "muestraEdicion";
	}

	public String listaUsuario() {
		lstUsuario = servicioUsuario.lista();
		return "listaUsuario";
	}

	public String registraUsuario() {
		Usuario objUsuarioNuevo = new Usuario();

		// SE SETEAN LOS DATOS A ACTUALIZAR
		objUsuarioNuevo.setClave(clave);
		objUsuarioNuevo.setClaveconfirm(clave);
		objUsuarioNuevo.setCUsuario(codUsuario);
		objUsuarioNuevo.setDni(dni);
		if (codPerfil == 4) {
			objUsuarioNuevo.setFlagActivo('M');
		} else {
			objUsuarioNuevo.setFlagActivo('A');
		}
		usuario = apePat + nombre.charAt(0);
		objUsuarioNuevo.setLogin(usuario);
		objUsuarioNuevo.setPaterno(apePat);
		objUsuarioNuevo.setMaterno(apeMat);
		objUsuarioNuevo.setNombre(nombre);

		// SE SETEA PERFIL
		Perfil objPerfil = new Perfil();
		objPerfil.setCPerfil(codPerfil);

		Perfil objPerfilObt = new Perfil();
		objPerfilObt = servicioPerfil.obtenerPerfil(objPerfil);
		objUsuarioNuevo.setPerfil(objPerfilObt);

		servicioUsuario.ControlarUsuario(objUsuarioNuevo);
		lstUsuario = servicioUsuario.lista();
		return "listaUsuario";
	}

	public String modificaUsuario() {

		Usuario objUsuarioNuevo = new Usuario();

		// SE SETEAN LOS DATOS A ACTUALIZAR
		objUsuarioNuevo.setClave(clave);
		objUsuarioNuevo.setClaveconfirm(clave);
		objUsuarioNuevo.setCUsuario(codUsuario);
		objUsuarioNuevo.setDni(dni);
		if (codPerfil == 4) {
			objUsuarioNuevo.setFlagActivo('M');
		} else {
			objUsuarioNuevo.setFlagActivo('A');
		}
		usuario = apePat + nombre.charAt(0);
		objUsuarioNuevo.setLogin(usuario);
		objUsuarioNuevo.setPaterno(apePat);
		objUsuarioNuevo.setMaterno(apeMat);
		objUsuarioNuevo.setNombre(nombre);

		// SE SETEA PERFIL
		Perfil objPerfil = new Perfil();
		objPerfil.setCPerfil(codPerfil);

		Perfil objPerfilObt = new Perfil();
		objPerfilObt = servicioPerfil.obtenerPerfil(objPerfil);
		objUsuarioNuevo.setPerfil(objPerfilObt);

		servicioUsuario.modificarUsuario(objUsuarioNuevo);
		lstUsuario = servicioUsuario.lista();

		return "listaUsuario";
	}

	public List<SelectItem> getLstPerfil() {

		List<SelectItem> listaPerfil = new ArrayList();
		lstPerfil = servicioPerfil.listar();
		for (Perfil objPerfil : lstPerfil) {
			listaPerfil.add(new SelectItem(objPerfil.getCPerfil(), objPerfil
					.getNombre()));
		}

		return listaPerfil;

	}
}
