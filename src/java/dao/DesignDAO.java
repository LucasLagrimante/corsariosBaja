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
            String sql = "INSERT INTO design (idDesign, caminho_imagem, FK_automovel) VALUES (?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, design.getIdDesign());
            comando.setString(2, design.getCaminho_imagem());
            comando.setInt(3, design.getFK_automovel());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    // problema
    public static List<Design> obterDesigns() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Design> designs = new ArrayList<Design>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM design where idDesign");
            while (rs.next()) {
                Design design = new Design(
                        rs.getInt("idDesign"),
                        rs.getString("caminho_imagem"),
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
                    rs.getString("caminho_imagem"),
                    rs.getInt("FK_automovel")
            //null
            );
            //design.setCodigoPessoa(rs.getString("pessoa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return design;
    }

}
