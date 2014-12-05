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
@Table(name = "tratamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamento.findAll", query = "SELECT t FROM Tratamento t"),
    @NamedQuery(name = "Tratamento.findByReferencia", query = "SELECT t FROM Tratamento t WHERE t.referencia = :referencia"),
    @NamedQuery(name = "Tratamento.findByAgente", query = "SELECT t FROM Tratamento t WHERE t.agente = :agente"),
    @NamedQuery(name = "Tratamento.likeByAgente", query = "SELECT t FROM Tratamento t WHERE t.agente LIKE :agente"),
    @NamedQuery(name = "Tratamento.findByTemperatura", query = "SELECT t FROM Tratamento t WHERE t.temperatura = :temperatura"),
    @NamedQuery(name = "Tratamento.findByTipo", query = "SELECT t FROM Tratamento t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tratamento.likeByTipo", query = "SELECT t FROM Tratamento t WHERE t.tipo LIKE :tipo"),
    @NamedQuery(name = "Tratamento.findByDuracao", query = "SELECT t FROM Tratamento t WHERE t.duracao = :duracao"),
    @NamedQuery(name = "Tratamento.findByDose", query = "SELECT t FROM Tratamento t WHERE t.dose = :dose"),
    @NamedQuery(name = "Tratamento.findByData", query = "SELECT t FROM Tratamento t WHERE t.data = :data")})
public class Tratamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "referencia", nullable = false)
    private Integer referencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "agente", nullable = false, length = 50)
    private String agente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temperatura", nullable = false)
    private double temperatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "tipo", nullable = false, length = 12)
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracao", nullable = false)
    private double duracao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dose", nullable = false)
    private double dose;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "idTanque", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tanque idTanque;

    public Tratamento() {
    }

    public Tratamento(Integer referencia) {
        this.referencia = referencia;
    }

    public Tratamento(Integer referencia, String agente, double temperatura, String tipo, double duracao, double dose, Date data) {
        this.referencia = referencia;
        this.agente = agente;
        this.temperatura = temperatura;
        this.tipo = tipo;
        this.duracao = duracao;
        this.dose = dose;
        this.data = data;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
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
        hash += (referencia != null ? referencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamento)) {
            return false;
        }
        Tratamento other = (Tratamento) object;
        if ((this.referencia == null && other.referencia != null) || (this.referencia != null && !this.referencia.equals(other.referencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tratamento[ referencia=" + referencia + " ]";
    }
    
}
