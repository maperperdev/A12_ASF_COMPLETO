package controlador;
import java.io.Serializable;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;



import ejb.UsuarioFacade;

import modelo.Usuario;
//importante: hacer serializable el managed bean
@Named
@ViewScoped
public class IndexController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuario usuario;
	
	
	
	@EJB
	private UsuarioFacade usuarioEJB;
	


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	
	//primero hay que insertar persona y después usuario
	public String iniciarSesion() {
		String redireccion=null;
		Usuario us=null;
		try {
			
			us=usuarioEJB.iniciarSesion(usuario);
			if (us!=null) {
				//Almacenar en la sesión de JSF
				//se guarda la inf de nuestro usuario logueado.
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
				//navegación implicita pq no se ve la ruta en la url.
				//si quiero que se vea añadir ?faces-redirect=true
				//redireccion="/protegido/principal?faces-redirect=true";
				redireccion="/protegido/principal";
			}
			else {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Usuario incorrecto."));
			}
		}catch(Exception e) {
			//mensaje
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error."));
			
		}
		return redireccion;
	}
	
	
	//solo sirve para probar plantilla1.xhtml y principal1.xhtml
	public String iniciarSesion1() {
		String redireccion=null;
		Usuario us=null;
		try {
			
			us=usuarioEJB.iniciarSesion(usuario);
			if (us!=null) {
				//Almacenar en la sesión de JSF
				//se guarda la inf de nuestro usuario logueado.
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
				//navegación implicita pq no se ve la ruta en la url.
				//si quiero que se vea añadir ?faces-redirect=true
				//redireccion="/protegido/principal?faces-redirect=true";
				redireccion="/protegido/principal1";
			}
			else {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Usuario incorrecto."));
			}
		}catch(Exception e) {
			//mensaje
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error."));
			
		}
		return redireccion;
	}
	
	
}