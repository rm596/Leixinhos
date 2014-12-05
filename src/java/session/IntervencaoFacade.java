/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Intervencao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Frederico
 */
@Stateless
public class IntervencaoFacade extends AbstractFacade<Intervencao> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IntervencaoFacade() {
        super(Intervencao.class);
    }
    
    public List<Intervencao> likeByTipo(String search){
        Query query = em.createNamedQuery("Intervencao.likeByTipo");
        search = "%"+search+"%";
        query.setParameter("tipo",search);
        List<Intervencao> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Intervencao> likeByEspecie(String search){
        Query query = em.createNamedQuery("Intervencao.likeByEspecie");
        search = "%"+search+"%";
        query.setParameter("especie",search);
        List<Intervencao> resultList = query.getResultList();
        return resultList;
    }
    
    public Intervencao getIntervencaoById(int id) {
        return (Intervencao) em.createNamedQuery("Intervencao.findById").setParameter("id", id).getSingleResult();
    }
    
}
