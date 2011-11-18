package bastanteo.cloud.dao;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.BastanteoId;
import bastanteo.cloud.bean.DBastanteoGrupo;

public interface BastanteoDao {

	public int insertarBastanteo(Bastanteo objBastanteo);
	public Bastanteo obtenerBastanteo(BastanteoId objBastanteoId);
	

	
}
