package bastanteo.cloud.service;

import bastanteo.cloud.bean.TipoIntervencion;
import bastanteo.cloud.dao.TipoIntervencionDao;
import bastanteo.cloud.dao.TipoIntervencionDaoImp;


public class TipoIntervencionService {

	private TipoIntervencionDao dao = new TipoIntervencionDaoImp();
	
	
	public int registrarTipoIntervencion(TipoIntervencion objTipoIntervencion) {
		return dao.registrarTipoIntervencion(objTipoIntervencion);
	}
	
	
	public int modificarTipoIntervencion(TipoIntervencion objTipoIntervencion) {
		return dao.modificarTipoIntervencion(objTipoIntervencion);
	}
	
	
	public TipoIntervencion obtenerTipoIntervencion(String codigo) {
		return dao.obtenerTipoIntervencion(codigo);
	}
	
}
