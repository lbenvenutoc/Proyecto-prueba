package bastanteo.cloud.service;

import java.util.Collection;
import java.util.List;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.bean.RepresentanteId;
import bastanteo.cloud.dao.BastanteoDao;
import bastanteo.cloud.dao.BastanteoDaoImp;


public class BastanteoService {

	private BastanteoDao dao = new BastanteoDaoImp();
	
	public int insertarBastanteo(Bastanteo objBastanteo) {
		return dao.insertarBastanteo(objBastanteo);
	}
	public List obtenerBastanteosxCriterios(String ruc,
			RepresentanteId idRepresentante, GrupoBastanteoId idGrupoBastanteo,
			int idTipoIntervencion) {
		return dao.obtenerBastanteosxCriterios(ruc, idRepresentante, idGrupoBastanteo, idTipoIntervencion);
	}
	
	public int verificarBastanteo(Bastanteo objBastanteo) {
		return dao.verificarBastanteo(objBastanteo);
	}
	
	
}
