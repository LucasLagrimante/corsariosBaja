/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avaliacao;
import model.Integrante;

/**
 *
 * @author lukin
 */
public class ManterAvaliacaoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
         confirmarEditar(request, response);
         } else if (acao.equals("prepararExcluir")) {
         prepararExcluir(request, response);
         } else if (acao.equals("confirmarExcluir")) {
         confirmarExcluir(request, response);
         }
         

    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("integrantes", Integrante.obterIntegrantes());
            RequestDispatcher view = request.getRequestDispatcher("/manterAvaliacao.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        //} catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int idAvaliacao = Integer.parseInt(request.getParameter("txtIdAvaliacao"));
        int frequencia = Integer.parseInt(request.getParameter("txtFrequencia"));
        String comparecimento = request.getParameter("txtComparecimento");
        String data = request.getParameter("txtData");
        int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));
             try {
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = Integrante.obterIntegrante(matricula);
            }
            Avaliacao avaliacao = new Avaliacao(idAvaliacao, frequencia, comparecimento, data, matricula);
            avaliacao.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAvaliacaoController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("integrantes", Integrante.obterIntegrantes());
            int idAvaliacao = Integer.parseInt(request.getParameter("idAvaliacao"));
            Avaliacao avaliacao = Avaliacao.obterAvaliacao(idAvaliacao);
            request.setAttribute("avaliacao", avaliacao);
            RequestDispatcher view = request.getRequestDispatcher("/manterAvaliacao.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }
    
    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int idAvaliacao = Integer.parseInt(request.getParameter("txtIdAvaliacao"));
        int frequencia = Integer.parseInt(request.getParameter("txtFrequencia"));
        String comparecimento = request.getParameter("txtComparecimento");
        String data = request.getParameter("txtData");
        int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));
             try {
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = Integrante.obterIntegrante(matricula);
            }
            Avaliacao avaliacao = new Avaliacao(idAvaliacao, frequencia, comparecimento, data, matricula);
            avaliacao.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAvaliacaoController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("integrantes", Integrante.obterIntegrantes());
            int idAvaliacao = Integer.parseInt(request.getParameter("idAvaliacao"));
            Avaliacao avaliacao = Avaliacao.obterAvaliacao(idAvaliacao);
            request.setAttribute("avaliacao", avaliacao);
            RequestDispatcher view = request.getRequestDispatcher("/manterAvaliacao.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int idAvaliacao = Integer.parseInt(request.getParameter("txtIdAvaliacao"));
        int frequencia = Integer.parseInt(request.getParameter("txtFrequencia"));
        String comparecimento = request.getParameter("txtComparecimento");
        String data = request.getParameter("txtData");
        int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));
             try {
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = Integrante.obterIntegrante(matricula);
            }
            Avaliacao avaliacao = new Avaliacao(idAvaliacao, frequencia, comparecimento, data, matricula);
            avaliacao.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAvaliacaoController");
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
            Logger.getLogger(ManterAvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterAvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterAvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
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
