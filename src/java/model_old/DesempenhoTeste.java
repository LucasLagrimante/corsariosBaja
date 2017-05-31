package model_old;

import dao.DesempenhoTesteDAO;
import java.sql.SQLException;
import java.util.List;

public class DesempenhoTeste {

    private int idDesempenhoTeste;
    private String nome, data, hora, tempoPista;
    private float aceleracaoMedia, velocidadeMedia, frenagem;

    private final int idAutomovel;
    private Automovel automovel;

    private final int idTipoPista;
    private TipoPista tipopista;

    private final int matricula;
    private Integrante integrante;

    public DesempenhoTeste(int idDesempenhoTeste, String nome, String data, String hora, float aceleracaoMedia, float velocidadeMedia, String tempoPista, float frenagem, int idAutomovel, int idTipoPista, int matricula) {
        this.idDesempenhoTeste = idDesempenhoTeste;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.aceleracaoMedia = aceleracaoMedia;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoPista = tempoPista;
        this.frenagem = frenagem;
        this.idAutomovel = idAutomovel;
        this.idTipoPista = idTipoPista;
        this.matricula = matricula;
    }

    public Automovel getAutomovel() throws ClassNotFoundException {
        if ((automovel == null) && (idAutomovel != 0)) {
            automovel = Automovel.obterAutomovel(idAutomovel);
        }
        return automovel;
    }

    public int getIdAutomovel() {
        return idAutomovel;
    }

    public int getIdTipoPista() {
        return idTipoPista;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public TipoPista getTipopista() throws ClassNotFoundException {
        if ((tipopista == null) && (idTipoPista != 0)) {
            tipopista = TipoPista.obterTipoPista(idTipoPista);
        }
        return tipopista;
    }

    public void setTipopista(TipoPista tipopista) {
        this.tipopista = tipopista;
    }

    public Integrante getIntegrante() throws ClassNotFoundException {
        if ((integrante == null) && (matricula != 0)) {
            integrante = Integrante.obterIntegrante(matricula);
        }
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
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

    public void setVelocidadeMedia(float velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public float getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setaceleracaoMedia(float aceleracaoMedia) {
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

    public void gravar() throws SQLException, ClassNotFoundException {
        DesempenhoTesteDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        DesempenhoTesteDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        DesempenhoTesteDAO.excluir(this);
    }

    public static List<DesempenhoTeste> obterDesempenhosTeste() throws ClassNotFoundException, SQLException {
        return DesempenhoTesteDAO.obterDesempenhosTeste();
    }

    public static DesempenhoTeste obterDesempenhoTeste(int idDesempenhoTeste) throws ClassNotFoundException {
        return DesempenhoTesteDAO.obterDesempenhoTeste(idDesempenhoTeste);
    }

}
