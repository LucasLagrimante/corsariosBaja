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
import model.Frequencia;
import model.Integrante;

/**
 *
 * @author Aluno
 */
public class ManterFrequenciaController extends HttpServlet {

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

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("integrantes", Integrante.obterIntegrantes());
            RequestDispatcher view = request.getRequestDispatcher("/manterFrequencia.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int idFrequencia = Integer.parseInt(request.getParameter("txtIdFrequencia"));
        String data = request.getParameter("txtData");
        String estado = request.getParameter("radioEstado");
        int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));

        try {
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = Integrante.obterIntegrante(matricula);
            }
            Frequencia frequencia = new Frequencia(idFrequencia, data, estado, matricula);
            frequencia.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFrequenciaController");
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
            int idFrequencia = Integer.parseInt(request.getParameter("txtIdFrequencia"));
            Frequencia frequencia = Frequencia.obterFrequencia(idFrequencia);
            request.setAttribute("frequencia", frequencia);
            RequestDispatcher view = request.getRequestDispatcher("/manterFrequencia.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        int idFrequencia = Integer.parseInt(request.getParameter("txtIdFrequencia"));
        String data = request.getParameter("txtData");
        String estado = request.getParameter("radioEstado");
        int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));

        try {
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = Integrante.obterIntegrante(matricula);
            }
            Frequencia frequencia = new Frequencia(idFrequencia, data, estado, matricula);
            frequencia.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFrequenciaController");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        } catch (ClassNotFoundException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("integrantes", Integrante.obterIntegrantes());
            int idFrequencia = Integer.parseInt(request.getParameter("txtIdFrequencia"));
            Frequencia frequencia = Frequencia.obterFrequencia(idFrequencia);
            request.setAttribute("frequencia", frequencia);
            RequestDispatcher view = request.getRequestDispatcher("/manterFrequencia.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int idFrequencia = Integer.parseInt(request.getParameter("txtIdFrequencia"));
        String data = request.getParameter("txtData");
        String estado = request.getParameter("radioEstado");
        int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));

        try {
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = Integrante.obterIntegrante(matricula);
            }
            Frequencia frequencia = new Frequencia(idFrequencia, data, estado, matricula);
            frequencia.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFrequenciaController");
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
            Logger.getLogger(ManterFrequenciaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFrequenciaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterFrequenciaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFrequenciaController.class.getName()).log(Level.SEVERE, null, ex);
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
