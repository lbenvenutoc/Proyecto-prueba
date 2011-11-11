package bastanteo.cloud.test;

import junit.framework.Assert;

import org.junit.Test;

import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.service.PoderService;

public class PoderTest {

	// @Test
	public void registrarPoderTest() {

		PoderService servicioPoder = new PoderService();
		Poder objPoder = new Poder("CHCO", "COBRO DE CHEQUE", 'A');
		servicioPoder.registrarPoder(objPoder);
		Poder objPoderObtenido = servicioPoder.obtenerPoder("CHCO");
		System.out.println("CODIGO DE PODER: " + objPoderObtenido.getCPoder());
		System.out.println("NOMBRE DE PODER: " + objPoderObtenido.getNombre());
		Assert.assertNotNull(objPoderObtenido);

	}

	@Test
	public void verificarPoderesTest() {

		PoderService servicioPoder = new PoderService();

		String resultado = servicioPoder.verificarPoder("45236584781",
				"45213697", "CHCO", 2500);

		if (resultado != null) {
			String[] resMensaje = resultado.split("#");
			for (int i = 0; i < resMensaje.length; i++) {
				System.out.println(resMensaje[i]);
			}
			Assert.assertNotNull(resultado);
		}

	}

}
