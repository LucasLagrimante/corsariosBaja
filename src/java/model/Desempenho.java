package model;

import dao.DesempenhoDAO;
import java.sql.SQLException;
import java.util.List;

public class Desempenho {

    private int idDesempenho;
    private float velocidadeMedia, aceleracaoMedia, tempoCorrida, frenagem;
    private String data, nome, hora;

    public Desempenho(int idDesempenho, float velocidadeMedia, float aceleracaoMedia, String hora, float tempoCorrida, float frenagem, String data, String nome) {
        this.idDesempenho = idDesempenho;
        this.velocidadeMedia = velocidadeMedia;
        this.aceleracaoMedia = aceleracaoMedia;
        this.hora = hora;
        this.tempoCorrida = tempoCorrida;
        this.frenagem = frenagem;
        this.data = data;
        this.nome = nome;
    }

    public int getId() {
        return idDesempenho;
    }

    public void setId(int id) {
        this.idDesempenho = id;
    }

    public float getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(int velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public float getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setAceleracaoMedia(int aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
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

    public float getTempoCorrida() {
        return tempoCorrida;
    }

    public void setTempoCorrida(float tempoCorrida) {
        this.tempoCorrida = tempoCorrida;
    }

    public float getFrenagem() {
        return frenagem;
    }

    public void setFrenagem(float frenagem) {
        this.frenagem = frenagem;
    }
    
    public static List<Desempenho>obterDesempenhos() throws ClassNotFoundException, SQLException{
        return DesempenhoDAO.obterDesempenhos();
    }

}
