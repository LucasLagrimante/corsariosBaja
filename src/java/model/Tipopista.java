/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author lucas
 */
@Entity
public class Tipopista implements Serializable {
    @Id
    @Column(name = "idTipopista")
    private Integer idTipopista;
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

}
