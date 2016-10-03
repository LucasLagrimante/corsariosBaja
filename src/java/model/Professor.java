package model;

import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.List;

public class Professor {


    private int registro;

    public Professor(int registro) {
        this.registro = registro;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }
    public static List<Professor> obterProfessores() throws ClassNotFoundException, SQLException{
        return ProfessorDAO.obterProfessores();
    }
}
