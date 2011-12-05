package bastanteo.cloud.dao;

import java.util.List;

import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.bean.Acceso;
import bastanteo.cloud.bean.AccesoId;

public interface UsuarioDao {
	
	public int controlarUsuario(Usuario objusuario);
	public int modificarUsuario(Usuario objusuario);
	public Acceso obtenerAcceso(AccesoId objAccesoId);
	public Usuario obtenerUsuario(Usuario objUsuario);
	public Usuario obtenerUsuarioxDni(Usuario objUsuario);
    public Usuario obtenerUsuarioxLogueo(Usuario objUsuario);
    public List lista();
    
}
