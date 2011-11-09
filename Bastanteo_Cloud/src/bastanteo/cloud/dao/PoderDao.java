package bastanteo.cloud.dao;

import bastanteo.cloud.bean.Poder;

public interface PoderDao {
	
	public void registrarPoder(Poder objPoder);
	public Poder obtenerPoder(String codigo);
	

}
