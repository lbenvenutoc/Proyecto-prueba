package bastanteo.cloud.test;

import org.junit.Test;

import junit.framework.Assert;
import bastanteo.cloud.bean.TipoIntervencion;
import bastanteo.cloud.service.TipoIntervencionService;

public class TipoIntervencionTest {

	
	@Test
	public void registrarTipoIntervencionTest() {

		int retorno = 0;
		
		TipoIntervencionService servicioTipoIntervencion = new TipoIntervencionService();
		TipoIntervencion objTipoIntervencion = new TipoIntervencion(1, "A SOLA FIRMA");

		retorno = servicioTipoIntervencion.registrarTipoIntervencion(objTipoIntervencion);
		Assert.assertEquals(1, retorno);
	}
	
	
}
