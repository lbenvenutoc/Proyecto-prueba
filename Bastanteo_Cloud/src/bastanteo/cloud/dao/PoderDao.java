package bastanteo.cloud.dao;



import bastanteo.cloud.bean.Poder;


public interface PoderDao {
	
	public int registrarPoder(Poder objPoder);
	public Poder obtenerPoder(String codigo);
	public String verificarPoder(String ruc, String dni,String codigoPoder,double importe);
	

}
