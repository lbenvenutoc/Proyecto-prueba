package bastanteo.cloud.dao;

import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.bean.Acceso;
import bastanteo.cloud.bean.AccesoId;

public interface UsuarioDao {
	//CREANDO INTERFACES
	public int controlarUsuario(Usuario objusuario);
	public int modificarUsuario(Usuario objusuario);
	public Acceso obtenerAcceso(AccesoId objAccesoId);
}
