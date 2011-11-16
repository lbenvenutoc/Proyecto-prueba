package bastanteo.cloud.service;

import bastanteo.cloud.bean.GrupoBastanteo;
import bastanteo.cloud.dao.GrupoBastanteoDao;
import bastanteo.cloud.dao.GrupoBastanteoDaoImp;

public class GrupoBastanteoService {
	
	private GrupoBastanteoDao dao= new GrupoBastanteoDaoImp();
	
	public GrupoBastanteo obtenerGrupoBastanteo(GrupoBastanteo objGrupoBastanteo) {
		
		return dao.obtenerGrupoBastanteo(objGrupoBastanteo);
		
	}
	

}
