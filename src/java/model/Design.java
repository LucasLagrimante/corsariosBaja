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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Design implements Serializable {
    @Id
    @Column(name = "idDesign")
    private Integer idDesign;
    private String caminhoImagem;
    @ManyToOne
    @JoinColumn(name = "FK_automovel", referencedColumnName = "idAutomovel")
    private Automovel fKautomovel;

    public Design() {
    }

    public Design(Integer idDesign) {
        this.idDesign = idDesign;
    }

    public Design(Integer idDesign, String caminhoImagem, Automovel fKautomovel) {
        this.idDesign = idDesign;
        this.caminhoImagem = caminhoImagem;
        this.fKautomovel = fKautomovel;
    }

    public Design(Integer idDesign, String caminhoImagem) {
        this.idDesign = idDesign;
        this.caminhoImagem = caminhoImagem;
    }

    public Integer getIdDesign() {
        return idDesign;
    }

    public void setIdDesign(Integer idDesign) {
        this.idDesign = idDesign;
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
        hash += (idDesign != null ? idDesign.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Design)) {
            return false;
        }
        Design other = (Design) object;
        if ((this.idDesign == null && other.idDesign != null) || (this.idDesign != null && !this.idDesign.equals(other.idDesign))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Design[ idDesign=" + idDesign + " ]";
    }

}
