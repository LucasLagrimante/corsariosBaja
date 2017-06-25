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
@Entity(name = "Peca")
@Table(name = "peca")
public class Peca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPeca")
    private Integer idPeca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precoCompra")
    private float precoCompra;
    @JoinColumn(name = "FK_tipopeca", referencedColumnName = "idTipopeca")
    @ManyToOne(optional = false)
    private Tipopeca fKtipopeca;

    public Peca(Integer idPeca, int quantidade, String nome, String modelo, float precoCompra, Tipopeca fKtipopeca) {
        this.idPeca = idPeca;
        this.quantidade = quantidade;
        this.nome = nome;
        this.modelo = modelo;
        this.precoCompra = precoCompra;
        this.fKtipopeca = fKtipopeca;
    }

    public Peca() {
    }

    public Peca(Integer idPeca) {
        this.idPeca = idPeca;
    }

    public Peca(Integer idPeca, int quantidade, String nome, String modelo, float precoCompra) {
        this.idPeca = idPeca;
        this.quantidade = quantidade;
        this.nome = nome;
        this.modelo = modelo;
        this.precoCompra = precoCompra;
    }

    public Integer getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Integer idPeca) {
        this.idPeca = idPeca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Tipopeca getFKtipopeca() {
        return fKtipopeca;
    }

    public void setFKtipopeca(Tipopeca fKtipopeca) {
        this.fKtipopeca = fKtipopeca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeca != null ? idPeca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peca)) {
            return false;
        }
        Peca other = (Peca) object;
        if ((this.idPeca == null && other.idPeca != null) || (this.idPeca != null && !this.idPeca.equals(other.idPeca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Peca[ idPeca=" + idPeca + " ]";
    }

}
