package model;

import dao.CompeticaoDAO;
import java.sql.SQLException;
import java.util.List;

public class Competicao {

    private int idCompeticao;
    private String nome, data, local, hora;

    public Competicao(int idCompeticao, String nome, String data, String local, String hora) {
        this.idCompeticao = idCompeticao;
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.hora = hora;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public void setId(int id) {
        this.idCompeticao = id;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public static List<Competicao>obterCompeticoes() throws ClassNotFoundException, SQLException{
        return CompeticaoDAO.obterCompeticoes();
    }
}
