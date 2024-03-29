package bastanteo.cloud.bean;

// Generated 08/11/2011 11:03:59 PM by Hibernate Tools 3.3.0.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "bd_bastanteo")
public class Usuario implements java.io.Serializable {

	private int CUsuario;
	private Perfil perfil;
	private String clave;
	private String login;
	private String nombre;
	private String paterno;
	private String materno;
	private String dni;
	private char flagActivo;
	private String claveconfirm;

	public Usuario() {
	}

	public Usuario(int CUsuario, Perfil perfil, String clave, String login,
			String nombre, String paterno, String materno, String dni, String claveconfirm) {
		this.CUsuario = CUsuario;
		this.perfil = perfil;
		this.clave = clave;
		this.login = login;
		this.nombre = nombre;
		this.paterno=paterno;
		this.materno=materno;
		this.dni=dni;
		this.claveconfirm=claveconfirm;
		
	}

	public Usuario(int CUsuario, Perfil perfil, String clave, String login,
			String nombre,String paterno, String materno, String dni, char flagActivo, String claveconfirm) {
		this.CUsuario = CUsuario;
		this.perfil = perfil;
		this.clave = clave;
		this.login = login;
		this.nombre = nombre;
		this.paterno=paterno;
		this.materno=materno;
		this.dni=dni;
		this.flagActivo = flagActivo;
		this.claveconfirm=claveconfirm;
	}

	@Id
	@Column(name = "C_USUARIO", unique = true, nullable = false)
	public int getCUsuario() {
		return this.CUsuario;
	}

	public void setCUsuario(int CUsuario) {
		this.CUsuario = CUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_PERFIL", nullable = false)
	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Column(name = "CLAVE", nullable = false, length = 15)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	@Column(name = "CLAVECONFIRM", nullable = false, length = 15)
	public String getClaveconfirm() {
		return claveconfirm;
	}

	public void setClaveconfirm(String claveconfirm) {
		this.claveconfirm = claveconfirm;
	}

	@Column(name = "LOGIN", nullable = false, length = 15)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "NOMBRE", nullable = false, length = 40)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "FLAG_ACTIVO", length = 1)
	public char getFlagActivo() {
		return this.flagActivo;
	}

	public void setFlagActivo(char flagActivo) {
		this.flagActivo = flagActivo;
	}
	
	@Column(name = "PATERNO", nullable = false, length = 45)
	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	
	@Column(name = "MATERNO", nullable = false, length = 45)
	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}
	
	@Column(name = "DNI", nullable = false, length = 8)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

}
