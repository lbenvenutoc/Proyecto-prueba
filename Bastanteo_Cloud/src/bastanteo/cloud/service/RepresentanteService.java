package bastanteo.cloud.service;

	import bastanteo.cloud.bean.Representante;
	import bastanteo.cloud.dao.RepresentanteDao;
	import bastanteo.cloud.dao.RepresentanteDaoImp;

	public class RepresentanteService {
		
		private RepresentanteDao dao= new RepresentanteDaoImp();
		
		public void inscribirRepresentante(Representante objRepresentante) {
			dao.inscribirRepresentante(objRepresentante);
		}
		
	}

	
