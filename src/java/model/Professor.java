package model;

import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.List;

public class Professor {

    private int registro;
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    private int idPessoa;

    public Professor(int registro) {
        this.registro = registro;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public Professor(int registro, Pessoa pessoa) {
        this.registro = registro;
        this.pessoa = pessoa;
    }

    public static List<Professor> obterProfessores() throws ClassNotFoundException, SQLException {
        return ProfessorDAO.obterProfessores();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ProfessorDAO.gravar(this);
    }

    public static Professor obterProfessor(int idProfessor) throws ClassNotFoundException {
        return ProfessorDAO.obterProfessor(idProfessor);
    }
}
