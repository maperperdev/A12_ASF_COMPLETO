package controlador;

import javax.faces.application.FacesMessage;
import modelo.Usuario;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import java.util.List;
import modelo.Categoria;
import javax.inject.Inject;
import modelo.Nota;
import ejb.CategoriaFacade;
import javax.ejb.EJB;
import ejb.NotaFacade;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class NotaController implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EJB
    private NotaFacade notaEJB;
    @EJB
    private CategoriaFacade categoriaEJB;
    @Inject
    private Nota nota;
    @Inject
    private Categoria categoria;
    private List<Categoria> categorias;
    
    @PostConstruct
    public void init() {
        this.categorias = (List<Categoria>)this.categoriaEJB.findAll();
    }
    
    public void registrar() {
        try {
            final FacesContext context = FacesContext.getCurrentInstance();
            final Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            this.nota.setCategoria(this.categoria);
            this.nota.setPersona(us.getCodigo());
            this.notaEJB.create((Nota)this.nota);
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registr\u00f3"));
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
    }
    
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(final Categoria categoria) {
        this.categoria = categoria;
    }
    
    public NotaFacade getNotaEJB() {
        return this.notaEJB;
    }
    
    public void setNotaEJB(final NotaFacade notaEJB) {
        this.notaEJB = notaEJB;
    }
    
    public Nota getNota() {
        return this.nota;
    }
    
    public void setNota(final Nota nota) {
        this.nota = nota;
    }
    
    public CategoriaFacade getCategoriaEJB() {
        return this.categoriaEJB;
    }
    
    public void setCategoriaEJB(final CategoriaFacade categoriaEJB) {
        this.categoriaEJB = categoriaEJB;
    }
    
    public List<Categoria> getCategorias() {
        return this.categorias;
    }
    
    public void setCategorias(final List<Categoria> categorias) {
        this.categorias = categorias;
    }
}