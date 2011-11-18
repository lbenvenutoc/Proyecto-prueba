package bastanteo.cloud.dao;

import java.util.Collection;
import java.util.List;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.BastanteoId;
import bastanteo.cloud.bean.DBastanteoGrupo;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.bean.RepresentanteId;

public interface BastanteoDao {

	public int insertarBastanteo(Bastanteo objBastanteo);
	public Bastanteo obtenerBastanteo(BastanteoId objBastanteoId);
	public List obtenerBastanteosxCriterios(String ruc,RepresentanteId idRepresentante,GrupoBastanteoId idGrupoBastanteo,int idTipoIntervencion);

	
}
