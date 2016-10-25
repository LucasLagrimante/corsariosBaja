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
import model.TipoPeca;

public class TipoPecaDAO {

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

    public static void gravar(TipoPeca tipopeca) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO tipopeca (idTipoPeca, nome) VALUES (?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, tipopeca.getIdTipoPeca());
            comando.setString(2, tipopeca.getNome());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    // problema
    public static List<TipoPeca> obterTipoPecas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoPeca> tipopecas = new ArrayList<TipoPeca>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM tipopeca");
            while (rs.next()) {
                TipoPeca tipopeca = new TipoPeca(
                        rs.getInt("idTipoPeca"),
                        rs.getString("nome")
                );
                tipopecas.add(tipopeca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipopecas;
    }

    public static TipoPeca obterTipoPeca(int idTipoPeca) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        TipoPeca tipopeca = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM tipopeca where idTipoPeca = " + idTipoPeca);
            rs.first();
            tipopeca = new TipoPeca(
                    rs.getInt("idTipoPeca"),
                    rs.getString("nome")
            //null
            );
            //tipopeca.setCodigoPessoa(rs.getString("pessoa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipopeca;
    }

}