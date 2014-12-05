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
@Table(name = "tipo_manutencao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoManutencao.findAll", query = "SELECT t FROM TipoManutencao t"),
    @NamedQuery(name = "TipoManutencao.findById", query = "SELECT t FROM TipoManutencao t WHERE t.id = :id"),
    @NamedQuery(name = "TipoManutencao.findByNome", query = "SELECT t FROM TipoManutencao t WHERE t.nome = :nome"),
    @NamedQuery(name = "TipoManutencao.findByNivel", query = "SELECT t FROM TipoManutencao t WHERE t.nivel = :nivel"),
    @NamedQuery(name = "TipoManutencao.findByFrequencia", query = "SELECT t FROM TipoManutencao t WHERE t.frequencia = :frequencia"),
    @NamedQuery(name = "TipoManutencao.findByDescricao", query = "SELECT t FROM TipoManutencao t WHERE t.descricao = :descricao")})
public class TipoManutencao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "nivel", nullable = false, length = 2)
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "frequencia", nullable = false, length = 9)
    private String frequencia;
    @Size(max = 100)
    @Column(name = "descricao", length = 100)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoManutencao")
    private Collection<ManutencaoEfectuada> manutencaoEfectuadaCollection;

    public TipoManutencao() {
    }

    public TipoManutencao(Integer id) {
        this.id = id;
    }

    public TipoManutencao(Integer id, String nome, String nivel, String frequencia) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.frequencia = frequencia;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<ManutencaoEfectuada> getManutencaoEfectuadaCollection() {
        return manutencaoEfectuadaCollection;
    }

    public void setManutencaoEfectuadaCollection(Collection<ManutencaoEfectuada> manutencaoEfectuadaCollection) {
        this.manutencaoEfectuadaCollection = manutencaoEfectuadaCollection;
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
        if (!(object instanceof TipoManutencao)) {
            return false;
        }
        TipoManutencao other = (TipoManutencao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return id+", "+nome;
    }
     
}
