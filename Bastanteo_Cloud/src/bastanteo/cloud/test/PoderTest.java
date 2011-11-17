package bastanteo.cloud.test;

import junit.framework.Assert;

import org.junit.Test;

import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.service.PoderService;

public class PoderTest {

	@Test
	public void registrarPoderTest() {

		PoderService servicioPoder = new PoderService();
		int indicador = 0;

		Poder objPoder = new Poder("P001", "COBRO DE CHEQUE", 'A');
		Poder objPoderObtenido = servicioPoder.obtenerPoder(objPoder.getCPoder());

		if (objPoderObtenido!=null) {
			System.out.println("YA EXISTE PODER CON CODIGO "
					+ objPoder.getCPoder());
		} else {

			if (objPoder.getCPoder() == null || objPoder.getNombre() == null
					|| objPoder.getTipoPoder() == ' ') {
				System.out.println("FALTAN INGRESAR DATOS");
			} else {

				indicador = servicioPoder.registrarPoder(objPoder);
				if (indicador == 1) {
					System.out.println("OK");
					Assert.assertEquals(1, indicador);
					
				} else {
					System.out.println("ERROR AL INGRESAR DATOS");
					
				}
			}

		
		}
		
	
		
	}

	//@Test
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
