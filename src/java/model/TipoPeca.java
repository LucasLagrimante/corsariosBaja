package model;

import dao.TipoPecaDAO;
import java.sql.SQLException;
import java.util.List;

public class TipoPeca {


    private int idTipoPeca;
    private String nome;

    public TipoPeca(int id, String nome) {
        this.idTipoPeca = id;
        this.nome = nome;
    }

    public int getId() {
        return idTipoPeca;
    }

    public void setId(int id) {
        this.idTipoPeca = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public static List<TipoPeca> obterTiposPecas() throws ClassNotFoundException, SQLException{
        return TipoPecaDAO.obterTiposPecas();
    }
}
