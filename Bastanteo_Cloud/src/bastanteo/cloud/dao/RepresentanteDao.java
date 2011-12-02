package bastanteo.cloud.dao;

import java.util.List;

import bastanteo.cloud.bean.Representante;

 	public interface RepresentanteDao {
		
		public int inscribirRepresentante(Representante objRepresentante);
		public int modificarRepresentantes(Representante objRepresentante);
		public Representante obtenerRepresentantes(Representante objRepresentante);
		public boolean existeDniRepresentante(Representante objRepresentante);
		public boolean perteneceEmpresaRepresentante(Representante objRepresentante);
		public List listar();
}

 	