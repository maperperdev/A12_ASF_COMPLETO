package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the telefono database table.
 * 
 */
@Entity
@Table(name="telefono")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Column(name = "numero")
	private String numero;

	@ManyToOne
	@JoinColumn(name="codigo_persona")
	private Persona persona;

	public Telefono() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}