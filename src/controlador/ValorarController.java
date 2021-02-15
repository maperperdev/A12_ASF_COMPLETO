package controlador;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import modelo.Nota;
import javax.inject.Inject;
import javax.ejb.EJB;
import ejb.NotaFacade;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ValorarController implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EJB
    private NotaFacade notaEJB;
    @Inject
    private ComentarController comentarController;
    private Nota nota;
    
    @PostConstruct
    public void init() {
        this.nota = this.comentarController.getNota();
    }
    
    public Nota getNota() {
        return this.nota;
    }
    
    public void setNota(final Nota nota) {
        this.nota = nota;
    }
    
    public ComentarController getComentarController() {
        return this.comentarController;
    }
    
    public void setComentarController(final ComentarController comentarController) {
        this.comentarController = comentarController;
    }
    
    public void registrar() {
        try {
            this.notaEJB.update((Nota)this.nota);
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se coment\u00f3 correctamente"));
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
            return;
        }
        finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
    public NotaFacade getNotaEJB() {
        return this.notaEJB;
    }
    
    public void setNotaEJB(final NotaFacade notaEJB) {
        this.notaEJB = notaEJB;
    }
}