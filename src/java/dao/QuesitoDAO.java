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
import model.Quesito;

public class QuesitoDAO {

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

    public static void gravar(Quesito quesito) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO quesito (idQuesito,nome,nota) VALUES (?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, quesito.getIdQuesito());
            comando.setString(2, quesito.getNome());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Quesito> obterQuesitos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Quesito> tiposPeca = new ArrayList<Quesito>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM quesito");
            while (rs.next()) {
                Quesito quesito = new Quesito(
                        rs.getInt("idQuesito"),
                        rs.getString("nome"),
                        rs.getFloat("nota")
                );
                tiposPeca.add(quesito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return tiposPeca;
    }

    public static Quesito obterQuesito(int idQuesito) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Quesito quesito = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM tipopeca where idQuesito = " + idQuesito);
            rs.first();
            quesito = new Quesito(
                        rs.getInt("idQuesito"),
                        rs.getString("nome"),
                        rs.getFloat("nota")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return quesito;
    }

}
