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
@Table(name = "manutencao_efectuada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ManutencaoEfectuada.findAll", query = "SELECT m FROM ManutencaoEfectuada m"),
    @NamedQuery(name = "ManutencaoEfectuada.findById", query = "SELECT m FROM ManutencaoEfectuada m WHERE m.id = :id"),
    @NamedQuery(name = "ManutencaoEfectuada.findByData", query = "SELECT m FROM ManutencaoEfectuada m WHERE m.data = :data"),
    @NamedQuery(name = "ManutencaoEfectuada.findByObservacoes", query = "SELECT m FROM ManutencaoEfectuada m WHERE m.observacoes = :observacoes")})
public class ManutencaoEfectuada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 100)
    @Column(name = "observacoes", length = 100)
    private String observacoes;
    @JoinColumn(name = "idTanque", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tanque idTanque;
    @JoinColumn(name = "tipo_manutencao", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoManutencao tipoManutencao;

    public ManutencaoEfectuada() {
    }

    public ManutencaoEfectuada(Integer id) {
        this.id = id;
    }

    public ManutencaoEfectuada(Integer id, Date data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Tanque getIdTanque() {
        return idTanque;
    }

    public void setIdTanque(Tanque idTanque) {
        this.idTanque = idTanque;
    }

    public TipoManutencao getTipoManutencao() {
        return tipoManutencao;
    }

    public void setTipoManutencao(TipoManutencao tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
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
        if (!(object instanceof ManutencaoEfectuada)) {
            return false;
        }
        ManutencaoEfectuada other = (ManutencaoEfectuada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ManutencaoEfectuada[ id=" + id + " ]";
    }
    
}
