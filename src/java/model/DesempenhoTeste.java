package model;

import dao.DesempenhoTesteDAO;
import java.sql.SQLException;
import java.util.List;

public class DesempenhoTeste {

    private int idDesempenhoTeste;
    private String data, nome, hora, tempoPista;
    private float  frenagem, velocidadeMedia, aceleracaoMedia;
    

    public DesempenhoTeste(int idDesempenhoTeste, String data, String hora, String nome, float velocidadeMedia, float aceleracaoMedia, String tempoPista ,float frenagem) {
        this.idDesempenhoTeste = idDesempenhoTeste;
        this.data = data;
        this.hora = hora;
        this.nome = nome;
        this.velocidadeMedia = velocidadeMedia;
        this.aceleracaoMedia = aceleracaoMedia;
        this.tempoPista = tempoPista;
        this.frenagem = frenagem;
    }

    public int getIdDesempenhoTeste() {
        return idDesempenhoTeste;
    }

    public void setIdDesempenhoTeste(int idDesempenhoTeste) {
        this.idDesempenhoTeste = idDesempenhoTeste;
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

    public void setaceleracaoMedia(int aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        return this.nome = nome;
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

       public static List<DesempenhoTeste> obterDesempenhosTeste() throws ClassNotFoundException, SQLException {
        return DesempenhoTesteDAO.obterDesempenhosTeste();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        DesempenhoTesteDAO.gravar(this);
    }

    public static DesempenhoTeste obterDesempenhoTeste(int idDesempenhoTeste) throws ClassNotFoundException {
        return DesempenhoTesteDAO.obterDesempenhoTeste(idDesempenhoTeste);
    }
}
