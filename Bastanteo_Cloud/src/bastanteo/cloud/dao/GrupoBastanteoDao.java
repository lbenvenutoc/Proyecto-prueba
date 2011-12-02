package bastanteo.cloud.dao;

import java.util.List;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.GrupoBastanteo;

public interface GrupoBastanteoDao {
	
	public GrupoBastanteo obtenerGrupoBastanteo(GrupoBastanteo objGrupoBastanteo);
	public List lstGrupoBastanteoxEmpresa(Empresa objEmpresa);
	
}
