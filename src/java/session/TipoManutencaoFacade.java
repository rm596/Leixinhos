/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TipoManutencao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class TipoManutencaoFacade extends AbstractFacade<TipoManutencao> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoManutencaoFacade() {
        super(TipoManutencao.class);
    }
    
     public TipoManutencao getTipoManutencaoById(int id) {
        return (TipoManutencao) em.createNamedQuery("TipoManutencao.findById").setParameter("id", id).getSingleResult();
    }
    
}
