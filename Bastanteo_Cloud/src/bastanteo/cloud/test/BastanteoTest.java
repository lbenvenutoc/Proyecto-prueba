package bastanteo.cloud.test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.Assert;

import org.junit.Test;

import bastanteo.cloud.bean.Bastanteo;
import bastanteo.cloud.bean.BastanteoId;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.bean.RepresentanteId;
import bastanteo.cloud.bean.TipoIntervencion;
import bastanteo.cloud.service.BastanteoService;

public class BastanteoTest {

	//@Test
	public void insertarBastanteo() throws ParseException {

		int retorno = 0;
		Date fechaIni;
		Date fechaFin;

		BastanteoService bastanteoService = new BastanteoService();
		Bastanteo bastanteo = new Bastanteo();
		BastanteoId bastanteoId = new BastanteoId();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// codigo del bastanteo
		bastanteoId.setCEmpresa("1");
		bastanteoId.setCGrupoBastanteo(1);
		bastanteoId.setCPoder("CHC0");

		fechaIni = sdf.parse("2011-02-01");
		fechaFin = sdf.parse("2011-02-01");

		bastanteo.setId(bastanteoId);
		bastanteo.setTipoIntervencion(new TipoIntervencion(1, ""));
		bastanteo.setImporteMin(100);
		bastanteo.setImporteMax(1000);
		bastanteo.setFechaIni(fechaIni);
		bastanteo.setFechaFin(fechaFin);

		
		assertEquals(1, bastanteoService.insertarBastanteo(bastanteo));

	}

	@Test
	public void listarBastanteosxCriterios() {
		BastanteoService bastanteoService = new BastanteoService();

		// PRUEBA POR RUC EMPRESA 21526423628
		List lista = bastanteoService.obtenerBastanteosxCriterios(
				"21526423628", null, null, -1);

		/*
		 * PRUEBA POR ID REPRESENTANTE 
		 * RepresentanteId idRepresentante = new
		 * RepresentanteId(); idRepresentante.setCEmpresa("1");
		 * idRepresentante.setCRepresentante(1); List
		 * lista=bastanteoService.obtenerBastanteosxCriterios(null,
		 * idRepresentante, null, -1);
		 */

		if (lista.size() > 0) {

			for (int i = 0; i < lista.size(); i++) {
				Map objResultado = (Map) lista.get(i);
				System.out.println(objResultado.get("RAZSOC").toString());
				System.out.println(objResultado.get("DESCRIPT_BASTANTEO")
						.toString());
				System.out.println(objResultado.get("C_TIPO_INTERVENCION")
						.toString());
				System.out.println(objResultado.get("IMPORTE_MIN").toString());
				System.out.println(objResultado.get("IMPORTE_MAX").toString());
				System.out.println(objResultado.get("FECINI").toString());
				System.out.println(objResultado.get("FECFIN").toString());
				System.out.println(objResultado.get("NOMBRE_PODER").toString());

			}
		} else {

			System.out
					.println("NO HAY DATOS PARA MOSTRAR SEGUN EL CRITERIO SELECCIONADO");

		}

	}
}
