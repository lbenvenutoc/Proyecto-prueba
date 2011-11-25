package bastanteo.cloud.service;



import java.util.List;

import bastanteo.cloud.bean.Poder;

import bastanteo.cloud.dao.PoderDao;
import bastanteo.cloud.dao.PoderDaoImp;

public class PoderService {
	
	private PoderDao dao= new PoderDaoImp();
	
	public int registrarPoder(Poder objPoder) {
		
		return dao.registrarPoder(objPoder);
	}
	public Poder obtenerPoder(Poder objPoder) {
		return dao.obtenerPoder(objPoder);
	}
	public String verificarPoder(String ruc, String dni, String codigoPoder,
			double importe) {
		return dao.verificarPoder(ruc, dni, codigoPoder, importe);
	}
	public List listar() {
		return dao.listar();
	}
}
