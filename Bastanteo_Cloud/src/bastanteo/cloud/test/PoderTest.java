package bastanteo.cloud.test;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.bean.Representante;
import bastanteo.cloud.service.PoderService;

public class PoderTest {

	// @Test
	public void registrarPoderTest() {

		PoderService servicioPoder = new PoderService();
		Poder objPoder = new Poder("P001", "AAAASSSS", 'A');

		servicioPoder.registrarPoder(objPoder);
		Assert.assertEquals(1, 1);

	}

	// @Test
	public void obtenerPoder() {

		PoderService servicioPoder = new PoderService();
		Poder objPoder = servicioPoder.obtenerPoder("P001");

		boolean actual = false;
		if (objPoder.getNombre() != null) {
			actual = true;
		}
		Assert.assertEquals(true, actual);

	}

	@Test
	public void verificarPoderesTest() {

		PoderService servicioPoder = new PoderService();
		//String resultado=servicioPoder.verificarPoder("45212365789", "442365245", "P001", 2500);
		String resultado=servicioPoder.verificarPoder("45212365789", "442365245", "P001", 2500);
		/*
		Map objH = (Map) resultado.get(0);
		double importeMin=Double.parseDouble(objH.get("IMPORTE_MIN").toString());
		*/
		String[]resMensaje=resultado.split("#");
		for(int i=0;i<resMensaje.length;i++){
			System.out.println(resMensaje[i]);
		}
		
		
		
	}

}
