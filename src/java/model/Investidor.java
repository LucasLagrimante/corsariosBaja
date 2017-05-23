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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "investidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investidor.findAll", query = "SELECT i FROM Investidor i"),
    @NamedQuery(name = "Investidor.findByIdInvestidor", query = "SELECT i FROM Investidor i WHERE i.idInvestidor = :idInvestidor"),
    @NamedQuery(name = "Investidor.findByValorDoado", query = "SELECT i FROM Investidor i WHERE i.valorDoado = :valorDoado")})
public class Investidor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInvestidor")
    private Integer idInvestidor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorDoado")
    private float valorDoado;
    @JoinColumn(name = "FK_pessoa", referencedColumnName = "idPessoa")
    @ManyToOne(optional = false)
    private Pessoa fKpessoa;

    public Investidor() {
    }

    public Investidor(Integer idInvestidor) {
        this.idInvestidor = idInvestidor;
    }

    public Investidor(Integer idInvestidor, float valorDoado) {
        this.idInvestidor = idInvestidor;
        this.valorDoado = valorDoado;
    }

    public Integer getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(Integer idInvestidor) {
        this.idInvestidor = idInvestidor;
    }

    public float getValorDoado() {
        return valorDoado;
    }

    public void setValorDoado(float valorDoado) {
        this.valorDoado = valorDoado;
    }

    public Pessoa getFKpessoa() {
        return fKpessoa;
    }

    public void setFKpessoa(Pessoa fKpessoa) {
        this.fKpessoa = fKpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvestidor != null ? idInvestidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investidor)) {
            return false;
        }
        Investidor other = (Investidor) object;
        if ((this.idInvestidor == null && other.idInvestidor != null) || (this.idInvestidor != null && !this.idInvestidor.equals(other.idInvestidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Investidor[ idInvestidor=" + idInvestidor + " ]";
    }
    
}
