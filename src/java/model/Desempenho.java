package model;

import dao.DesempenhoDAO;
import java.sql.SQLException;
import java.util.List;

public class Desempenho {

    private int idDesempenho;
    private String nome, data, hora, tempoPista;
    private float aceleracaoMedia, velocidadeMedia, frenagem;

    private final int idAutomovel;
    private Automovel automovel;

    private final int idTipoPista;
    private TipoPista tipopista;

    public int getIdAutomovel() {
        return idAutomovel;
    }

    public int getIdTipoPista() {
        return idTipoPista;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setAceleracaoMedia(float aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public void setVelocidadeMedia(float velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    private final int idPessoa;
    private Pessoa pessoa;

    public Desempenho(int idDesempenho, String nome, String data, String hora, float aceleracaoMedia, float velocidadeMedia, String tempoPista, float frenagem, int idAutomovel, int idTipoPista, int idPessoa) {
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
        this.idPessoa = idPessoa;
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

    public Pessoa getPessoa() throws ClassNotFoundException {
        if ((pessoa == null) && (idPessoa != 0)) {
            pessoa = Pessoa.obterPessoa(idPessoa);
        }
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

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
