/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Aluno
 */
@Entity
@Table(name = "automovel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automovel.findAll", query = "SELECT a FROM Automovel a"),
    @NamedQuery(name = "Automovel.findByIdAutomovel", query = "SELECT a FROM Automovel a WHERE a.idAutomovel = :idAutomovel"),
    @NamedQuery(name = "Automovel.findByCor", query = "SELECT a FROM Automovel a WHERE a.cor = :cor"),
    @NamedQuery(name = "Automovel.findByNome", query = "SELECT a FROM Automovel a WHERE a.nome = :nome"),
    @NamedQuery(name = "Automovel.findByDataTerminoProjeto", query = "SELECT a FROM Automovel a WHERE a.dataTerminoProjeto = :dataTerminoProjeto"),
    @NamedQuery(name = "Automovel.findByPesoCarro", query = "SELECT a FROM Automovel a WHERE a.pesoCarro = :pesoCarro"),
    @NamedQuery(name = "Automovel.findByPesoChassi", query = "SELECT a FROM Automovel a WHERE a.pesoChassi = :pesoChassi"),
    @NamedQuery(name = "Automovel.findByCustoTotal", query = "SELECT a FROM Automovel a WHERE a.custoTotal = :custoTotal")})
public class Automovel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAutomovel")
    private Integer idAutomovel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cor")
    private String cor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "dataTerminoProjeto")
    private String dataTerminoProjeto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pesoCarro")
    private float pesoCarro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pesoChassi")
    private float pesoChassi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "custoTotal")
    private float custoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKautomovel")
    private Collection<Desempenho> desempenhoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKautomovel")
    private Collection<Desempenhoteste> desempenhotesteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKautomovel")
    private Collection<Arquitetura> arquiteturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKautomovel")
    private Collection<Design> designCollection;

    public Automovel() {
    }

    public Automovel(Integer idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public Automovel(Integer idAutomovel, String cor, String nome, String dataTerminoProjeto, float pesoCarro, float pesoChassi, float custoTotal) {
        this.idAutomovel = idAutomovel;
        this.cor = cor;
        this.nome = nome;
        this.dataTerminoProjeto = dataTerminoProjeto;
        this.pesoCarro = pesoCarro;
        this.pesoChassi = pesoChassi;
        this.custoTotal = custoTotal;
    }

    public Integer getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Integer idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataTerminoProjeto() {
        return dataTerminoProjeto;
    }

    public void setDataTerminoProjeto(String dataTerminoProjeto) {
        this.dataTerminoProjeto = dataTerminoProjeto;
    }

    public float getPesoCarro() {
        return pesoCarro;
    }

    public void setPesoCarro(float pesoCarro) {
        this.pesoCarro = pesoCarro;
    }

    public float getPesoChassi() {
        return pesoChassi;
    }

    public void setPesoChassi(float pesoChassi) {
        this.pesoChassi = pesoChassi;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    @XmlTransient
    public Collection<Desempenho> getDesempenhoCollection() {
        return desempenhoCollection;
    }

    public void setDesempenhoCollection(Collection<Desempenho> desempenhoCollection) {
        this.desempenhoCollection = desempenhoCollection;
    }

    @XmlTransient
    public Collection<Desempenhoteste> getDesempenhotesteCollection() {
        return desempenhotesteCollection;
    }

    public void setDesempenhotesteCollection(Collection<Desempenhoteste> desempenhotesteCollection) {
        this.desempenhotesteCollection = desempenhotesteCollection;
    }

    @XmlTransient
    public Collection<Arquitetura> getArquiteturaCollection() {
        return arquiteturaCollection;
    }

    public void setArquiteturaCollection(Collection<Arquitetura> arquiteturaCollection) {
        this.arquiteturaCollection = arquiteturaCollection;
    }

    @XmlTransient
    public Collection<Design> getDesignCollection() {
        return designCollection;
    }

    public void setDesignCollection(Collection<Design> designCollection) {
        this.designCollection = designCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutomovel != null ? idAutomovel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovel)) {
            return false;
        }
        Automovel other = (Automovel) object;
        if ((this.idAutomovel == null && other.idAutomovel != null) || (this.idAutomovel != null && !this.idAutomovel.equals(other.idAutomovel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Automovel[ idAutomovel=" + idAutomovel + " ]";
    }
    
}
