package bastanteo.cloud.service;

import bastanteo.cloud.bean.Perfil;
import bastanteo.cloud.dao.PerfilDao;
import bastanteo.cloud.dao.PerfilDaoImp;

public class PerfilService {
	
	private PerfilDao dao= new PerfilDaoImp();
	
	public Perfil obtenerPerfil(Perfil objPerfil) {
		
		
		return dao.obtenerPerfil(objPerfil);
	}
	
	

}
