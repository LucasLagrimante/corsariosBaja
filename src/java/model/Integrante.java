package model;

import dao.IntegranteDAO;
import java.sql.SQLException;
import java.util.List;

public class Integrante {

    private int matricula;
    private float cargaHorariaDisponivel;

    public Integrante(int matricula, float cargaHorariaDisponivel) {
        this.matricula = matricula;
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public float getCargaHorariaDisponivel() {
        return cargaHorariaDisponivel;
    }

    public void setNota(float cargaHorariaDisponivel) {
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }

    public static List<Integrante>obterIntegrantes() throws ClassNotFoundException, SQLException{
        return IntegranteDAO.obterIntegrantes();
    }
}
