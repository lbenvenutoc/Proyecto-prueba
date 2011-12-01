package bastanteo.cloud.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import bastanteo.cloud.bean.TipoEmpresa;

public interface TipoEmpresaDao {
	
	public TipoEmpresa obtenerTipoEmpresa(TipoEmpresa objTipoEmpresa);
	public TipoEmpresa obtenerTipoEmpresa(int codigo);
	public List listar();
}
