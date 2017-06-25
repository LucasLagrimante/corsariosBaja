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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity(name = "Tipopista")
@Table(name = "tipopista")
public class Tipopista implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKtipopista")
    private Collection<Desempenhoteste> desempenhotesteCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipopista")
    private Integer idTipopista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nome")
    private String nome;

    public Tipopista() {
    }

    public Tipopista(Integer idTipopista) {
        this.idTipopista = idTipopista;
    }

    public Tipopista(Integer idTipopista, String nome) {
        this.idTipopista = idTipopista;
        this.nome = nome;
    }

    public Integer getIdTipopista() {
        return idTipopista;
    }

    public void setIdTipopista(Integer idTipopista) {
        this.idTipopista = idTipopista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipopista != null ? idTipopista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopista)) {
            return false;
        }
        Tipopista other = (Tipopista) object;
        if ((this.idTipopista == null && other.idTipopista != null) || (this.idTipopista != null && !this.idTipopista.equals(other.idTipopista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipopista[ idTipopista=" + idTipopista + " ]";
    }

    @XmlTransient
    public Collection<Desempenhoteste> getDesempenhotesteCollection() {
        return desempenhotesteCollection;
    }

    public void setDesempenhotesteCollection(Collection<Desempenhoteste> desempenhotesteCollection) {
        this.desempenhotesteCollection = desempenhotesteCollection;
    }

}
