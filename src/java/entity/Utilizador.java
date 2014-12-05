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
@Table(name = "utilizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u"),
    @NamedQuery(name = "Utilizador.findById", query = "SELECT u FROM Utilizador u WHERE u.id = :id"),
    @NamedQuery(name = "Utilizador.findByNome", query = "SELECT u FROM Utilizador u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utilizador.likeByNome", query = "SELECT u FROM Utilizador u WHERE u.nome LIKE :nome"),
    @NamedQuery(name = "Utilizador.findByEmail", query = "SELECT u FROM Utilizador u WHERE u.email = :email"),
    @NamedQuery(name = "Utilizador.likeByEmail", query = "SELECT u FROM Utilizador u WHERE u.email LIKE :email"),
    @NamedQuery(name = "Utilizador.findByMorada", query = "SELECT u FROM Utilizador u WHERE u.morada = :morada"),
    @NamedQuery(name = "Utilizador.findByTelemovel", query = "SELECT u FROM Utilizador u WHERE u.telemovel = :telemovel"),
    @NamedQuery(name = "Utilizador.findByUsername", query = "SELECT u FROM Utilizador u WHERE u.username = :username"),
    @NamedQuery(name = "Utilizador.likeByUsername", query = "SELECT u FROM Utilizador u WHERE u.username LIKE :username"),
    @NamedQuery(name = "Utilizador.findByPassword", query = "SELECT u FROM Utilizador u WHERE u.password = :password"),
    @NamedQuery(name = "Utilizador.findByGrupoPro", query = "SELECT u FROM Utilizador u WHERE u.grupoPro = :grupoPro"),
    @NamedQuery(name = "Utilizador.findByDataInicio", query = "SELECT u FROM Utilizador u WHERE u.dataInicio = :dataInicio"),
    @NamedQuery(name = "Utilizador.findByDataFim", query = "SELECT u FROM Utilizador u WHERE u.dataFim = :dataFim"),
    @NamedQuery(name = "Utilizador.updateNormal", query="UPDATE Utilizador u SET u.nome = :nome, u.morada = :morada, u.grupoPro = :grupoPro, u.username = :username, u.email = :email, u.telemovel = :telemovel WHERE u.id = :id"),
    @NamedQuery(name = "Utilizador.updateUsername", query="UPDATE Utilizador u SET u.username = :username WHERE u.id = :id"),
    @NamedQuery(name = "Utilizador.updateUserType", query="UPDATE Utilizador u SET u.tipoUtilizador = :tipoUtilizador WHERE u.id = :id"),
    @NamedQuery(name = "Utilizador.updadeEmail", query="UPDATE Utilizador u SET u.email = :email WHERE u.id = :id"),
    @NamedQuery(name = "Utilizador.updadePassword", query="UPDATE Utilizador u SET u.password = :password WHERE u.id = :id"),
    @NamedQuery(name = "Utilizador.deleteById", query="DELETE FROM Utilizador u WHERE u.id = :id")
})
public class Utilizador implements Serializable {
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Size(max = 50)
    @Column(name = "morada", length = 50)
    private String morada;
    @Column(name = "telemovel")
    private Integer telemovel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "grupoPro", nullable = false, length = 50)
    private String grupoPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataInicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataFim", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private Collection<Intervencao> intervencaoCollection;
    @JoinColumn(name = "tipoUtilizador", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoUtilizador tipoUtilizador;

    public Utilizador() {
    }

    public Utilizador(Integer id) {
        this.id = id;
    }

    public Utilizador(Integer id, String nome, String email, String username, String password, String grupoPro, Date dataInicio, Date dataFim) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.grupoPro = grupoPro;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public Integer getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(Integer telemovel) {
        this.telemovel = telemovel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrupoPro() {
        return grupoPro;
    }

    public void setGrupoPro(String grupoPro) {
        this.grupoPro = grupoPro;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @XmlTransient
    public Collection<Intervencao> getIntervencaoCollection() {
        return intervencaoCollection;
    }

    public void setIntervencaoCollection(Collection<Intervencao> intervencaoCollection) {
        this.intervencaoCollection = intervencaoCollection;
    }

    public TipoUtilizador getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
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
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
