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
import model.TipoPista;

public class TipoPistaDAO {

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

    public static void gravar(TipoPista tipoPista) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO tipopista (idTipoPista,nome) VALUES (?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, tipoPista.getIdTipoPista());
            comando.setString(2, tipoPista.getNome());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<TipoPista> obterTiposPista() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoPista> tiposPista = new ArrayList<TipoPista>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM tipopista");
            while (rs.next()) {
                TipoPista tipoPista = new TipoPista(
                        rs.getInt("idTipoPista"),
                        rs.getString("nome")
                );
                tiposPista.add(tipoPista);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return tiposPista;
        
    }

    public static TipoPista obterTipoPista(int idTipoPista) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        TipoPista tipoPista = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM tipopista where idTipoPista = " + idTipoPista);
            rs.first();
            tipoPista = new TipoPista(
                    rs.getInt("idTipoPista"),
                    rs.getString("nome")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipoPista;
    }
    
     public static void alterar(TipoPista tipoPista) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE tipopista SET nome = ? "
                    + "WHERE IdTipoPista = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, tipoPista.getNome());
            comando.setInt(2, tipoPista.getIdTipoPista());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(TipoPista tipoPista) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from tipopista where idTipoPista = ? ");
            st.setInt(1, tipoPista.getIdTipoPista());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            
        }
    }

}