package bastanteo.cloud.test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.Test;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.BastanteoId;
import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.bean.TipoIntervencion;
import bastanteo.cloud.service.BastanteoService;

public class BastanteoTest {

	

	@Test
	public void insertarBastanteo() {
		
		int retorno;
		BastanteoService bastanteoService = new BastanteoService();
		Bastanteo bastanteo = new Bastanteo();
		BastanteoId bastanteoId = new BastanteoId();
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		// codigo del bastanteo
		bastanteoId.setCEmpresa("100");
		bastanteoId.setCGrupoBastanteo(1);
		bastanteoId.setCPoder("CHCO");
		
		bastanteo.setId(bastanteoId);
		bastanteo.setTipoIntervencion(new TipoIntervencion(100, ""));
		bastanteo.setImporteMin(100);
		bastanteo.setImporteMax(1000);
		//bastanteo.setFechaIni(sdf.parse("2011-02-01"));
		//bastanteo.setFechaFin(sdf.parse("2011-02-01"));
		
		
		retorno = bastanteoService.insertarBastanteo(bastanteo);
		
	}
}
