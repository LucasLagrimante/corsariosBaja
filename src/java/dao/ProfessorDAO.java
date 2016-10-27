/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Professor;

public class ProfessorDAO {

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }

        } catch (SQLException e) {
        }
    }

    public static void gravar(Professor professor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO professor (registro ,FK_pessoa) VALUES (?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, professor.getRegistro());
            comando.setInt(2, professor.getPessoa().getIdPessoa());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Professor> obterProfessores() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Professor> professores = new ArrayList<Professor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM professor");
            while (rs.next()) {
                Professor professor = new Professor(
                        rs.getInt("registro"),
                        null
                );
                professor.setIdPessoa(rs.getInt("IdPessoa"));
                professores.add(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return professores;
    }

    public static Professor obterProfessor(int registro) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Professor professor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM professor where registro = " + registro);
            rs.first();
            professor = new Professor(
                    rs.getInt("registro"),
                    null
            );
            professor.setIdPessoa(rs.getInt("IdPessoa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return professor;
    }

}
