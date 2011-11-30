package bastanteo.cloud.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import bastanteo.cloud.bean.TipoEmpresa;

public interface TipoEmpresaDao {
	
	public TipoEmpresa obtenerTipoEmpresa(TipoEmpresa objTipoEmpresa);
	public List listar();
}
