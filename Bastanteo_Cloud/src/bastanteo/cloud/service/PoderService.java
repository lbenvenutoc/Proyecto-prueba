package bastanteo.cloud.service;

import java.util.List;

import bastanteo.cloud.bean.Poder;

import bastanteo.cloud.dao.PoderDao;
import bastanteo.cloud.dao.PoderDaoImp;

public class PoderService {
	
	private PoderDao dao= new PoderDaoImp();
	
	public void registrarPoder(Poder objPoder) {
		dao.registrarPoder(objPoder);
	}
	public Poder obtenerPoder(String codigo) {
		return dao.obtenerPoder(codigo);
	}
	public List verificarPoder(String ruc, String dni, String codigoPoder,
			double importe) {
		return dao.verificarPoder(ruc, dni, codigoPoder, importe);
	}
}
