package bastanteo.cloud.dao;

import java.util.List;

import bastanteo.cloud.bean.Perfil;

public interface PerfilDao {
	
	public Perfil obtenerPerfil(Perfil objPerfil);
	public List listar();

}
