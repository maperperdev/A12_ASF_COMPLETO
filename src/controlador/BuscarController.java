package controlador;

import javax.faces.context.FacesContext;
import modelo.Usuario;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import modelo.Nota;
import modelo.Categoria;
import java.util.List;
import ejb.NotaFacade;
import javax.ejb.EJB;
import ejb.CategoriaFacade;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class BuscarController implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EJB
    private CategoriaFacade categoriaEJB;
    @EJB
    private NotaFacade notaEJB;
    private List<Categoria> listaCategorias;
    private List<Nota> listaNotas;
    private Integer codigoCategoria;
    private Date fechaConsulta;
    
    @PostConstruct
    public void init() {
        this.listaCategorias = (List<Categoria>)this.categoriaEJB.findAll();
        this.listaNotas = new ArrayList<Nota>();
    }
    
    public CategoriaFacade getCategoriaEJB() {
        return this.categoriaEJB;
    }
    
    public void setCategoriaEJB(final CategoriaFacade categoriaEJB) {
        this.categoriaEJB = categoriaEJB;
    }
    
    public List<Categoria> getListaCategorias() {
        return this.listaCategorias;
    }
    
    public void setListaCategorias(final List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
    
    public Integer getCodigoCategoria() {
        return this.codigoCategoria;
    }
    
    public void setCodigoCategoria(final Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }
    
    public Date getFechaConsulta() {
        return this.fechaConsulta;
    }
    
    public void setFechaConsulta(final Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }
    
    public void buscar() {
        try {
            final Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            System.out.println(" usuario " + us.getCodigo().getCodigo() + " categoria " + this.codigoCategoria + " fecha " + this.fechaConsulta);
            this.listaNotas = (List<Nota>)this.notaEJB.buscar(us.getCodigo().getCodigo(), this.codigoCategoria, this.fechaConsulta);
        }
        catch (Exception e) {
            System.out.println(String.valueOf(e.getMessage()) + " lala");
        }
    }
    
    public NotaFacade getNotaEJB() {
        return this.notaEJB;
    }
    
    public void setNotaEJB(final NotaFacade notaEJB) {
        this.notaEJB = notaEJB;
    }
    
    public List<Nota> getListaNotas() {
        return this.listaNotas;
    }
    
    public void setListaNotas(final List<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }
}