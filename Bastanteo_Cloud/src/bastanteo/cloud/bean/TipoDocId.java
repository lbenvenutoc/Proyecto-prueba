package bastanteo.cloud.bean;

// Generated 08/11/2011 11:03:59 PM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoDocId generated by hbm2java
 */
@Entity
@Table(name = "tipo_doc_id", catalog = "bd_bastanteo")
public class TipoDocId implements java.io.Serializable {

	private int CTipoDocId;
	private String nombre;
	private String abreviatura;
	private Set representantes = new HashSet(0);

	public TipoDocId() {
	}

	public TipoDocId(int CTipoDocId, String nombre, String abreviatura) {
		this.CTipoDocId = CTipoDocId;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
	}

	public TipoDocId(int CTipoDocId, String nombre, String abreviatura,
			Set representantes) {
		this.CTipoDocId = CTipoDocId;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.representantes = representantes;
	}

	@Id
	@Column(name = "C_TIPO_DOC_ID", unique = true, nullable = false)
	public int getCTipoDocId() {
		return this.CTipoDocId;
	}

	public void setCTipoDocId(int CTipoDocId) {
		this.CTipoDocId = CTipoDocId;
	}

	@Column(name = "NOMBRE", nullable = false, length = 40)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ABREVIATURA", nullable = false, length = 10)
	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDocId")
	public Set getRepresentantes() {
		return this.representantes;
	}

	public void setRepresentantes(Set representantes) {
		this.representantes = representantes;
	}

}
