package ejb;

import javax.ejb.Local;
import modelo.Persona;

@Local
public interface PersonaFacade extends AbstractFacadeJPA<Persona>
{
}