package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * javax.persistence.CascadeType
	 * Define el conjunto de operaciones en cascada que se propagan a la entidad asociada.
	 * El valor cascade=ALL es equivalente a cascade={PERSIST,MERGE,REMOVE,REFRESH,DETACH}
	 * nullable pq no se permiten nulos
	 */
	@Id
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="codigo",nullable = false)
	private Persona codigo;
	
	
	@Column(name = "clave")
	private String clave;
	@Column(name = "estado")
	private Short estado=1;

	@Column(name = "tipo")
	private String tipo;
	@Column(name = "usuario")
	private String usuario;

	public Usuario() {
	}


	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}


	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Persona getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Persona codigo) {
		this.codigo = codigo;
	}

}