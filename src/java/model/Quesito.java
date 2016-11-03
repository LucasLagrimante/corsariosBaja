package model;

import dao.QuesitoDAO;
import java.sql.SQLException;
import java.util.List;

public class Quesito {

    private int idQuesito;
    private String nome;
    private float nota;

    public Quesito(int id, String nome, float nota) {
        this.idQuesito = id;
        this.nome = nome;
        this.nota = nota;
    }

    public int getIdQuesito() {
        return idQuesito;
    }

    public void setIdQuesito(int idQuesito) {
        this.idQuesito = idQuesito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        QuesitoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        QuesitoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        QuesitoDAO.excluir(this);
    }

    public static List<Quesito> obterQuesitos() throws ClassNotFoundException, SQLException {
        return QuesitoDAO.obterQuesitos();
    }

    public static Quesito obterQuesito(int idQuesito) throws ClassNotFoundException {
        return QuesitoDAO.obterQuesito(idQuesito);
    }
}
