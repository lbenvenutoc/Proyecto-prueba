package bastanteo.cloud.test;
	import junit.framework.Assert;

	import org.junit.Test;

	import bastanteo.cloud.bean.Representante;
	import bastanteo.cloud.service.RepresentanteService;

	public class RepresentanteTest {
	
		 @Test
		public void inscribirRepresentanteTest() {

			RepresentanteService servicioRepresentante = new RepresentanteService();
			Representante objRepresentante = new Representante("100", "001", "PRINCIPE", "ASCA", "JENNY","DNI","1074337","ADMINISTRADOR","100","1");
			servicioRepresentante.inscribirRepresentante(objRepresentante);
			
		 }
}

		 