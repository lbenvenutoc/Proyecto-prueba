package bastanteo.cloud.dao;

import java.util.List;

import bastanteo.cloud.bean.TipoDocId;

public interface TipoDocIdDao {
	
	public TipoDocId obtenerTipoDocId(TipoDocId objTipoDocId);
	public List listar();

}
