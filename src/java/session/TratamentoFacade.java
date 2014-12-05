/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Tratamento;
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
public class TratamentoFacade extends AbstractFacade<Tratamento> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TratamentoFacade() {
        super(Tratamento.class);
    }
    
    public Tratamento getTratamentoByReferencia(int id) {
        return (Tratamento) em.createNamedQuery("Tratamento.findByReferencia").setParameter("referencia", id).getSingleResult();
    }
    
    public List<Tratamento> likeByAgente(String search){
        Query query = em.createNamedQuery("Tratamento.likeByAgente");
        search = "%"+search+"%";
        query.setParameter("agente",search);
        List<Tratamento> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Tratamento> likeByTipo(String search){
        Query query = em.createNamedQuery("Tratamento.likeByTipo");
        search = "%"+search+"%";
        query.setParameter("tipo",search);
        List<Tratamento> resultList = query.getResultList();
        return resultList;
    }
    
}
