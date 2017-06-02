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
public class Desempenhoteste implements Serializable {
    @Id
    @Column(name = "idDesempenhoTeste")
    private Integer idDesempenhoTeste;
    private String nome;
    private String data;
    private String hora;
    private float velocidadeMedia;
    private float aceleracaoMedia;
    private String tempoPista;
    private float frenagem;
    @ManyToOne
    @JoinColumn(name = "FK_automovel", referencedColumnName = "idAutomovel")
    private Automovel fKautomovel;
    @ManyToOne
    @JoinColumn(name = "FK_motorista", referencedColumnName = "matricula")
    private Integrante fKmotorista;
    @ManyToOne
    @JoinColumn(name = "FK_tipopista", referencedColumnName = "idTipopista")
    private Tipopista fKtipopista;

    public Desempenhoteste(Integer idDesempenhoTeste, String nome, String data, String hora, float velocidadeMedia, float aceleracaoMedia, String tempoPista, float frenagem, Automovel fKautomovel, Integrante fKmotorista, Tipopista fKtipopista) {
        this.idDesempenhoTeste = idDesempenhoTeste;
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

    public Desempenhoteste() {
    }

    public Desempenhoteste(Integer idDesempenhoTeste) {
        this.idDesempenhoTeste = idDesempenhoTeste;
    }

    public Desempenhoteste(Integer idDesempenhoTeste, String nome, String data, String hora, float velocidadeMedia, float aceleracaoMedia, String tempoPista, float frenagem) {
        this.idDesempenhoTeste = idDesempenhoTeste;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.velocidadeMedia = velocidadeMedia;
        this.aceleracaoMedia = aceleracaoMedia;
        this.tempoPista = tempoPista;
        this.frenagem = frenagem;
    }

    public Integer getIdDesempenhoTeste() {
        return idDesempenhoTeste;
    }

    public void setIdDesempenhoTeste(Integer idDesempenhoTeste) {
        this.idDesempenhoTeste = idDesempenhoTeste;
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
        hash += (idDesempenhoTeste != null ? idDesempenhoTeste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desempenhoteste)) {
            return false;
        }
        Desempenhoteste other = (Desempenhoteste) object;
        if ((this.idDesempenhoTeste == null && other.idDesempenhoTeste != null) || (this.idDesempenhoTeste != null && !this.idDesempenhoTeste.equals(other.idDesempenhoTeste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Desempenhoteste[ idDesempenhoTeste=" + idDesempenhoTeste + " ]";
    }

}
