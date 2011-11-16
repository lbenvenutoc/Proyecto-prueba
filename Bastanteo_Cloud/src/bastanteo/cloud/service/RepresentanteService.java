package bastanteo.cloud.service;

	import java.util.List;

import bastanteo.cloud.bean.Representante;
	import bastanteo.cloud.dao.RepresentanteDao;
import bastanteo.cloud.dao.RepresentanteDaoImp;

	public class RepresentanteService {
		
		private RepresentanteDao dao= new RepresentanteDaoImp();
		
		public void inscribirRepresentante(Representante objRepresentante) {
			dao.inscribirRepresentante(objRepresentante);
		}
		
		public int modificarRepresentantes(Representante objRepresentante) {
			return dao.modificarRepresentantes(objRepresentante);
		}
		
		public Representante obtenerRepresentantes(Representante objRepresentante) {
			return dao.obtenerRepresentantes(objRepresentante);
		}
		
		public List obtenerRepresentantesPorDni(
				Representante objRepresentante) {
			return dao.obtenerRepresentantesPorDni(objRepresentante);
		}
		
	}

	
