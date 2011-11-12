package bastanteo.cloud.dao;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.BastanteoId;

public interface BastanteoDao {

	public int insertarBastanteo(Bastanteo objBastanteo);
	public int actualizarBastanteo(Bastanteo objBastanteo);
	public Bastanteo obtenerBastanteo(BastanteoId objBastanteoId);

	
}
