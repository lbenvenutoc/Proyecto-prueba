package bastanteo.cloud.service;

import java.util.List;

import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.dao.UsuarioDao;
import bastanteo.cloud.dao.UsuarioDaoImp;

public class UsuarioService {
	private UsuarioDao dao= new UsuarioDaoImp();
	
	public void Controlarusuario(Usuario objusuario) {
		dao.controlarUsuario(objusuario);
	}

	public int ControlarUsuario(Usuario objusuario) {
		// TODO Auto-generated method stub
		return dao.controlarUsuario(objusuario);
	}
	public int modificarUsuario (Usuario objusuario){
		return dao.modificarUsuario(objusuario);
	}
	public Usuario obtenerUsuario(Usuario objUsuario) {
		return dao.obtenerUsuario(objUsuario);
	}
	public Usuario obtenerUsuarioxDni(Usuario objUsuario) {
		return dao.obtenerUsuarioxDni(objUsuario);
	}
	public Usuario obtenerUsuarioxLogueo(Usuario objUsuario) {
		return dao.obtenerUsuarioxLogueo(objUsuario);
	}
	public List lista() {
		return dao.lista();
	}
	
}
