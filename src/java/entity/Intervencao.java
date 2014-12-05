/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Frederico
 */
@Entity
@Table(name = "intervencao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervencao.findAll", query = "SELECT i FROM Intervencao i"),
    @NamedQuery(name = "Intervencao.findById", query = "SELECT i FROM Intervencao i WHERE i.id = :id"),
    @NamedQuery(name = "Intervencao.findByNome", query = "SELECT i FROM Intervencao i WHERE i.nome = :nome"),
    @NamedQuery(name = "Intervencao.findByDescricao", query = "SELECT i FROM Intervencao i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "Intervencao.findByTipo", query = "SELECT i FROM Intervencao i WHERE i.tipo = :tipo"),
    @NamedQuery(name = "Intervencao.likeByTipo", query = "SELECT i FROM Intervencao i WHERE i.tipo LIKE :tipo"),
    @NamedQuery(name = "Intervencao.findByData", query = "SELECT i FROM Intervencao i WHERE i.data = :data"),
    @NamedQuery(name = "Intervencao.findByEspecie", query = "SELECT i FROM Intervencao i WHERE i.especie = :especie"),
    @NamedQuery(name = "Intervencao.likeByEspecie", query = "SELECT i FROM Intervencao i WHERE i.especie LIKE :especie"),
    @NamedQuery(name = "Intervencao.findByQuantidade", query = "SELECT i FROM Intervencao i WHERE i.quantidade = :quantidade")})
public class Intervencao implements Serializable {
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
    @Size(max = 100)
    @Column(name = "descricao", length = 100)
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tipo", nullable = false, length = 8)
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "especie", nullable = false, length = 50)
    private String especie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    @JoinColumn(name = "idLote", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Lote idLote;
    @JoinColumn(name = "idUtilizador", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;

    public Intervencao() {
    }

    public Intervencao(Integer id) {
        this.id = id;
    }

    public Intervencao(Integer id, String nome, String tipo, Date data, String especie, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.especie = especie;
        this.quantidade = quantidade;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Lote getIdLote() {
        return idLote;
    }

    public void setIdLote(Lote idLote) {
        this.idLote = idLote;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
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
        if (!(object instanceof Intervencao)) {
            return false;
        }
        Intervencao other = (Intervencao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Intervencao[ id=" + id + " ]";
    }
    
}
