package bastanteo.cloud.bean;

// Generated 08/11/2011 11:03:59 PM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * GrupoBastanteo generated by hbm2java
 */
@Entity
@Table(name = "grupo_bastanteo", catalog = "bd_bastanteo")
public class GrupoBastanteo implements java.io.Serializable {

	private GrupoBastanteoId id;
	private Empresa empresa;
	private String descripcion;
	private String abreviatura;
	//private Set DBastanteoGrupos = new HashSet(0);
	private Set<Bastanteo> bastanteos = new HashSet<Bastanteo>(0);
	private Set<Representante> representantes = new HashSet<Representante>(0);

	public GrupoBastanteo() {
	}

	public GrupoBastanteo(GrupoBastanteoId id, Empresa empresa,
			String descripcion, String abreviatura) {
		this.id = id;
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.abreviatura = abreviatura;
	}
/*
	public GrupoBastanteo(GrupoBastanteoId id, Empresa empresa,
			String descripcion, String abreviatura, Set DBastanteoGrupos,
			Set bastanteos, Set representantes) {
		this.id = id;
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.abreviatura = abreviatura;
		this.DBastanteoGrupos = DBastanteoGrupos;
		this.bastanteos = bastanteos;
		this.representantes = representantes;
	}
*/
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "CEmpresa", column = @Column(name = "C_EMPRESA", nullable = false, length = 8)),
			@AttributeOverride(name = "CGrupoBastanteo", column = @Column(name = "C_GRUPO_BASTANTEO", nullable = false)) })
	public GrupoBastanteoId getId() {
		return this.id;
	}

	public void setId(GrupoBastanteoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_EMPRESA", nullable = false, insertable = false, updatable = false)
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "ABREVIATURA", nullable = false, length = 10)
	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoBastanteo")
	public Set getDBastanteoGrupos() {
		return this.DBastanteoGrupos;
	}

	public void setDBastanteoGrupos(Set DBastanteoGrupos) {
		this.DBastanteoGrupos = DBastanteoGrupos;
	}
*/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoBastanteo")
	public Set<Bastanteo> getBastanteos() {
		return this.bastanteos;
	}

	public void setBastanteos(Set<Bastanteo> bastanteos) {
		this.bastanteos = bastanteos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoBastanteo")
	public Set<Representante> getRepresentantes() {
		return this.representantes;
	}

	public void setRepresentantes(Set<Representante> representantes) {
		this.representantes = representantes;
	}

}
