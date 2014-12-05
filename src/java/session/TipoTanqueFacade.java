/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TipoTanque;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class TipoTanqueFacade extends AbstractFacade<TipoTanque> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTanqueFacade() {
        super(TipoTanque.class);
    }
    
     public TipoTanque gettipoTanqueById(int id) {
        return (TipoTanque) em.createNamedQuery("TipoTanque.findById").setParameter("id", id).getSingleResult();
    }
    
    
}
