package ejb;

import javax.persistence.TypedQuery;
import java.util.Calendar;
import javax.persistence.TemporalType;
import java.util.Date;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Selection;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import modelo.Nota;

@Stateless
public class NotaFacadeImpl extends AbstractFacadeJPAImpl<Nota> implements NotaFacade
{
    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;
    
    public NotaFacadeImpl() {
        super((Class)Nota.class);
    }
    
    protected EntityManager getEm() {
        return this.em;
    }
    
    @PreDestroy
    public void destruct() {
        this.getEm().close();
    }
    
    public List<Nota> findAll() {
        final CriteriaQuery<Nota> cq = (CriteriaQuery<Nota>)this.getEm().getCriteriaBuilder().createQuery((Class)Nota.class);
        cq.select((Selection)cq.from((Class)Nota.class));
        return (List<Nota>)this.getEm().createQuery((CriteriaQuery)cq).getResultList();
    }
    
    public List<Nota> buscar(final Integer codigoPersona, final Integer codigoCategoria, final Date fechaConsulta) throws Exception {
        List<Nota> lista = null;
        try {
            final String jpql = "Select n from Nota n where n.persona.codigo=:codigop and n.categoria.codigo=:codigoc and n.fecha between :fecha and :fecha2";
            final TypedQuery<Nota> query = (TypedQuery<Nota>)this.em.createQuery(jpql, (Class)Nota.class);
            query.setParameter("codigop", (Object)codigoPersona);
            query.setParameter("codigoc", (Object)codigoCategoria);
            query.setParameter("fecha", fechaConsulta, TemporalType.DATE);
            final Calendar cal = Calendar.getInstance();
            cal.setTime(fechaConsulta);
            cal.add(5, 1);
            query.setParameter("fecha2", cal, TemporalType.DATE);
            lista = (List<Nota>)query.getResultList();
        }
        catch (Exception e) {
            throw e;
        }
        return lista;
    }
}