package model;

import dao.AvaliacaoDAO;
import java.sql.SQLException;
import java.util.List;

public class Avaliacao {

    private int idAvaliacao, frequencia; 
    private String comparecimento;

    public Avaliacao(int id, int frequencia, String comparecimento) {
        this.idAvaliacao = id;
        this.frequencia = frequencia;
        this.comparecimento = comparecimento;
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
    
    public static List<Avaliacao> obterAvaliacoes() throws ClassNotFoundException, SQLException{
        return AvaliacaoDAO.obterAvaliacoes();
    }
}
