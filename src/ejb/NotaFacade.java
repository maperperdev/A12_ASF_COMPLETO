package ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import modelo.Nota;

@Local
public interface NotaFacade extends AbstractFacadeJPA<Nota>
{
    List<Nota> findAll();
    
    List<Nota> buscar(final Integer p0, final Integer p1, final Date p2) throws Exception;
}