package model;

import dao.TipoPecaDAO;
import java.sql.SQLException;
import java.util.List;

public class TipoPeca {

    private int idTipoPeca;
    private String nome;

    public TipoPeca(int idTipoPeca, String nome) {
        this.idTipoPeca = idTipoPeca;
        this.nome = nome;
    }

    public int getIdTipoPeca() {
        return idTipoPeca;
    }

    public void setIdTipoPeca(int idTipoPeca) {
        this.idTipoPeca = idTipoPeca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<TipoPeca> obterTiposPeca() throws ClassNotFoundException, SQLException {
        return TipoPecaDAO.obterTiposPeca();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        TipoPecaDAO.gravar(this);
    }

    public static TipoPeca obterTipoPeca(int idTipoPeca) throws ClassNotFoundException {
        return TipoPecaDAO.obterTipoPeca(idTipoPeca);
    }
}
