package controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import ejb.MenuFacade;
import modelo.Menu;
import modelo.Usuario;
// pq el menu es usado en varias páginas y no varía en la aplicación
@Named
@SessionScoped
public class MenuController implements Serializable{
	private static final long serialVersionUID = 1L;

	@EJB
	private MenuFacade EJBMenu;
	
	private List<Menu> lista;
	
	private MenuModel model;
	
	@PostConstruct
	public void init() {
		this.listarMenus(); // carga los menus de la tabla a una lista
		model=new DefaultMenuModel();  //Crea un modelo de menu según Primefaces
		this.establecerPermisos();  //Carga el menú correspondiente según el usuario
	}	
	
	public void listarMenus() {
		try {
			lista=EJBMenu.findAll();
			System.out.println(lista);
		}catch(Exception e) {
			//mensaje jsf
		}
	}
	
	public void establecerPermisos() {
		Usuario us=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		//se recorre cada una de las filas de la tabla menu
		
		/*si es un submenu (tipo=S) y el tipo de usuario se corresponde, pinta en el modelo el submenú 
		(y por cada submenú añade sus items)
		 si no es un submenu (y el tipo de usuario se corresponde) añade al modelo el item*/
		
		for(Menu m: lista) {
			if(m.getTipo().equals("S") && m.getTipoUsuario().equals(us.getTipo())) {
				DefaultSubMenu firstSubmenu= new DefaultSubMenu(m.getNombre());
				for (Menu i:lista) {
					Menu submenu=i.getSubmenu();
					if (submenu!= null) {
						if (submenu.getCodigo()==m.getCodigo()) {
							DefaultMenuItem item=new DefaultMenuItem(i.getNombre());
							item.setUrl(i.getUrl());
							firstSubmenu.addElement(item);
						}
					}
				}
				model.addElement(firstSubmenu);
			}else {
				if(m.getSubmenu()==null  && m.getTipoUsuario().equals(us.getTipo())) {
					DefaultMenuItem item=new DefaultMenuItem(m.getNombre());
					item.setUrl(m.getUrl());
					model.addElement(item);
				}
				
			}
		}
	}

	
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	
	public String mostrarUsuarioLogeado() {
		Usuario us=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		return us.getUsuario();
	}
	
	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public MenuFacade getEJBMenu() {
		return EJBMenu;
	}

	public void setEJBMenu(MenuFacade eJBMenu) {
		EJBMenu = eJBMenu;
	}

	public List<Menu> getLista() {
		return lista;
	}

	public void setLista(List<Menu> lista) {
		this.lista = lista;
	}
}