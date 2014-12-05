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
@Table(name = "classe_tanque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClasseTanque.findAll", query = "SELECT c FROM ClasseTanque c"),
    @NamedQuery(name = "ClasseTanque.findById", query = "SELECT c FROM ClasseTanque c WHERE c.id = :id"),
    @NamedQuery(name = "ClasseTanque.findByNome", query = "SELECT c FROM ClasseTanque c WHERE c.nome = :nome"),
    @NamedQuery(name = "ClasseTanque.findByDescricao", query = "SELECT c FROM ClasseTanque c WHERE c.descricao = :descricao")})
public class ClasseTanque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "nome", nullable = false, length = 3)
    private String nome;
    @Size(max = 50)
    @Column(name = "descricao", length = 50)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse")
    private Collection<TipoTanque> tipoTanqueCollection;

    public ClasseTanque() {
    }

    public ClasseTanque(Integer id) {
        this.id = id;
    }

    public ClasseTanque(Integer id, String nome) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<TipoTanque> getTipoTanqueCollection() {
        return tipoTanqueCollection;
    }

    public void setTipoTanqueCollection(Collection<TipoTanque> tipoTanqueCollection) {
        this.tipoTanqueCollection = tipoTanqueCollection;
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
        if (!(object instanceof ClasseTanque)) {
            return false;
        }
        ClasseTanque other = (ClasseTanque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + id + "";
    }
    
}
