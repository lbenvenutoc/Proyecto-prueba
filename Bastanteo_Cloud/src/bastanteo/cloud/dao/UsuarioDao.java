package bastanteo.cloud.dao;

import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.bean.Acceso;
import bastanteo.cloud.bean.AccesoId;

public interface UsuarioDao {
	
	public int controlarUsuario(Usuario objUsuario);
	public int modificarUsuario(Usuario objUsuario);
	public Acceso obtenerAcceso(AccesoId objAccesoId);
}
