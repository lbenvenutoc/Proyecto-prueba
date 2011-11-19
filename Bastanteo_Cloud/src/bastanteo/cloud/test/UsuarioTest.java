package bastanteo.cloud.test;



import org.junit.Test;

import junit.framework.Assert;
import bastanteo.cloud.bean.Perfil;
import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.service.PerfilService;
import bastanteo.cloud.service.UsuarioService;

public class UsuarioTest {
	
	//@Test
	public void controlarUsuarioTest() {

		int retorno = 0;
		
		UsuarioService servicioUsuario = new UsuarioService();
		PerfilService servicioPerfil= new PerfilService();
		//Inicializo un perfil
		Perfil p= new Perfil();
		//Inicializo un perfil con el codigo 1 q ya existe
		p.setCPerfil(1);
		Perfil objPerfil=servicioPerfil.obtenerPerfil(p);
		Usuario objusuario = new Usuario(1, objPerfil,"1234","Gery","Geraldine", "Onofre", "Gonzales","44579887",'A',"1234");
	
		
		Usuario objUsuarioObt=servicioUsuario.obtenerUsuario(objusuario);
					
			if(objUsuarioObt!=null){
				
					System.out.println("YA EXISTE UN USUARIO CON DICHO CODIGO");
				
				
			}
			else if(objusuario.getClave()!=objusuario.getClaveconfirm()){
					System.out.println("CLAVE Y SU CONFIRMACION NO COINCIDEN");
			}else if(servicioUsuario.obtenerUsuarioxDni(objusuario)!=null){
				System.out.println("YA EXISTE UN USUARIO CON ESE DOCUMENTO DE IDENTIDAD");
			}
			else{
				System.out.println("DATOS DE USUARIO REGISTRADOS CORRECTAMENTE");
				retorno = servicioUsuario.ControlarUsuario(objusuario);
				
				
				Assert.assertEquals(1, retorno);
			}
		
			
		
		
	}
	
	@Test
	public void modificarUsuarioTest() {

		int retorno = 0;
		
		UsuarioService servicioUsuario = new UsuarioService();
		Usuario objUsuario = new Usuario();
		objUsuario.setCUsuario(1);
		Usuario objUsuarioObt=servicioUsuario.obtenerUsuario(objUsuario);
		//objUsuarioObt.setLogin("GERAL");
		objUsuarioObt.setNombre("Lisseth");
		
		retorno = servicioUsuario.modificarUsuario(objUsuarioObt);
		if(retorno!=0){
			System.out.println("EL USUARIO SE MODIFICO CORRECTAMENTE");
			Assert.assertEquals(1, retorno);
		}
		
	}
	
}
