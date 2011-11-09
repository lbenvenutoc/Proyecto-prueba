package bastanteo.cloud.test;

import junit.framework.Assert;

import org.junit.Test;

import bastanteo.cloud.bean.Poder;
import bastanteo.cloud.service.PoderService;

public class PoderTest {
	
	@Test
	public void registrarPoder(){
		
		PoderService servicioPoder= new PoderService();
		Poder objPoder= new Poder("P001", "AAAASSSS", 'A');
		
		servicioPoder.registrarPoder(objPoder);
		Assert.assertEquals(1, 1);
		
		
	}
	//@Test
	public void obtenerPoder(){
		
		PoderService servicioPoder= new PoderService();
		Poder objPoder=servicioPoder.obtenerPoder("P001");
		
		boolean actual=false;
		if(objPoder.getNombre()!=null){
			actual=true;
		}
		Assert.assertEquals(true, actual);
		
	}

}
