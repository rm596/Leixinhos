/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tipo_utilizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUtilizador.findAll", query = "SELECT t FROM TipoUtilizador t"),
    @NamedQuery(name = "TipoUtilizador.findById", query = "SELECT t FROM TipoUtilizador t WHERE t.id = :id"),
    @NamedQuery(name = "TipoUtilizador.findByNome", query = "SELECT t FROM TipoUtilizador t WHERE t.nome = :nome"),
    @NamedQuery(name = "TipoUtilizador.likeByNome", query = "SELECT t FROM TipoUtilizador t WHERE t.nome LIKE :nome"),
})
public class TipoUtilizador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUtilizador")
    private Collection<Utilizador> utilizadorCollection;

    public TipoUtilizador() {
    }

    public TipoUtilizador(Integer id) {
        this.id = id;
    }

    public TipoUtilizador(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Utilizador> getUtilizadorCollection() {
        return utilizadorCollection;
    }

    public void setUtilizadorCollection(Collection<Utilizador> utilizadorCollection) {
        this.utilizadorCollection = utilizadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUtilizador)) {
            return false;
        }
        TipoUtilizador other = (TipoUtilizador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
