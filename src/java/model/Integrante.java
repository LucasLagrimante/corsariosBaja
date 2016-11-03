package model;

import dao.IntegranteDAO;
import java.sql.SQLException;
import java.util.List;

public class Integrante {

    private int matricula;
    private String cargaHorariaDisponivel;
    private Pessoa pessoa;
    private int idPessoa;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integrante(int matricula, String cargaHorariaDisponivel, Pessoa pessoa) {
        this.matricula = matricula;
        this.pessoa = pessoa;
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setCargaHorariaDisponivel(String cargaHorariaDisponivel) {
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCargaHorariaDisponivel() {
        return cargaHorariaDisponivel;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        IntegranteDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        IntegranteDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        IntegranteDAO.excluir(this);
    }

    public static List<Integrante> obterIntegrantes() throws ClassNotFoundException, SQLException {
        return IntegranteDAO.obterIntegrantes();

    }

    public static Integrante obterIntegrante(int matricula) throws ClassNotFoundException {
        return IntegranteDAO.obterIntegrante(matricula);
    }
}
