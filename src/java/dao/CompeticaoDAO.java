/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Competicao;

public class CompeticaoDAO {
    
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

    public static void gravar(Competicao competicao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO competicao (idCompeticao , nome, data, hora, local) VALUES (?, ?, ?, ?,?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, competicao.getIdCompeticao());
            comando.setString(2, competicao.getNome());
            comando.setString(3, competicao.getData());
            comando.setString(4, competicao.getHora());
            comando.setString(5, competicao.getLocal());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Competicao> obterCompeticoes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Competicao> competicaoes = new ArrayList<Competicao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM competicao");
            while (rs.next()) {
                Competicao competicao = new Competicao(
                   rs.getInt("idCompeticao"),
                   rs.getString("nome"),
                   rs.getString("data"),
                   rs.getString("hora"),
                   rs.getString("local")
                );
                competicaoes.add(competicao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return competicaoes;
    }

    public static Competicao obterCompeticao(int idCompeticao) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Competicao competicao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM competicao where idCompeticao = " + idCompeticao);
            rs.first();
            competicao = new Competicao(
                   rs.getInt("idCompeticao"),
                   rs.getString("nome"),
                   rs.getString("data"),
                   rs.getString("hora"),
                   rs.getString("local")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return competicao;
    }

}
