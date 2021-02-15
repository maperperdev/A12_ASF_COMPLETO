package modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="menu")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="url")
	private String url;
	
	@Column(name="tipo")
	private String tipo;
	
	
	
	@Column(name="tipoUsuario")
	private String tipoUsuario;
	
	//un codigo_submenu es el menu al que pertenece. PEj Nuevo y Buscar pertenecen al submenu de Notas
	@ManyToOne
	@JoinColumn(name="codigo_submenu")
	private Menu submenu;
	
	@Column(name="estado")
	private boolean estado=true;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Menu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(Menu submenu) {
		this.submenu = submenu;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Menu [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}