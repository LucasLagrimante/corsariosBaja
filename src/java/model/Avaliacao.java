package model;

import dao.AvaliacaoDAO;
import java.sql.SQLException;
import java.util.List;

public class Avaliacao {

    private int idAvaliacao, frequencia, FK_integrante;
    private String comparecimento, data;

    public Avaliacao(int idAvaliacao, int frequencia, String comparecimento, String data, int FK_integrante) {
        this.idAvaliacao = idAvaliacao;
        this.frequencia = frequencia;
        this.comparecimento = comparecimento;
        this.FK_integrante = FK_integrante;
        this.data = data;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getFK_integrante() {
        return FK_integrante;
    }

    public void setFK_integrante(int FK_integrante) {
        this.FK_integrante = FK_integrante;
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

    public static List<Avaliacao> obterAvaliacoes() throws ClassNotFoundException, SQLException {
        return AvaliacaoDAO.obterAvaliacoes();
    }

    public static Avaliacao obterAutomovel(int idAvaliacao) throws ClassNotFoundException {
        return AvaliacaoDAO.obterAvaliacao(idAvaliacao);
    }
}
