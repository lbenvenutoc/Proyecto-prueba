package bastanteo.cloud.test;

import org.junit.Test;

import junit.framework.Assert;
import bastanteo.cloud.bean.Usuario;
import bastanteo.cloud.service.UsuarioService;

public class UsuarioTest {
	@Test
	public void controlarUsuarioTest() {

		int retorno = 0;
		
		UsuarioService servicioUsuario = new UsuarioService();
		Usuario objusuario = new Usuario(1, 1,"1234","Gery","Geraldine", "Onofre", "Gonzales",44579887,"A");

		retorno = servicioUsuario.ControlarUsuario(objusuario);
		Assert.assertEquals(1, retorno);
	}
}
