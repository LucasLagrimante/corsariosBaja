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

    public static List<Competicao> obterCompeticoes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Competicao> competicoes = new ArrayList<Competicao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from competicao");
            while (rs.next()) {
                Competicao competicao = new Competicao(
                        rs.getInt("idCompeticao"),
                        rs.getString("nome"),
                        rs.getString("data"),
                        rs.getString("local"),
                        rs.getString("hora")
                );
                competicoes.add(competicao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return competicoes;
    }

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

}
