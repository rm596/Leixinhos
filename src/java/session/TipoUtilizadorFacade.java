/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TipoUtilizador;
import entity.Utilizador;
import java.util.ArrayList;
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
public class TipoUtilizadorFacade extends AbstractFacade<TipoUtilizador> {
    @PersistenceContext(unitName = "leixinhosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoUtilizadorFacade() {
        super(TipoUtilizador.class);
    }
    
    public Object procurarID(int id){
        return (TipoUtilizador) em.createNamedQuery("TipoUtilizador.findById").setParameter("id", id).getSingleResult();
    }
    
    public TipoUtilizador likebynome(String nome){
        Query query = em.createNamedQuery("TipoUtilizador.likeByNome");
        nome = "%"+nome+"%";
        query.setParameter("nome",nome);
        TipoUtilizador typeuser = (TipoUtilizador) query.getSingleResult();
        return typeuser;
    }
    
    public List<Utilizador> geTypeById(int id){
        List<Utilizador> allusers = em.createNamedQuery("Utilizador.findAll").getResultList();
        List<Utilizador> result = new ArrayList<Utilizador>();
        for (Utilizador utilizador : allusers) {
            if(utilizador.getTipoUtilizador().getId() == id){
                result.add(utilizador);
            }
        }
        return result;
    }
    
}
