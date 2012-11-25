/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Projeto;

/**
 *
 * @author andre
 */
@Stateless
public class ProjetoFacade extends AbstractFacade<Projeto> implements ProjetoFacadeLocal {
    @PersistenceContext(unitName = "POO-AV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjetoFacade() {
        super(Projeto.class);
    }
    
}
