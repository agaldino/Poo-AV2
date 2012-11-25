/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Alocacao;

/**
 *
 * @author andre
 */
@Stateless
public class AlocacaoFacade extends AbstractFacade<Alocacao> implements AlocacaoFacadeLocal {
    @PersistenceContext(unitName = "POO-AV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlocacaoFacade() {
        super(Alocacao.class);
    }
    
}
