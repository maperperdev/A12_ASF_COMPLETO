package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private Boolean estado=true;

	public Categoria() {	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
