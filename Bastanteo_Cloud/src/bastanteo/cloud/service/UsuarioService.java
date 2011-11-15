package bastanteo.cloud.service;

import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.dao.UsuarioDao;
import bastanteo.cloud.dao.UsuarioDaoImp;

public class UsuarioService {
	private UsuarioDao dao= new UsuarioDaoImp();
	
	public void Controlarusuario(Usuario objusuario) {
		dao.controlarUsuario(objusuario);
	}
	
}
