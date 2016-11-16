package model;

import dao.IntegranteDAO;
import java.sql.SQLException;
import java.util.List;

public class Integrante {

    private int matricula;
    private String cargaHorariaDisponivel;
    private final int idPessoa;
    private Pessoa pessoa;

    public Integrante(int matricula, String cargaHorariaDisponivel, int idPessoa) {
        this.matricula = matricula;
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
        this.idPessoa = idPessoa;
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

    public void setCargaHorariaDisponivel(String cargaHorariaDisponivel) {
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public int getIdPessoa() {
        return idPessoa;
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
