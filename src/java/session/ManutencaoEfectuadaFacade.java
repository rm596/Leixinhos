/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ManutencaoEfectuada;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class ManutencaoEfectuadaFacade extends AbstractFacade<ManutencaoEfectuada> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ManutencaoEfectuadaFacade() {
        super(ManutencaoEfectuada.class);
    }
    
    public ManutencaoEfectuada getManEfectById(int id) {
        return (ManutencaoEfectuada) em.createNamedQuery("ManutencaoEfectuada.findById").setParameter("id", id).getSingleResult();
    }
    
}
