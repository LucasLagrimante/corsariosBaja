package model;

import dao.AvaliacaoDAO;
import java.sql.SQLException;
import java.util.List;

public class Avaliacao {

    private int idAvaliacao, frequencia;
    private String comparecimento, data;
     private final int matricula;
    private Integrante integrante;

    public Avaliacao(int idAvaliacao, int frequencia, String comparecimento, String data, int matricula) {
        this.idAvaliacao = idAvaliacao;
        this.frequencia = frequencia;
        this.comparecimento = comparecimento;
        this.data = data;
        this.matricula = matricula;
    }
    
     public int getMatricula() {
        return matricula;
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

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return idAvaliacao;
    }

    public void setId(int id) {
        this.idAvaliacao = id;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String getComparecimento() {
        return comparecimento;
    }

    public void setComparecimento(String comparecimento) {
        this.comparecimento = comparecimento;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        AvaliacaoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AvaliacaoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AvaliacaoDAO.excluir(this);
    }

    public static List<Avaliacao> obterAvaliacoes() throws ClassNotFoundException, SQLException {
        return AvaliacaoDAO.obterAvaliacoes();
    }

    public static Avaliacao obterAvaliacao(int idAvaliacao) throws ClassNotFoundException {
        return AvaliacaoDAO.obterAvaliacao(idAvaliacao);
    }
}
