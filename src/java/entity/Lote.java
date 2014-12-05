/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frederico
 */
@Entity
@Table(name = "lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l"),
    @NamedQuery(name = "Lote.findById", query = "SELECT l FROM Lote l WHERE l.id = :id"),
    @NamedQuery(name = "Lote.findByData", query = "SELECT l FROM Lote l WHERE l.data = :data"),
    @NamedQuery(name = "Lote.findBySala", query = "SELECT l FROM Lote l WHERE l.sala = :sala"),
    @NamedQuery(name = "Lote.likeBySala", query = "SELECT l FROM Lote l WHERE l.sala LIKE :sala"),
    @NamedQuery(name = "Lote.findByEspecie", query = "SELECT l FROM Lote l WHERE l.especie = :especie"),
    @NamedQuery(name = "Lote.likeByEspecie", query = "SELECT l FROM Lote l WHERE l.especie LIKE :especie"),
    @NamedQuery(name = "Lote.findByNVulgar", query = "SELECT l FROM Lote l WHERE l.nVulgar = :nVulgar"),
    @NamedQuery(name = "Lote.findByGrupoZoologico", query = "SELECT l FROM Lote l WHERE l.grupoZoologico = :grupoZoologico"),
    @NamedQuery(name = "Lote.findByFamilia", query = "SELECT l FROM Lote l WHERE l.familia = :familia"),
    @NamedQuery(name = "Lote.findByOrigem", query = "SELECT l FROM Lote l WHERE l.origem = :origem"),
    @NamedQuery(name = "Lote.likeByOrigem", query = "SELECT l FROM Lote l WHERE l.origem LIKE :origem"),
    @NamedQuery(name = "Lote.findByFornecedor", query = "SELECT l FROM Lote l WHERE l.fornecedor = :fornecedor"),
    @NamedQuery(name = "Lote.findByTitular", query = "SELECT l FROM Lote l WHERE l.titular = :titular"),
    @NamedQuery(name = "Lote.likeByTitular", query = "SELECT l FROM Lote l WHERE l.titular LIKE :titular"),
    @NamedQuery(name = "Lote.findByGrupoInvestigacao", query = "SELECT l FROM Lote l WHERE l.grupoInvestigacao = :grupoInvestigacao"),
    @NamedQuery(name = "Lote.likeByGrupoInvestigacao", query = "SELECT l FROM Lote l WHERE l.grupoInvestigacao LIKE :grupoInvestigacao"),
    @NamedQuery(name = "Lote.findByReferenciaFct", query = "SELECT l FROM Lote l WHERE l.referenciaFct = :referenciaFct"),
    @NamedQuery(name = "Lote.findByNExemplares", query = "SELECT l FROM Lote l WHERE l.nExemplares = :nExemplares"),
    @NamedQuery(name = "Lote.findByPesosMedio", query = "SELECT l FROM Lote l WHERE l.pesosMedio = :pesosMedio"),
    @NamedQuery(name = "Lote.findByComprimentoMedio", query = "SELECT l FROM Lote l WHERE l.comprimentoMedio = :comprimentoMedio"),
    @NamedQuery(name = "Lote.findByNMachos", query = "SELECT l FROM Lote l WHERE l.nMachos = :nMachos"),
    @NamedQuery(name = "Lote.findByNFemeas", query = "SELECT l FROM Lote l WHERE l.nFemeas = :nFemeas"),
    @NamedQuery(name = "Lote.findByTipoContentor", query = "SELECT l FROM Lote l WHERE l.tipoContentor = :tipoContentor"),
    @NamedQuery(name = "Lote.likeByTipoContentor", query = "SELECT l FROM Lote l WHERE l.tipoContentor LIKE :tipoContentor"),
    @NamedQuery(name = "Lote.findByPercentagemO2", query = "SELECT l FROM Lote l WHERE l.percentagemO2 = :percentagemO2"),
    @NamedQuery(name = "Lote.findByProjecto", query = "SELECT l FROM Lote l WHERE l.projecto = :projecto")})
public class Lote implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLote")
    private Collection<Intervencao> intervencaoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sala")
    private double sala;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "especie")
    private String especie;
    @Column(name = "nVulgar")
    private Integer nVulgar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "grupoZoologico")
    private String grupoZoologico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "familia")
    private String familia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "origem")
    private String origem;
    @Size(max = 20)
    @Column(name = "fornecedor")
    private String fornecedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "titular")
    private String titular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "grupoInvestigacao")
    private String grupoInvestigacao;
    @Column(name = "referenciaFct")
    private Integer referenciaFct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nExemplares")
    private int nExemplares;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pesosMedio")
    private Double pesosMedio;
    @Column(name = "comprimentoMedio")
    private Double comprimentoMedio;
    @Column(name = "nMachos")
    private Integer nMachos;
    @Column(name = "nFemeas")
    private Integer nFemeas;
    @Size(max = 20)
    @Column(name = "tipoContentor")
    private String tipoContentor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentagemO2")
    private double percentagemO2;
    @Size(max = 50)
    @Column(name = "projecto")
    private String projecto;
    @JoinColumn(name = "idTanque", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tanque idTanque;

    public Lote() {
    }

    public Lote(Integer id) {
        this.id = id;
    }

    public Lote(Integer id, Date data, double sala, String especie, String grupoZoologico, String familia, String origem, String titular, String grupoInvestigacao, int nExemplares, double percentagemO2) {
        this.id = id;
        this.data = data;
        this.sala = sala;
        this.especie = especie;
        this.grupoZoologico = grupoZoologico;
        this.familia = familia;
        this.origem = origem;
        this.titular = titular;
        this.grupoInvestigacao = grupoInvestigacao;
        this.nExemplares = nExemplares;
        this.percentagemO2 = percentagemO2;
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

    public double getSala() {
        return sala;
    }

    public void setSala(double sala) {
        this.sala = sala;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getNVulgar() {
        return nVulgar;
    }

    public void setNVulgar(Integer nVulgar) {
        this.nVulgar = nVulgar;
    }

    public String getGrupoZoologico() {
        return grupoZoologico;
    }

    public void setGrupoZoologico(String grupoZoologico) {
        this.grupoZoologico = grupoZoologico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getGrupoInvestigacao() {
        return grupoInvestigacao;
    }

    public void setGrupoInvestigacao(String grupoInvestigacao) {
        this.grupoInvestigacao = grupoInvestigacao;
    }

    public Integer getReferenciaFct() {
        return referenciaFct;
    }

    public void setReferenciaFct(Integer referenciaFct) {
        this.referenciaFct = referenciaFct;
    }

    public int getNExemplares() {
        return nExemplares;
    }

    public void setNExemplares(int nExemplares) {
        this.nExemplares = nExemplares;
    }

    public Double getPesosMedio() {
        return pesosMedio;
    }

    public void setPesosMedio(Double pesosMedio) {
        this.pesosMedio = pesosMedio;
    }

    public Double getComprimentoMedio() {
        return comprimentoMedio;
    }

    public void setComprimentoMedio(Double comprimentoMedio) {
        this.comprimentoMedio = comprimentoMedio;
    }

    public Integer getNMachos() {
        return nMachos;
    }

    public void setNMachos(Integer nMachos) {
        this.nMachos = nMachos;
    }

    public Integer getNFemeas() {
        return nFemeas;
    }

    public void setNFemeas(Integer nFemeas) {
        this.nFemeas = nFemeas;
    }

    public String getTipoContentor() {
        return tipoContentor;
    }

    public void setTipoContentor(String tipoContentor) {
        this.tipoContentor = tipoContentor;
    }

    public double getPercentagemO2() {
        return percentagemO2;
    }

    public void setPercentagemO2(double percentagemO2) {
        this.percentagemO2 = percentagemO2;
    }

    public String getProjecto() {
        return projecto;
    }

    public void setProjecto(String projecto) {
        this.projecto = projecto;
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
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + id + "";
    }

    @XmlTransient
    public Collection<Intervencao> getIntervencaoCollection() {
        return intervencaoCollection;
    }

    public void setIntervencaoCollection(Collection<Intervencao> intervencaoCollection) {
        this.intervencaoCollection = intervencaoCollection;
    }
    
}
