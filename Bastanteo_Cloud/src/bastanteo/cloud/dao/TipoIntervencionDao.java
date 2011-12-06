package bastanteo.cloud.dao;

import java.util.List;

import bastanteo.cloud.bean.TipoIntervencion;

public interface TipoIntervencionDao {
	
	public List listar();
	public TipoIntervencion obtenerTipoIntervencion(TipoIntervencion objTipoInt);

}
