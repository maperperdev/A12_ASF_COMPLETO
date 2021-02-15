package ejb;

import javax.ejb.Local;

import modelo.Usuario;

@Local
public interface UsuarioFacade extends AbstractFacadeJPA<Usuario>{
	public Usuario iniciarSesion(Usuario us);
}