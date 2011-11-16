package bastanteo.cloud.service;

	import java.util.List;

import bastanteo.cloud.bean.Representante;
	import bastanteo.cloud.dao.RepresentanteDao;
import bastanteo.cloud.dao.RepresentanteDaoImp;

	public class RepresentanteService {
		
		private RepresentanteDao dao= new RepresentanteDaoImp();
		
		public int inscribirRepresentante(Representante objRepresentante) {
			return dao.inscribirRepresentante(objRepresentante);
		}
		
		public int modificarRepresentantes(Representante objRepresentante) {
			return dao.modificarRepresentantes(objRepresentante);
		}
		
		public Representante obtenerRepresentantes(Representante objRepresentante) {
			return dao.obtenerRepresentantes(objRepresentante);
		}
		
		public boolean existeDniRepresentante(
				Representante objRepresentante) {
			return dao.existeDniRepresentante(objRepresentante);
		}
		public boolean perteneceEmpresaRepresentante(Representante objRepresentante) {
			return dao.perteneceEmpresaRepresentante(objRepresentante);
		}
		
	}

	
