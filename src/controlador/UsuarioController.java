package controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.UsuarioFacade;
import modelo.Persona;
import modelo.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;
	
	@Inject
	private Persona persona;
	
	@EJB
	private UsuarioFacade usuarioEJB;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public UsuarioFacade getUsuarioEJB() {
		return usuarioEJB;
	}

	public void setUsuarioEJB(UsuarioFacade usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
	}
	
	/*
	 * Caused by: Exception [EclipseLink-4002] (Eclipse Persistence Services - 2.7.0.v20170811-d680af5)
	 * Internal Exception: com.mysql.jdbc.exceptions.jdbc.MySQLIntegrityContraintViolationException: 
	 * Call: INSERT INTO usuario (clave,estado,tipo,usuario,codigo) VALUES (?,?,?,?,?)
	 * 
	 * public void registrar(){
	 * 	try{
	 * 		usuarioEJB.create(usuario);
	 *		//mensaje
	 *	}catch(Exception e){
	 *		//mensaje
	 *	}
	 */
	
	//primero hay que insertar persona y despues usuario
	public void registrar() {
		try {
			//IllegalStateException: During synchronization a
			//new object was found through a relationship that was not marked cascade PERSIST: modelo.Perosna@2892d9d2
			
			//hay que persistir en cascada en el modelo Usuario @OneToOne(cascade=CascadeType.PERSIST)
			this.usuario.setCodigo(persona);
			usuarioEJB.create(usuario);
			//mensaje en usuario7 controlar los mensajes
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró correctamente"));
		}catch(Exception e) {
			//mensaje
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","No se registró"));
		}
	}
}
