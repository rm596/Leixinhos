/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ClasseTanque;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class ClasseTanqueFacade extends AbstractFacade<ClasseTanque> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClasseTanqueFacade() {
        super(ClasseTanque.class);
    }
    
    public ClasseTanque getClasseTanqueById(int id) {
        return (ClasseTanque) em.createNamedQuery("ClasseTanque.findById").setParameter("id", id).getSingleResult();
    }
    
}
