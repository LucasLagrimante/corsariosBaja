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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lucas
 */
@Entity(name = "Arquitetura")
@Table(name = "arquitetura")
public class Arquitetura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArquitetura")
    private Integer idArquitetura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "caminhoImagem")
    private String caminhoImagem;
    @JoinColumn(name = "FK_automovel", referencedColumnName = "idAutomovel")
    @ManyToOne
    private Automovel fKautomovel;

    public Arquitetura() {
    }

    public Arquitetura(Integer idArquitetura) {
        this.idArquitetura = idArquitetura;
    }

    public Arquitetura(Integer idArquitetura, String caminhoImagem, Automovel fKautomovel) {
        this.idArquitetura = idArquitetura;
        this.caminhoImagem = caminhoImagem;
        this.fKautomovel = fKautomovel;
    }

    public Integer getIdArquitetura() {
        return idArquitetura;
    }

    public void setIdArquitetura(Integer idArquitetura) {
        this.idArquitetura = idArquitetura;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Automovel getFKautomovel() {
        return fKautomovel;
    }

    public void setFKautomovel(Automovel fKautomovel) {
        this.fKautomovel = fKautomovel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArquitetura != null ? idArquitetura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquitetura)) {
            return false;
        }
        Arquitetura other = (Arquitetura) object;
        if ((this.idArquitetura == null && other.idArquitetura != null) || (this.idArquitetura != null && !this.idArquitetura.equals(other.idArquitetura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Arquitetura[ idArquitetura=" + idArquitetura + " ]";
    }

}
