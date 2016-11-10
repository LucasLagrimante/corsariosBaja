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

    public static void gravar(TipoPeca tipoPeca) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO tipopeca (idTipoPeca,nome) VALUES (?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, tipoPeca.getIdTipoPeca());
            comando.setString(2, tipoPeca.getNome());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<TipoPeca> obterTiposPeca() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoPeca> tiposPeca = new ArrayList<TipoPeca>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM tipopeca");
            while (rs.next()) {
                TipoPeca tipoPeca = new TipoPeca(
                        rs.getInt("idTipoPeca"),
                        rs.getString("nome")
                );
                tiposPeca.add(tipoPeca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return tiposPeca;
        
    }

    public static TipoPeca obterTipoPeca(int idTipoPeca) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        TipoPeca tipoPeca = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM tipopeca where idTipoPeca = " + idTipoPeca);
            rs.first();
            tipoPeca = new TipoPeca(
                    rs.getInt("idTipoPeca"),
                    rs.getString("nome")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipoPeca;
    }
    
     public static void alterar(TipoPeca tipoPeca) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE tipopeca SET nome = ? "
                    + "WHERE IdTipoPeca = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, tipoPeca.getNome());
            comando.setInt(2, tipoPeca.getIdTipoPeca());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(TipoPeca tipoPeca) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from tipopeca where idTipoPeca = ? ");
            st.setInt(1, tipoPeca.getIdTipoPeca());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            
        }
    }

}