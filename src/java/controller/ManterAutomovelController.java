/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static dao.AutomovelDAO.fecharConexao;
import dao.BD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Automovel;

/**
 *
 * @author Aluno
 */
public class ManterAutomovelController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        }
        /*
         else if (acao.equals("confirmarIncluir")) {
         confirmarIncluir(request, response);
         } else if (acao.equals("prepararEditar")) {
         prepararEditar(request, response);
         }  else if (acao.equals("confirmarEditar")) {
         confirmarEditar(request, response);
         } else if (acao.equals("prepararExcluir")) {
         prepararExcluir(request, response);
         } else if (acao.equals("confirmarExcluir")) {
         confirmarExcluir(request, response);
         }
         */
    }

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("automoveis", Automovel.obterAutomoveis());
            RequestDispatcher view = request.getRequestDispatcher("/manterAutomovel.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response){
        int idAutomovel = Integer.parseInt(request.getParameter("txtIdAutomovel"));
        String nome = request.getParameter(request.getParameter("txtNome"));
        String cor = request.getParameter(request.getParameter("txtCor"));
        String dataTerminoProjeto = request.getParameter(request.getParameter("txtDataTerminoProjeto"));
        float pesoCarro = Float.parseFloat(request.getParameter("txtPesoCarro"));
        float pesoChassi = Float.parseFloat(request.getParameter("txtPesoChassi"));
        float custoTotal = Float.parseFloat(request.getParameter("txtCustoTotal"));
        try {
            /*Automovel automovel = null;
            if (coordenador != 0) {
                automovel = Professor.obterProfessor(coordenador);
            }*/
            Automovel automovel = new Automovel(idAutomovel, nome, cor, dataTerminoProjeto, pesoCarro, pesoChassi, custoTotal);
            automovel.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAutomovelController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAutomovelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAutomovelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
