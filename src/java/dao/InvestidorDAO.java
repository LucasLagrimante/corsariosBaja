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
import model.Investidor;

public class InvestidorDAO {

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

    public static void gravar(Investidor investidor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO investidor (IdInvestidor ,valorDoado, FK_pessoa) VALUES (?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, investidor.getIdInvestidor());
            comando.setFloat(1, investidor.getValorDoado());
            comando.setInt(2, investidor.getPessoa().getIdPessoa());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Investidor> obterInvestidores() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Investidor> investidores = new ArrayList<Investidor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM investidor");
            while (rs.next()) {
                Investidor investidor = new Investidor(
                        rs.getInt("IdInvestidor"),
                        rs.getInt("valorDoado"),
                        null
                );
                investidor.setIdPessoa(rs.getInt("IdPessoa"));
                investidores.add(investidor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return investidores;
    }

    public static Investidor obterInvestidor(int registro) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Investidor investidor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM investidor where registro = " + registro);
            rs.first();
            investidor = new Investidor(
                    rs.getInt("IdInvestidor"),
                    rs.getInt("valorDoado"),
                    null
            );
            investidor.setIdPessoa(rs.getInt("IdPessoa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return investidor;
    }

}
