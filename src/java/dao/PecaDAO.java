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

    
       public static void gravar(Peca peca) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO peca (idPeca,quantidade,nome, modelo,precoCompra, FK_tipopeca) VALUES (?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, peca.getIdPeca());
            comando.setInt(2, peca.getQuantidade());
            comando.setString(3, peca.getNome());
            comando.setString(4, peca.getModelo());
            comando.setFloat(5, peca.getPrecoCompra());
            comando.setInt(6, peca.getFK_tipopeca());
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
                        rs.getFloat("precoCompra"),
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
                        rs.getFloat("precoCompra"),
                        rs.getInt("FK_tipopeca")
            //null
            );
            //automovel.setCodigoPessoa(rs.getString("pessoa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return peca;
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
