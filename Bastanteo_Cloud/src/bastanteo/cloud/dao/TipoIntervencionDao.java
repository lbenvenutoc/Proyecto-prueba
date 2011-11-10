package bastanteo.cloud.dao;

import bastanteo.cloud.bean.TipoIntervencion;

public interface TipoIntervencionDao {

	public int registrarTipoIntervencion(TipoIntervencion objtipoIntervencion);
	public int modificarTipoIntervencion(TipoIntervencion objtipoIntervencion);
	public TipoIntervencion obtenerTipoIntervencion(String codigo);
}
