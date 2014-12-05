/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.PlanoAlimentar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class PlanoAlimentarFacade extends AbstractFacade<PlanoAlimentar> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanoAlimentarFacade() {
        super(PlanoAlimentar.class);
    }
    
    public List consultarTodosPlanos(){
        return em.createNamedQuery("PlanoAlimentar.findAll").getResultList();
    }
    
    public PlanoAlimentar getPlanById(int id) {
        return (PlanoAlimentar) em.createNamedQuery("PlanoAlimentar.findById").setParameter("id", id).getSingleResult();
    }
    
    
}
