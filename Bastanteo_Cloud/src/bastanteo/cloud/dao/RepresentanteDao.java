package bastanteo.cloud.dao;

import java.util.List;

import bastanteo.cloud.bean.Representante;

 	public interface RepresentanteDao {
		
		public void inscribirRepresentante(Representante objRepresentante);
		public int modificarRepresentantes(Representante objRepresentante);
		public Representante obtenerRepresentantes(Representante objRepresentante);
		public List obtenerRepresentantesPorDni(Representante objRepresentante);
		
}

 	