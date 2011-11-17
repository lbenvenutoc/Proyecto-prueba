package bastanteo.cloud.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.Assert;

import org.junit.Test;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.BastanteoId;
import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.bean.TipoIntervencion;
import bastanteo.cloud.service.BastanteoService;

public class BastanteoTest {

	
	@Test 
	public void insertarBastanteo() throws ParseException {
		
		int retorno;
		Date fechaIni;
		Date fechaFin;
		
		BastanteoService bastanteoService = new BastanteoService();
		Bastanteo bastanteo = new Bastanteo();
		BastanteoId bastanteoId = new BastanteoId();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		// codigo del bastanteo
		bastanteoId.setCEmpresa("100");
		bastanteoId.setCGrupoBastanteo(1);
		bastanteoId.setCPoder("CHCO");
		
		
		fechaIni = sdf.parse("2011-02-01");
		fechaFin = sdf.parse("2011-02-01");
		
		bastanteo.setId(bastanteoId);
		bastanteo.setTipoIntervencion(new TipoIntervencion(100, ""));
		bastanteo.setImporteMin(100);
		bastanteo.setImporteMax(1000);
		bastanteo.setFechaIni(fechaIni);
		bastanteo.setFechaFin(fechaFin);
		
		//retorno = bastanteoService.insertarBastanteo(bastanteo);
		assertEquals(1, bastanteoService.insertarBastanteo(bastanteo));
		
	}
}
