package bastanteo.cloud.test;

import junit.framework.Assert;

import org.junit.Test;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.GrupoBastanteo;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.bean.Representante;
import bastanteo.cloud.bean.RepresentanteId;
import bastanteo.cloud.bean.TipoDocId;
import bastanteo.cloud.service.EmpresaService;
import bastanteo.cloud.service.GrupoBastanteoService;
import bastanteo.cloud.service.RepresentanteService;
import bastanteo.cloud.service.TipoDocIdService;

public class RepresentanteTest {

	@Test
	public void inscribirRepresentanteTest() {
		int resultado=0;
		// Llamada a servivios que seran utilizados
		RepresentanteService servicioRepresentante = new RepresentanteService();
		GrupoBastanteoService servicioGrupoBastanteo = new GrupoBastanteoService();
		TipoDocIdService servicioTipoDocId = new TipoDocIdService();
		EmpresaService servicioEmpresa = new EmpresaService();

		// Inicializo la llave primaria compuesta de Representante
		RepresentanteId idRepresentante = new RepresentanteId();
		idRepresentante.setCEmpresa("1");
		idRepresentante.setCRepresentante(1);

		// Se obtiene el grupo de bastanteo que se asignará al representante
		GrupoBastanteo objGrupoBastanteo = new GrupoBastanteo();
		GrupoBastanteoId idGrupoBastanteo = new GrupoBastanteoId("1", 1);
		objGrupoBastanteo.setId(idGrupoBastanteo);
		GrupoBastanteo objGrupoBastanteoObt = servicioGrupoBastanteo
				.obtenerGrupoBastanteo(objGrupoBastanteo);

		// Se obtiene el tipo de documento de identidad que se asignará al
		// representante
		TipoDocId objTipoDocId = new TipoDocId();
		objTipoDocId.setCTipoDocId(1);
		TipoDocId objTipDocIdObt = servicioTipoDocId
				.obtenerTipoDocId(objTipoDocId);

		// Se obtiene la empresa que se asignará al representante
		Empresa objEmpresa = new Empresa();
		objEmpresa.setCEmpresa("1");
		Empresa objEmpresaObt = servicioEmpresa.obtenerEmpresa(objEmpresa);

		Representante objRepresentante = new Representante(idRepresentante,
				objTipDocIdObt, objEmpresaObt, objGrupoBastanteoObt,
				"PRINCIPE", "ASCA", "JENNY", "10743370", "SUPERVISOR");

		if (objRepresentante.getTipoDocId() == null
				|| objRepresentante.getEmpresa() == null
				|| objRepresentante.getGrupoBastanteo() == null
				|| objRepresentante.getApePaterno() == null
				|| objRepresentante.getApeMaterno() == null
				|| objRepresentante.getNombre() == null
				|| objRepresentante.getNumDocId() == null
				|| objRepresentante.getCargoEmpresa() == null) {

			System.out.println("FALTAN INGRESAR DATOS");
		} else if (servicioRepresentante.perteneceEmpresaRepresentante(objRepresentante) == true) {

			System.out
					.println("ESTE REPRESENTANTE YA PERTENECE A DICHA EMPRESA");

		} else {
			resultado=servicioRepresentante.inscribirRepresentante(objRepresentante);
			Assert.assertEquals(1, resultado);
			System.out.println("DATOS INGRESADOS CORRECTAMETE");
		}

	}

	 //@Test
	public void modificarRepresentantesTest() {

		int resultado = 0;

		RepresentanteService servicioRepresentante = new RepresentanteService();
		Representante objRepresentante = new Representante();

		RepresentanteId idRepresentante = new RepresentanteId();
		idRepresentante.setCEmpresa("1");
		idRepresentante.setCRepresentante(1);
		objRepresentante.setId(idRepresentante);

		Representante objRepresentanteObt = servicioRepresentante
				.obtenerRepresentantes(objRepresentante);
		objRepresentanteObt.setApePaterno("GOMEZ");
		
		resultado = servicioRepresentante
		.modificarRepresentantes(objRepresentanteObt);
		
		if(resultado!=0){
			System.out.println("MODIFICACION REALIZADA");
		}else{
			System.out.println("ERROR AL MODIFICAR DATOS");
		}
		
		/*
		if (servicioRepresentante.existeDniRepresentante(
				objRepresentanteObt)==false) {
			resultado = servicioRepresentante
					.modificarRepresentantes(objRepresentanteObt);
			Assert.assertEquals(1, resultado);
			System.out.println("MODIFICACION CORRECTA");
		} else {
			System.out
					.println("NO SE PUEDE MODIFICAR DICHO DNI PUESTO QUE YA EXISTE EN LA BASE DE DATOS");
		}
		
		*/

	}
}
