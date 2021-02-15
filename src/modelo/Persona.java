package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "apellidos")
	private String apellidos;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "sexo")
	private String sexo;



	public Persona() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


}