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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "dados_ambientais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DadosAmbientais.findAll", query = "SELECT d FROM DadosAmbientais d"),
    @NamedQuery(name = "DadosAmbientais.findById", query = "SELECT d FROM DadosAmbientais d WHERE d.id = :id"),
    @NamedQuery(name = "DadosAmbientais.findByTemperatura", query = "SELECT d FROM DadosAmbientais d WHERE d.temperatura = :temperatura"),
    @NamedQuery(name = "DadosAmbientais.findBySalinidadeAgua", query = "SELECT d FROM DadosAmbientais d WHERE d.salinidadeAgua = :salinidadeAgua"),
    @NamedQuery(name = "DadosAmbientais.findByOxigenio", query = "SELECT d FROM DadosAmbientais d WHERE d.oxigenio = :oxigenio"),
    @NamedQuery(name = "DadosAmbientais.findByData", query = "SELECT d FROM DadosAmbientais d WHERE d.data = :data")})
public class DadosAmbientais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temperatura", nullable = false)
    private double temperatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salinidadeAgua", nullable = false)
    private double salinidadeAgua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oxigenio", nullable = false)
    private double oxigenio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "idTanque", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tanque idTanque;

    public DadosAmbientais() {
    }

    public DadosAmbientais(Integer id) {
        this.id = id;
    }

    public DadosAmbientais(Integer id, double temperatura, double salinidadeAgua, double oxigenio, Date data) {
        this.id = id;
        this.temperatura = temperatura;
        this.salinidadeAgua = salinidadeAgua;
        this.oxigenio = oxigenio;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getSalinidadeAgua() {
        return salinidadeAgua;
    }

    public void setSalinidadeAgua(double salinidadeAgua) {
        this.salinidadeAgua = salinidadeAgua;
    }

    public double getOxigenio() {
        return oxigenio;
    }

    public void setOxigenio(double oxigenio) {
        this.oxigenio = oxigenio;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        if (!(object instanceof DadosAmbientais)) {
            return false;
        }
        DadosAmbientais other = (DadosAmbientais) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DadosAmbientais[ id=" + id + " ]";
    }
    
}
