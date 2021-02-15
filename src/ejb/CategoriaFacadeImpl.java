package ejb;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import modelo.Categoria;

/**
 * Session Bean implementation class CategoriaFacadeImpl
 */
@Stateless
public class CategoriaFacadeImpl extends AbstractFacadeJPAImpl<Categoria> implements CategoriaFacade {
	
	@PersistenceContext(unitName = "Persistencia")
	private EntityManager em;

	public CategoriaFacadeImpl() {
		super(Categoria.class);
	}

	@Override
	protected EntityManager getEm() {
		// TODO Auto-generated method stub
		return em;
	}

	@PreDestroy
	public void destruct() {
		getEm().close();
	}

	public List<Categoria> findAll() {
		CriteriaQuery<Categoria> cq = getEm().getCriteriaBuilder().createQuery(Categoria.class);
		cq.select(cq.from(Categoria.class));
		return getEm().createQuery(cq).getResultList();
	}
	
}