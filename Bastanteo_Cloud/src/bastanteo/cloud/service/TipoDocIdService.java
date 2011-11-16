package bastanteo.cloud.service;

import bastanteo.cloud.bean.TipoDocId;
import bastanteo.cloud.dao.TipoDocIdDao;
import bastanteo.cloud.dao.TipoDocIdDaoImp;

public class TipoDocIdService {
	
	private TipoDocIdDao dao= new TipoDocIdDaoImp();
	
	public TipoDocId obtenerTipoDocId(TipoDocId objTipoDocId) {
		
		
		return dao.obtenerTipoDocId(objTipoDocId);
		
		
	}

}
