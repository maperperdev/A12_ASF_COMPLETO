package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the nota database table.
 * 
 */
@Entity
@Table(name="nota")
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name = "codigo_categoria",nullable = false)
	private Categoria categoria;
	@Column(name = "comentarioAdmin")
	private String comentarioAdmin;
	@Column(name = "cuerpo")
	private String cuerpo;
	@Column(name = "encabezado")
	private String encabezado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha",insertable = false)
	private Date fecha;

	@Column(name = "valor")
	private Integer valor;
	
	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="codigo_persona",nullable = false)
	private Persona persona;
	
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}



	public Nota() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getComentarioAdmin() {
		return this.comentarioAdmin;
	}

	public void setComentarioAdmin(String comentarioAdmin) {
		this.comentarioAdmin = comentarioAdmin;
	}

	public String getCuerpo() {
		return this.cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getEncabezado() {
		return this.encabezado;
	}

	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}