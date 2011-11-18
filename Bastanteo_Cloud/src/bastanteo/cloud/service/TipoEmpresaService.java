package bastanteo.cloud.service;

import bastanteo.cloud.bean.TipoEmpresa;
import bastanteo.cloud.dao.TipoEmpresaDao;
import bastanteo.cloud.dao.TipoEmpresaDaoImp;

public class TipoEmpresaService {
	
	private TipoEmpresaDao dao= new TipoEmpresaDaoImp();
	
	public TipoEmpresa obtenerTipoEmpresa(TipoEmpresa objTipoEmpresa){
		return dao.obtenerTipoEmpresa(objTipoEmpresa);
	}
	
	

}
