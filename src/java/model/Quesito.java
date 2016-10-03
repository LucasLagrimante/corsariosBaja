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

    public int getId() {
        return idQuesito;
    }

    public void setId(int id) {
        this.idQuesito = id;
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
    public static List<Quesito> obterQuesitos() throws ClassNotFoundException, SQLException{
        return QuesitoDAO.obterQuesitos();
    }
}
