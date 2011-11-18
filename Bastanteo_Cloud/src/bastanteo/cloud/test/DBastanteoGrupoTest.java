package bastanteo.cloud.test;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import bastanteo.cloud.bean.DBastanteoGrupo;
import bastanteo.cloud.bean.DBastanteoGrupoId;
import bastanteo.cloud.bean.GrupoBastanteo;
import bastanteo.cloud.bean.GrupoBastanteoId;
import bastanteo.cloud.service.DBastanteoGrupoService;

public class DBastanteoGrupoTest {

	@Test 
	public void insertarDBastanteoGrupo() throws ParseException {
		
		DBastanteoGrupoService objDBastanteoGrupoService = new DBastanteoGrupoService(); 
		DBastanteoGrupo objDBastanteoGrupo = new DBastanteoGrupo();
		GrupoBastanteo objGrupoBastanteo = new GrupoBastanteo();
		
		objGrupoBastanteo.setId(new GrupoBastanteoId("100", 2));
		
		objDBastanteoGrupo.setId(new DBastanteoGrupoId("100", 1, "CHCO"));
		objDBastanteoGrupo.setGrupoBastanteo(objGrupoBastanteo);		
		
		assertEquals(1, objDBastanteoGrupoService.insertarBastanteo(objDBastanteoGrupo));
	}
	
}
