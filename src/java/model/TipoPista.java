package model;

import dao.TipoPistaDAO;
import java.sql.SQLException;
import java.util.List;

public class TipoPista {

    private int idTipoPista;
    private String nome;

    public TipoPista(int idTipoPista, String nome) {
        this.idTipoPista = idTipoPista;
        this.nome = nome;
    }

    public int getIdTipoPista() {
        return idTipoPista;
    }

    public void setIdTipoPista(int idTipoPista) {
        this.idTipoPista = idTipoPista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        TipoPistaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        TipoPistaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        TipoPistaDAO.excluir(this);
    }

    public static List<TipoPista> obterTiposPista() throws ClassNotFoundException, SQLException {
        return TipoPistaDAO.obterTiposPista();
    }

    public static TipoPista obterTipoPista(int idTipoPista) throws ClassNotFoundException {
        return TipoPistaDAO.obterTipoPista(idTipoPista);
    }
}
