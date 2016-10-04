package model;

import dao.IntegranteDAO;
import java.sql.SQLException;
import java.util.List;

public class Integrante {

    private int matricula;
    private String cargaHorariaDisponivel;

    public void setCargaHorariaDisponivel(String cargaHorariaDisponivel) {
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }

    public Integrante(int matricula, String cargaHorariaDisponivel) {
        this.matricula = matricula;
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


    public static List<Integrante>obterIntegrantes() throws ClassNotFoundException, SQLException{
        return IntegranteDAO.obterIntegrantes();
    }
}
