package model;

import dao.TipoPistaDAO;
import java.sql.SQLException;
import java.util.List;

public class TipoPista {

    private int idTipoPista;
    private String nome;

    public TipoPista(int id, String nome) {
        this.idTipoPista = id;
        this.nome = nome;
    }

    public int getId() {
        return idTipoPista;
    }

    public void setId(int id) {
        this.idTipoPista = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public static List<TipoPista> obterTiposPistas() throws ClassNotFoundException, SQLException{
        return TipoPistaDAO.obterTiposPistas();
    }
}
