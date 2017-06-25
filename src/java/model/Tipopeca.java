/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lucas
 */
@Entity(name = "Tipopeca")
@Table(name = "tipopeca")
public class Tipopeca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipopeca")
    private Integer idTipopeca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nome")
    private String nome;

    public Tipopeca() {
    }

    public Tipopeca(Integer idTipopeca) {
        this.idTipopeca = idTipopeca;
    }

    public Tipopeca(Integer idTipopeca, String nome) {
        this.idTipopeca = idTipopeca;
        this.nome = nome;
    }

    public Integer getIdTipopeca() {
        return idTipopeca;
    }

    public void setIdTipopeca(Integer idTipopeca) {
        this.idTipopeca = idTipopeca;
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
        hash += (idTipopeca != null ? idTipopeca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopeca)) {
            return false;
        }
        Tipopeca other = (Tipopeca) object;
        if ((this.idTipopeca == null && other.idTipopeca != null) || (this.idTipopeca != null && !this.idTipopeca.equals(other.idTipopeca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipopeca[ idTipopeca=" + idTipopeca + " ]";
    }

}
