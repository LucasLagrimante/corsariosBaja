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
import model.Design;

public class DesignDAO {

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

    public static void gravar(Design design) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO design (idDesign, caminhoImagem, FK_automovel) VALUES (?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, design.getIdDesign());
            comando.setString(2, design.getCaminhoImagem());
            comando.setInt(3, design.getIdAutomovel());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Design> obterDesigns() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Design> designs = new ArrayList<Design>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM design");
            while (rs.next()) {
                Design design = new Design(
                        rs.getInt("idDesign"),
                        rs.getString("CaminhoImagem"),
                        rs.getInt("FK_automovel")
                );
                designs.add(design);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return designs;
    }

    public static Design obterDesign(int idDesign) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Design design = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM design where idDesign = " + idDesign);
            rs.first();
            design = new Design(
                    rs.getInt("idDesign"),
                    rs.getString("caminhoImagem"),
                    rs.getInt("FK_automovel")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return design;
    }

    public static void alterar(Design design) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE design SET caminhoImagem = ?, "
                    + "FK_automovel = ? "
                    + "WHERE IdDesign = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, design.getCaminhoImagem());
            comando.setInt(2, design.getIdAutomovel());
            comando.setInt(3, design.getIdDesign());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Design design) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from design where idDesign = ? ");
            st.setInt(1, design.getIdDesign());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {

        }
    }

}
