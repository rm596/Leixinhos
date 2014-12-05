/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Tanque;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
@Stateless
public class TanqueFacade extends AbstractFacade<Tanque> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TanqueFacade() {
        super(Tanque.class);
    }
    
    public List<Tanque> likeTanqueByLocal(String search){
        Query query = em.createNamedQuery("Tanque.likeByLocalizacaoFisica");
        search = "%"+search+"%";
        query.setParameter("localizacaoFisica",search);
        List<Tanque> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Tanque> likeTanqueByeEstado(String search){
        Query query = em.createNamedQuery("Tanque.likeByEstadoTanque");
        search = "%"+search+"%";
        query.setParameter("estadoTanque",search);
        List<Tanque> resultList = query.getResultList();
        return resultList;
    }
    
    public Tanque getTanqueById(int id) {
        return (Tanque) em.createNamedQuery("Tanque.findById").setParameter("id", id).getSingleResult();
    }
}
