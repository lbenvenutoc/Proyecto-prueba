package bastanteo.cloud.test;

import org.junit.Assert;
import org.junit.Test;

import bastanteo.cloud.bean.Empresa;
import bastanteo.cloud.bean.TipoEmpresa;
import bastanteo.cloud.service.EmpresaService;
import bastanteo.cloud.service.TipoEmpresaService;
import bastanteo.cloud.util.Utilitario;

public class EmpresaTest {
	@Test
	public void registrarEmpresa(){
		
		int resultado=0;
		EmpresaService servicioEmpresa= new EmpresaService();
		TipoEmpresaService servicioTipoEmpresa= new TipoEmpresaService();
		TipoEmpresa objTipoEmpresa= new TipoEmpresa();
		objTipoEmpresa.setCTipoEmpresa(1);
		TipoEmpresa tipoEmpresa=  servicioTipoEmpresa.obtenerTipoEmpresa(objTipoEmpresa);
		Utilitario objUtil=Utilitario.crearUtilitario();
		
		Empresa objEmpresa= 
			new Empresa("2", tipoEmpresa, "21526423628", "INVERSIONES UNIDAS SAC", objUtil.convertirCadenaPorFecha("08/09/2011"), 178);
			
		
		Empresa objEmpresaObt=servicioEmpresa.obtenerEmpresa(objEmpresa);
		Empresa objEmpresaObtRuc=servicioEmpresa.obtenerEmpresaxRuc(objEmpresa);
		
		if(objEmpresa.getCEmpresa()==null || objEmpresa.getRuc()==null || objEmpresa.getTipoEmpresa()==null || objEmpresa.getCantEmpleado()==0 || objEmpresa.getFechaInicioOper()==null ||  objEmpresa.getRazonSocial()==null){
			System.out.println("FALTAN INGRESAR DATOS");
		}else if(objEmpresaObt!=null){
			System.out.println("LA EMPRESA YA EXISTE CON DICHO CODIGO");
		}else if(objEmpresaObtRuc!=null){
			System.out.println("EL RUC DE LA EMPRESA YA ESTA REGISTRADO");
		}else{
			resultado = servicioEmpresa.registrarEmpresa(objEmpresa);
			Assert.assertEquals(resultado,1);
			System.out.println("EMPRESA REGISTRADA CORRECTAMENTE");
		}
		
		
	}
	
	//@Test
	public void actualizarEmpresa(){
		
		int resultado=0;
		EmpresaService servicioEmpresa= new EmpresaService();
		Empresa objEmpresa= new Empresa();
		objEmpresa.setCEmpresa("1");
		Empresa objEmpresaObt=servicioEmpresa.obtenerEmpresa(objEmpresa);
		objEmpresaObt.setRazonSocial("INVERSIONES UNIDAS");
		resultado=servicioEmpresa.modificarEmpresa(objEmpresaObt);
		
		if(resultado!=0){
			System.out.println("EMPRESA MODIFICADA CORRECTAMENTE");
			Assert.assertEquals(resultado,1);
		}else{
			System.out.println("ERROR AL MODIFICAR LA EMPRESA");
		}
	
		
	}
	

}
