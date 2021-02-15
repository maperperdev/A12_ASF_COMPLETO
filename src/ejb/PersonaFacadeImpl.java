package ejb;

import javax.annotation.PreDestroy;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import modelo.Persona;

@Stateless
public class PersonaFacadeImpl extends AbstractFacadeJPAImpl<Persona> implements PersonaFacade
{
    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;
    
    public PersonaFacadeImpl() {
        super((Class)Persona.class);
    }
    
    protected EntityManager getEm() {
        return this.em;
    }
    
    @PreDestroy
    public void destruct() {
        this.getEm().close();
    }
}