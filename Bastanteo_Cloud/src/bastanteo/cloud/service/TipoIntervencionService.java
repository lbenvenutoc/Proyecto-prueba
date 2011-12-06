package bastanteo.cloud.service;

import java.util.List;

import bastanteo.cloud.dao.TipoIntervencionDao;
import bastanteo.cloud.dao.TipoIntervencionDaoImp;

public class TipoIntervencionService {
	
	private TipoIntervencionDao dao = new TipoIntervencionDaoImp();
	
	
	public List listar() {
		return dao.listar();
	}

}
