package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name="menu")
public class EseMenuMio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codigo;
	@Column(name = "estado")
	private boolean estado = true;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "tipoUsuario")
	private String tipoUsuario;
	@Column(name = "url")
	private String url;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="codigo_submenu")
	private EseMenuMio menu;


	public EseMenuMio() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public EseMenuMio getMenu() {
		return this.menu;
	}

	public void setMenu(EseMenuMio menu) {
		this.menu = menu;
	}

}