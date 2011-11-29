// Author: Kid Rivera Valera

package bastanteo.cloud.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import bastanteo.cloud.bean.Empresa;

public interface EmpresaDao {
	
	public Empresa obtenerEmpresa(Empresa objEmpresa);
	public Empresa obtenerEmpresaxRuc(Empresa objEmpresa);
	public int registrarEmpresa(Empresa objEmpresa);
	public int modificarEmpresa(Empresa objEmpresa);
	public List listar();
    

}
