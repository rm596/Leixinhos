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
 * @author andre
 */
@Entity
@Table(name = "tanque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tanque.findAll", query = "SELECT t FROM Tanque t"),
    @NamedQuery(name = "Tanque.findById", query = "SELECT t FROM Tanque t WHERE t.id = :id"),
    @NamedQuery(name = "Tanque.findByVolumeUsado", query = "SELECT t FROM Tanque t WHERE t.volumeUsado = :volumeUsado"),
    @NamedQuery(name = "Tanque.findByLocalizacaoFisica", query = "SELECT t FROM Tanque t WHERE t.localizacaoFisica = :localizacaoFisica"),
    @NamedQuery(name = "Tanque.likeByLocalizacaoFisica", query = "SELECT t FROM Tanque t WHERE t.localizacaoFisica LIKE :localizacaoFisica"),
    @NamedQuery(name = "Tanque.findByDataAquisicao", query = "SELECT t FROM Tanque t WHERE t.dataAquisicao = :dataAquisicao"),
    @NamedQuery(name = "Tanque.findByEstadoTanque", query = "SELECT t FROM Tanque t WHERE t.estadoTanque = :estadoTanque"),
    @NamedQuery(name = "Tanque.likeByEstadoTanque", query = "SELECT t FROM Tanque t WHERE t.estadoTanque LIKE :estadoTanque"),
    @NamedQuery(name = "Tanque.findByCaracterizacao", query = "SELECT t FROM Tanque t WHERE t.caracterizacao = :caracterizacao")})
public class Tanque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumeUsado", nullable = false)
    private double volumeUsado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "localizacaoFisica", nullable = false, length = 50)
    private String localizacaoFisica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataAquisicao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAquisicao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estadoTanque", nullable = false, length = 10)
    private String estadoTanque;
    @Size(max = 50)
    @Column(name = "caracterizacao", length = 50)
    private String caracterizacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTanque")
    private Collection<ManutencaoEfectuada> manutencaoEfectuadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTanque")
    private Collection<Lote> loteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTanque")
    private Collection<PlanoAlimentar> planoAlimentarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTanque")
    private Collection<Tratamento> tratamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTanque")
    private Collection<DadosAmbientais> dadosAmbientaisCollection;
    @JoinColumn(name = "idTipo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoTanque idTipo;

    public Tanque() {
    }

    public Tanque(Integer id) {
        this.id = id;
    }

    public Tanque(Integer id, double volumeUsado, String localizacaoFisica, Date dataAquisicao, String estadoTanque) {
        this.id = id;
        this.volumeUsado = volumeUsado;
        this.localizacaoFisica = localizacaoFisica;
        this.dataAquisicao = dataAquisicao;
        this.estadoTanque = estadoTanque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getVolumeUsado() {
        return volumeUsado;
    }

    public void setVolumeUsado(double volumeUsado) {
        this.volumeUsado = volumeUsado;
    }

    public String getLocalizacaoFisica() {
        return localizacaoFisica;
    }

    public void setLocalizacaoFisica(String localizacaoFisica) {
        this.localizacaoFisica = localizacaoFisica;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getEstadoTanque() {
        return estadoTanque;
    }

    public void setEstadoTanque(String estadoTanque) {
        this.estadoTanque = estadoTanque;
    }

    public String getCaracterizacao() {
        return caracterizacao;
    }

    public void setCaracterizacao(String caracterizacao) {
        this.caracterizacao = caracterizacao;
    }

    @XmlTransient
    public Collection<ManutencaoEfectuada> getManutencaoEfectuadaCollection() {
        return manutencaoEfectuadaCollection;
    }

    public void setManutencaoEfectuadaCollection(Collection<ManutencaoEfectuada> manutencaoEfectuadaCollection) {
        this.manutencaoEfectuadaCollection = manutencaoEfectuadaCollection;
    }

    @XmlTransient
    public Collection<Lote> getLoteCollection() {
        return loteCollection;
    }

    public void setLoteCollection(Collection<Lote> loteCollection) {
        this.loteCollection = loteCollection;
    }

    @XmlTransient
    public Collection<PlanoAlimentar> getPlanoAlimentarCollection() {
        return planoAlimentarCollection;
    }

    public void setPlanoAlimentarCollection(Collection<PlanoAlimentar> planoAlimentarCollection) {
        this.planoAlimentarCollection = planoAlimentarCollection;
    }

    @XmlTransient
    public Collection<Tratamento> getTratamentoCollection() {
        return tratamentoCollection;
    }

    public void setTratamentoCollection(Collection<Tratamento> tratamentoCollection) {
        this.tratamentoCollection = tratamentoCollection;
    }

    @XmlTransient
    public Collection<DadosAmbientais> getDadosAmbientaisCollection() {
        return dadosAmbientaisCollection;
    }

    public void setDadosAmbientaisCollection(Collection<DadosAmbientais> dadosAmbientaisCollection) {
        this.dadosAmbientaisCollection = dadosAmbientaisCollection;
    }

    public TipoTanque getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoTanque idTipo) {
        this.idTipo = idTipo;
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
        if (!(object instanceof Tanque)) {
            return false;
        }
        Tanque other = (Tanque) object;
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
