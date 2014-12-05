/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.DadosAmbientais;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class DadosAmbientaisFacade extends AbstractFacade<DadosAmbientais> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DadosAmbientaisFacade() {
        super(DadosAmbientais.class);
    }
    
    public DadosAmbientais getDadosAmbientaisById(int id) {
        return (DadosAmbientais) em.createNamedQuery("DadosAmbientais.findById").setParameter("id", id).getSingleResult();
    }
    
}
