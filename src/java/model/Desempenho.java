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
public class Desempenho implements Serializable {
    @Id
    @Column(name = "idDesempenho")
    private Integer idDesempenho;
    private String nome;
    private String data;
    private String hora;
    private float aceleracaoMedia;
    private float velocidadeMedia;
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

    public Desempenho(Integer idDesempenho, String nome, String data, String hora, float aceleracaoMedia, float velocidadeMedia, String tempoPista, float frenagem, Automovel fKautomovel, Integrante fKmotorista, Tipopista fKtipopista) {
        this.idDesempenho = idDesempenho;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.aceleracaoMedia = aceleracaoMedia;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoPista = tempoPista;
        this.frenagem = frenagem;
        this.fKautomovel = fKautomovel;
        this.fKmotorista = fKmotorista;
        this.fKtipopista = fKtipopista;
    }

    public Desempenho() {
    }

    public Desempenho(Integer idDesempenho) {
        this.idDesempenho = idDesempenho;
    }

    public Desempenho(Integer idDesempenho, String nome, String data, String hora, float aceleracaoMedia, float velocidadeMedia, String tempoPista, float frenagem) {
        this.idDesempenho = idDesempenho;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.aceleracaoMedia = aceleracaoMedia;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoPista = tempoPista;
        this.frenagem = frenagem;
    }

    public Integer getIdDesempenho() {
        return idDesempenho;
    }

    public void setIdDesempenho(Integer idDesempenho) {
        this.idDesempenho = idDesempenho;
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

    public float getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setAceleracaoMedia(float aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public float getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(float velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
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
        hash += (idDesempenho != null ? idDesempenho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desempenho)) {
            return false;
        }
        Desempenho other = (Desempenho) object;
        if ((this.idDesempenho == null && other.idDesempenho != null) || (this.idDesempenho != null && !this.idDesempenho.equals(other.idDesempenho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Desempenho[ idDesempenho=" + idDesempenho + " ]";
    }

}
