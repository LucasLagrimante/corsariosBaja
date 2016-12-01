package model;

import dao.DesempenhoDAO;
import java.sql.SQLException;
import java.util.List;

public class Desempenho {

    private int idDesempenho;
    private String nome, data, hora, tempoPista;
    private int aceleracaoMedia, velocidadeMedia, frenagem;

    private final int idAutomovel;
    private Automovel automovel;

    private final int idTipoPista;
    private TipoPista tipopista;

    private final int matricula;
    private Integrante integrante;

    public Desempenho(int idDesempenho, String nome, String data, String hora, int aceleracaoMedia, int velocidadeMedia, String tempoPista, int frenagem, int idAutomovel, int idTipoPista, int matricula) {
        this.idDesempenho = idDesempenho;
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

    public int getIdAutomovel() {
        return idAutomovel;
    }

    public int getIdTipoPista() {
        return idTipoPista;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setAceleracaoMedia(int aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public void setVelocidadeMedia(int velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public Automovel getAutomovel() throws ClassNotFoundException {
        if ((automovel == null) && (idAutomovel != 0)) {
            automovel = Automovel.obterAutomovel(idAutomovel);
        }
        return automovel;
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

    public int getIdDesempenho() {
        return idDesempenho;
    }

    public void setIdDesempenho(int idDesempenho) {
        this.idDesempenho = idDesempenho;
    }

    public int getVelocidadeMedia() {
        return velocidadeMedia;
    }
    public int getAceleracaoMedia() {
        return aceleracaoMedia;
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

    public String getTempoPista() {
        return tempoPista;
    }

    public void setTempoPista(String tempoPista) {
        this.tempoPista = tempoPista;
    }

    public int getFrenagem() {
        return frenagem;
    }

    public void setFrenagem(int frenagem) {
        this.frenagem = frenagem;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        DesempenhoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        DesempenhoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        DesempenhoDAO.excluir(this);
    }

    public static List<Desempenho> obterDesempenhos() throws ClassNotFoundException, SQLException {
        return DesempenhoDAO.obterDesempenhos();
    }

    public static Desempenho obterDesempenho(int idDesempenho) throws ClassNotFoundException {
        return DesempenhoDAO.obterDesempenho(idDesempenho);
    }

}
