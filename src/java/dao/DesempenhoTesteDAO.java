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
import model.DesempenhoTeste;

public class DesempenhoTesteDAO {

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

    public static void gravar(DesempenhoTeste desempenhoTeste) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO desempenhoTeste (idDesempenhoTeste, nome, data, hora, velocidadeMedia, aceleracaoMedia, tempoPista, frenagem) VALUES (?, ?, ?, ?, ?, ?, ?,?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, desempenhoTeste.getIdDesempenhoTeste());
            comando.setString(2, desempenhoTeste.getNome());
            comando.setString(3, desempenhoTeste.getData());
            comando.setString(4, desempenhoTeste.getHora());
            comando.setFloat(5, desempenhoTeste.getVelocidadeMedia());
            comando.setFloat(6, desempenhoTeste.getAceleracaoMedia());
            comando.setString(7, desempenhoTeste.getTempoPista());
            comando.setFloat(8, desempenhoTeste.getFrenagem());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<DesempenhoTeste> obterDesempenhosTeste() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<DesempenhoTeste> desempenhosTeste = new ArrayList<DesempenhoTeste>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM desempenhoTeste");
            while (rs.next()) {
                DesempenhoTeste desempenhoTeste = new DesempenhoTeste(
                        rs.getInt("idDesempenhoTeste"),
                        rs.getString("nome"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getFloat("velocidadeMedia"),
                        rs.getFloat("aceleracaoMedia"),
                        rs.getString("tempoPista"),
                        rs.getFloat("frenagem")
                );
                desempenhosTeste.add(desempenhoTeste);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return desempenhosTeste;
    }

    public static DesempenhoTeste obterDesempenhoTeste(int idDesempenhoTeste) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        DesempenhoTeste desempenhoTeste = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM desempenhoTeste where idDesempenhoTeste = " + idDesempenhoTeste);
            rs.first();
            desempenhoTeste = new DesempenhoTeste(
                    rs.getInt("idDesempenhoTeste"),
                        rs.getString("nome"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getFloat("velocidadeMedia"),
                        rs.getFloat("aceleracaoMedia"),
                        rs.getString("tempoPista"),
                        rs.getFloat("frenagem")
            //null
            );
            //desempenhoTeste.setCodigoPessoa(rs.getString("pessoa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return desempenhoTeste;
    }

    public static void alterar(DesempenhoTeste desempenhoTeste) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE desempenhoTeste SET nome = ?, "
                    + "data = ?, hora = ?, velocidadeMedia = ?, "
                    + "aceleracaoMedia = ?, tempoPista = ? "
                    + "frenagem = ?,"
                    +  "WHERE IdDesempenhoTeste = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(2, desempenhoTeste.getNome());
            comando.setString(3, desempenhoTeste.getData());
            comando.setString(4, desempenhoTeste.getHora());
            comando.setFloat(5, desempenhoTeste.getVelocidadeMedia());
            comando.setFloat(6, desempenhoTeste.getAceleracaoMedia());
            comando.setString(7, desempenhoTeste.getTempoPista());
            comando.setFloat(8, desempenhoTeste.getFrenagem());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
        public static void excluir(DesempenhoTeste desempenhoteste) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from desempenhoteste where idDesempenhoTeste = ? ");
            st.setInt(1, desempenhoteste.getIdDesempenhoTeste());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            
        }
    }

}
