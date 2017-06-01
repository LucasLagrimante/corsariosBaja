/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PecaDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "peca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peca.findAll", query = "SELECT p FROM Peca p")
    ,
    @NamedQuery(name = "Peca.findByIdPeca", query = "SELECT p FROM Peca p WHERE p.idPeca = :idPeca")
    ,
    @NamedQuery(name = "Peca.findByQuantidade", query = "SELECT p FROM Peca p WHERE p.quantidade = :quantidade")
    ,
    @NamedQuery(name = "Peca.findByNome", query = "SELECT p FROM Peca p WHERE p.nome = :nome")
    ,
    @NamedQuery(name = "Peca.findByModelo", query = "SELECT p FROM Peca p WHERE p.modelo = :modelo")
    ,
    @NamedQuery(name = "Peca.findByPrecoCompra", query = "SELECT p FROM Peca p WHERE p.precoCompra = :precoCompra")})
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

    public Peca() {
    }

    public Peca(Integer idPeca) {
        this.idPeca = idPeca;
    }

    public Peca(Integer idPeca, int quantidade, String nome, String modelo, float precoCompra, Tipopeca tipopeca) {
        this.idPeca = idPeca;
        this.quantidade = quantidade;
        this.nome = nome;
        this.modelo = modelo;
        this.precoCompra = precoCompra;
        this.fKtipopeca = tipopeca;

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

    public static List<model.Peca> obterPecas() throws ClassNotFoundException, SQLException {
        return PecaDAO.obterPecas();
    }

    public static List<Peca> obterPrecos() throws ClassNotFoundException, SQLException {
        return PecaDAO.obterPrecos();
    }

    public static model.Peca obterPeca(int idPeca) throws ClassNotFoundException {
        return PecaDAO.getPeca(idPeca);
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
