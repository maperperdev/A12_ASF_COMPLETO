package controlador;

import javax.annotation.PostConstruct;
import modelo.Nota;
import java.util.List;
import javax.ejb.EJB;
import ejb.NotaFacade;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class ComentarController implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EJB
    private NotaFacade notaEJB;
    private List<Nota> notas;
    private Nota nota;
    
    @PostConstruct
    public void init() {
        this.notas = (List<Nota>)this.notaEJB.findAll();
        System.out.println(this.notas);
    }
    
    public String asignar(final Nota nota) {
        this.nota = nota;
        return "valorar";
    }
    
    public NotaFacade getNotaEJB() {
        return this.notaEJB;
    }
    
    public void setNotaEJB(final NotaFacade notaEJB) {
        this.notaEJB = notaEJB;
    }
    
    public List<Nota> getNotas() {
        return this.notas;
    }
    
    public void setNotas(final List<Nota> notas) {
        this.notas = notas;
    }
    
    public Nota getNota() {
        return this.nota;
    }
    
    public void setNota(final Nota nota) {
        this.nota = nota;
    }
}