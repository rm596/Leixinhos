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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tipo_tanque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTanque.findAll", query = "SELECT t FROM TipoTanque t"),
    @NamedQuery(name = "TipoTanque.findById", query = "SELECT t FROM TipoTanque t WHERE t.id = :id"),
    @NamedQuery(name = "TipoTanque.findByNome", query = "SELECT t FROM TipoTanque t WHERE t.nome = :nome"),
    @NamedQuery(name = "TipoTanque.findByVolumeTotal", query = "SELECT t FROM TipoTanque t WHERE t.volumeTotal = :volumeTotal"),
    @NamedQuery(name = "TipoTanque.findByAlturaAgua", query = "SELECT t FROM TipoTanque t WHERE t.alturaAgua = :alturaAgua"),
    @NamedQuery(name = "TipoTanque.findByTaxaExterior", query = "SELECT t FROM TipoTanque t WHERE t.taxaExterior = :taxaExterior"),
    @NamedQuery(name = "TipoTanque.findByTaxaInterior", query = "SELECT t FROM TipoTanque t WHERE t.taxaInterior = :taxaInterior"),
    @NamedQuery(name = "TipoTanque.findByTaxaIntExc", query = "SELECT t FROM TipoTanque t WHERE t.taxaIntExc = :taxaIntExc"),
    @NamedQuery(name = "TipoTanque.findByTaxaIntSExc", query = "SELECT t FROM TipoTanque t WHERE t.taxaIntSExc = :taxaIntSExc")})
public class TipoTanque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "nome", nullable = false, length = 5)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumeTotal", nullable = false)
    private double volumeTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alturaAgua", nullable = false)
    private double alturaAgua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxaExterior", nullable = false)
    private double taxaExterior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxaInterior", nullable = false)
    private double taxaInterior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxaIntExc", nullable = false)
    private double taxaIntExc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxaIntSExc", nullable = false)
    private double taxaIntSExc;
    @JoinColumn(name = "idClasse", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClasseTanque idClasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private Collection<Tanque> tanqueCollection;

    public TipoTanque() {
    }

    public TipoTanque(Integer id) {
        this.id = id;
    }

    public TipoTanque(Integer id, String nome, double volumeTotal, double alturaAgua, double taxaExterior, double taxaInterior, double taxaIntExc, double taxaIntSExc) {
        this.id = id;
        this.nome = nome;
        this.volumeTotal = volumeTotal;
        this.alturaAgua = alturaAgua;
        this.taxaExterior = taxaExterior;
        this.taxaInterior = taxaInterior;
        this.taxaIntExc = taxaIntExc;
        this.taxaIntSExc = taxaIntSExc;
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

    public double getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(double volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    public double getAlturaAgua() {
        return alturaAgua;
    }

    public void setAlturaAgua(double alturaAgua) {
        this.alturaAgua = alturaAgua;
    }

    public double getTaxaExterior() {
        return taxaExterior;
    }

    public void setTaxaExterior(double taxaExterior) {
        this.taxaExterior = taxaExterior;
    }

    public double getTaxaInterior() {
        return taxaInterior;
    }

    public void setTaxaInterior(double taxaInterior) {
        this.taxaInterior = taxaInterior;
    }

    public double getTaxaIntExc() {
        return taxaIntExc;
    }

    public void setTaxaIntExc(double taxaIntExc) {
        this.taxaIntExc = taxaIntExc;
    }

    public double getTaxaIntSExc() {
        return taxaIntSExc;
    }

    public void setTaxaIntSExc(double taxaIntSExc) {
        this.taxaIntSExc = taxaIntSExc;
    }

    public ClasseTanque getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(ClasseTanque idClasse) {
        this.idClasse = idClasse;
    }

    @XmlTransient
    public Collection<Tanque> getTanqueCollection() {
        return tanqueCollection;
    }

    public void setTanqueCollection(Collection<Tanque> tanqueCollection) {
        this.tanqueCollection = tanqueCollection;
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
        if (!(object instanceof TipoTanque)) {
            return false;
        }
        TipoTanque other = (TipoTanque) object;
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
