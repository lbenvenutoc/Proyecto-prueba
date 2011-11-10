package bastanteo.cloud.dao;

import java.util.List;

import bastanteo.cloud.bean.Poder;


public interface PoderDao {
	
	public void registrarPoder(Poder objPoder);
	public Poder obtenerPoder(String codigo);
	public String verificarPoder(String ruc, String dni,String codigoPoder,double importe);
	

}
