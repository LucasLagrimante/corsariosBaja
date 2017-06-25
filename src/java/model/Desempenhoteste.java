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
@Entity(name = "Desempenhoteste")
@Table(name = "desempenhoteste")
public class Desempenhoteste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDesempenhoteste")
    private Integer idDesempenhoteste;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "hora")
    private String hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "velocidadeMedia")
    private float velocidadeMedia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aceleracaoMedia")
    private float aceleracaoMedia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tempoPista")
    private String tempoPista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frenagem")
    private float frenagem;
    @JoinColumn(name = "FK_automovel", referencedColumnName = "idAutomovel")
    @ManyToOne(optional = false)
    private Automovel fKautomovel;
    @JoinColumn(name = "FK_motorista", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Integrante fKmotorista;
    @JoinColumn(name = "FK_tipopista", referencedColumnName = "idTipopista")
    @ManyToOne(optional = false)
    private Tipopista fKtipopista;

    public Desempenhoteste() {
    }

    public Desempenhoteste(Integer idDesempenhoteste) {
        this.idDesempenhoteste = idDesempenhoteste;
    }

    public Desempenhoteste(Integer idDesempenhoteste, String nome, String data, String hora, float velocidadeMedia, float aceleracaoMedia, String tempoPista, float frenagem, Automovel fKautomovel, Integrante fKmotorista, Tipopista fKtipopista) {
        this.idDesempenhoteste = idDesempenhoteste;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.velocidadeMedia = velocidadeMedia;
        this.aceleracaoMedia = aceleracaoMedia;
        this.tempoPista = tempoPista;
        this.frenagem = frenagem;
        this.fKautomovel = fKautomovel;
        this.fKmotorista = fKmotorista;
        this.fKtipopista = fKtipopista;
    }

    public Integer getIdDesempenhoteste() {
        return idDesempenhoteste;
    }

    public void setIdDesempenhoteste(Integer idDesempenhoteste) {
        this.idDesempenhoteste = idDesempenhoteste;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(float velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public float getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setAceleracaoMedia(float aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public String getTempoPista() {
        return tempoPista;
    }

    public void setTempoPista(String tempoPista) {
        this.tempoPista = tempoPista;
    }

    public float getFrenagem() {
        return frenagem;
    }

    public void setFrenagem(float frenagem) {
        this.frenagem = frenagem;
    }

    public Automovel getFKautomovel() {
        return fKautomovel;
    }

    public void setFKautomovel(Automovel fKautomovel) {
        this.fKautomovel = fKautomovel;
    }

    public Integrante getFKmotorista() {
        return fKmotorista;
    }

    public void setFKmotorista(Integrante fKmotorista) {
        this.fKmotorista = fKmotorista;
    }

    public Tipopista getFKtipopista() {
        return fKtipopista;
    }

    public void setFKtipopista(Tipopista fKtipopista) {
        this.fKtipopista = fKtipopista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesempenhoteste != null ? idDesempenhoteste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desempenhoteste)) {
            return false;
        }
        Desempenhoteste other = (Desempenhoteste) object;
        if ((this.idDesempenhoteste == null && other.idDesempenhoteste != null) || (this.idDesempenhoteste != null && !this.idDesempenhoteste.equals(other.idDesempenhoteste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Desempenhoteste[ idDesempenhoteste=" + idDesempenhoteste + " ]";
    }

}
