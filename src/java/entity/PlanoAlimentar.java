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
 * @author andre
 */
@Entity
@Table(name = "plano_alimentar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanoAlimentar.findAll", query = "SELECT p FROM PlanoAlimentar p"),
    @NamedQuery(name = "PlanoAlimentar.findById", query = "SELECT p FROM PlanoAlimentar p WHERE p.id = :id"),
    @NamedQuery(name = "PlanoAlimentar.findByTipoAlimentacao", query = "SELECT p FROM PlanoAlimentar p WHERE p.tipoAlimentacao = :tipoAlimentacao"),
    @NamedQuery(name = "PlanoAlimentar.findByData", query = "SELECT p FROM PlanoAlimentar p WHERE p.data = :data"),
    @NamedQuery(name = "PlanoAlimentar.findByQuantidade", query = "SELECT p FROM PlanoAlimentar p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "PlanoAlimentar.findByFormaDistribuicao", query = "SELECT p FROM PlanoAlimentar p WHERE p.formaDistribuicao = :formaDistribuicao"),
    @NamedQuery(name = "PlanoAlimentar.findByNVezesDia", query = "SELECT p FROM PlanoAlimentar p WHERE p.nVezesDia = :nVezesDia")})
public class PlanoAlimentar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoAlimentacao", nullable = false, length = 20)
    private String tipoAlimentacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade", nullable = false)
    private double quantidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "formaDistribuicao", nullable = false, length = 50)
    private String formaDistribuicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nVezesDia", nullable = false)
    private int nVezesDia;
    @JoinColumn(name = "idTanque", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tanque idTanque;

    public PlanoAlimentar() {
    }

    public PlanoAlimentar(Integer id) {
        this.id = id;
    }

    public PlanoAlimentar(Integer id, String tipoAlimentacao, Date data, double quantidade, String formaDistribuicao, int nVezesDia) {
        this.id = id;
        this.tipoAlimentacao = tipoAlimentacao;
        this.data = data;
        this.quantidade = quantidade;
        this.formaDistribuicao = formaDistribuicao;
        this.nVezesDia = nVezesDia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoAlimentacao() {
        return tipoAlimentacao;
    }

    public void setTipoAlimentacao(String tipoAlimentacao) {
        this.tipoAlimentacao = tipoAlimentacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getFormaDistribuicao() {
        return formaDistribuicao;
    }

    public void setFormaDistribuicao(String formaDistribuicao) {
        this.formaDistribuicao = formaDistribuicao;
    }

    public int getNVezesDia() {
        return nVezesDia;
    }

    public void setNVezesDia(int nVezesDia) {
        this.nVezesDia = nVezesDia;
    }

    public Tanque getIdTanque() {
        return idTanque;
    }

    public void setIdTanque(Tanque idTanque) {
        this.idTanque = idTanque;
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
        if (!(object instanceof PlanoAlimentar)) {
            return false;
        }
        PlanoAlimentar other = (PlanoAlimentar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PlanoAlimentar[ id=" + id + " ]";
    }
    
}
