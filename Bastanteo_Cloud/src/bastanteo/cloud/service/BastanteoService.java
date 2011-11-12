package bastanteo.cloud.service;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.dao.BastanteoDao;
import bastanteo.cloud.dao.BastanteoDaoImp;


public class BastanteoService {

	private BastanteoDao dao = new BastanteoDaoImp();
	
	public int insertarBastanteo(Bastanteo objBastanteo) {
		return dao.insertarBastanteo(objBastanteo);
	}
	
}
