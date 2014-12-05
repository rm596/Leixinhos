/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Lote;
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
public class LoteFacade extends AbstractFacade<Lote> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoteFacade() {
        super(Lote.class);
    }
    
    public List<Lote> likeByEspecie(String search){
        Query query = em.createNamedQuery("Lote.likeByEspecie");
        search = "%"+search+"%";
        query.setParameter("especie",search);
        List<Lote> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Lote> likeByTitular(String search){
        Query query = em.createNamedQuery("Lote.likeByTitular");
        search = "%"+search+"%";
        query.setParameter("titular",search);
        List<Lote> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Lote> likeByTipoContentor(String search){
        Query query = em.createNamedQuery("Lote.likeByTipoContentor");
        search = "%"+search+"%";
        query.setParameter("tipoContentor",search);
        List<Lote> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Lote> likeBySala(double search){
        Query query = em.createNamedQuery("Lote.findBySala");
        query.setParameter("sala",search);
        List<Lote> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Lote> likeByGrupoInvestigacao(String search){
        Query query = em.createNamedQuery("Lote.likeByGrupoInvestigacao");
        search = "%"+search+"%";
        query.setParameter("grupoInvestigacao",search);
        List<Lote> resultList = query.getResultList();
        return resultList;
    }
    
    public List<Lote> likeByOrigem(String search){
        Query query = em.createNamedQuery("Lote.likeByOrigem");
        search = "%"+search+"%";
        query.setParameter("origem",search);
        List<Lote> resultList = query.getResultList();
        return resultList;
    }
    
     public Lote getLoteById(int id) {
        return (Lote) em.createNamedQuery("Lote.findById").setParameter("id", id).getSingleResult();
    }
}
