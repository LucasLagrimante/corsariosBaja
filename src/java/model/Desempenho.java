package model;

import dao.DesempenhoDAO;
import java.sql.SQLException;
import java.util.List;

public class Desempenho {

    private int idDesempenho;
    private String nome, data, hora;

    public Desempenho(int idDesempenho, String nome, String data, String hora, float aceleracaoMedia, float velocidadeMedia, float tempoCorrida, float frenagem) {
        this.idDesempenho = idDesempenho;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.aceleracaoMedia = aceleracaoMedia;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoCorrida = tempoCorrida;
        this.frenagem = frenagem;
    }
    private float aceleracaoMedia, velocidadeMedia, tempoCorrida, frenagem;

    public int getIdDesempenho() {
        return idDesempenho;
    }

    public void setIdDesempenho(int idDesempenho) {
        this.idDesempenho = idDesempenho;
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

    public static List<Desempenho> obterDesempenhos() throws ClassNotFoundException, SQLException {
        return DesempenhoDAO.obterDesempenhos();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        DesempenhoDAO.gravar(this);
    }

    public static Desempenho obterDesempenho(int idDesempenho) throws ClassNotFoundException {
        return DesempenhoDAO.obterDesempenho(idDesempenho);
    }

}
