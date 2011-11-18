package bastanteo.cloud.service;

import bastanteo.cloud.bean.DBastanteoGrupo;
import bastanteo.cloud.dao.DBastanteoGrupoDao;
import bastanteo.cloud.dao.DBastanteoGrupoDaoImp;


public class DBastanteoGrupoService {

	private DBastanteoGrupoDao dao = new DBastanteoGrupoDaoImp();
	
	public int insertarBastanteo(DBastanteoGrupo objDBastanteoGrupo) {
		return dao.insertarDBastanteoGrupo(objDBastanteoGrupo);
	}
}
