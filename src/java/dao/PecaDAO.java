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
import model.Peca;

public class PecaDAO {

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
    
    public static void gravar(Peca peca) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO peca (idPeca, quantidade, nome, modelo, precoCompra, FK_tipopeca) VALUES (?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, peca.getIdPeca());
            comando.setInt(2, peca.getQuantidade());
            comando.setString(3, peca.getNome());
            comando.setString(4, peca.getModelo());
            comando.setInt(5, peca.getPrecoCompra());
            comando.setInt(6, peca.getIdTipoPeca());
            
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Peca> obterPecas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Peca> pecas = new ArrayList<Peca>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM peca");
            while (rs.next()) {
                Peca peca = new Peca(
                        rs.getInt("idPeca"),
                        rs.getInt("quantidade"),
                        rs.getString("nome"),
                        rs.getString("modelo"),
                        rs.getInt("precoCompra"),
                        rs.getInt("FK_tipopeca")
                        
                );
                
                pecas.add(peca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return pecas;
    }

    public static Peca obterPeca(int idPeca) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Peca peca = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM peca where idPeca = " + idPeca);
            rs.first();
            peca = new Peca(
                    rs.getInt("idPeca"),
                    rs.getInt("quantidade"),
                    rs.getString("nome"),
                    rs.getString("modelo"),
                    rs.getInt("precoCompra"),
                    rs.getInt("FK_tipopeca")
            );
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return peca;
    }
    
    public static void alterar(Peca peca) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE peca SET quantidade = ?, "
                    + "nome = ?, modelo = ?, precoCompra = ?, "
                    + "FK_tipopeca = ? "
                    + "WHERE idPeca = ?";
            
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, peca.getQuantidade());
            comando.setString(2, peca.getNome());
            comando.setString(3, peca.getModelo());
            comando.setInt(4, peca.getPrecoCompra());
            comando.setInt(5, peca.getIdTipoPeca());
            comando.setInt(6, peca.getIdPeca());
       
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    
    public static void excluir(Peca peca) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from peca where idPeca = ? ");
            st.setInt(1, peca.getIdPeca());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            
        }
    }
}
