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
import model.Desempenho;

/**
 *
 * @author Pablo
 */
public class ManterDesempenhoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("desempenhos", Desempenho.obterDesempenhos());
            RequestDispatcher view = request.getRequestDispatcher("/manterDesempenho.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int idDesempenho = Integer.parseInt(request.getParameter("txtIdDesempenho"));
        String nome = request.getParameter("txtNome");
        String data = request.getParameter("txtData");
        String hora = request.getParameter("txtHora");
        float velocidadeMedia = Float.parseFloat(request.getParameter("txtVelocidadeMedia"));
        float aceleracaoMedia = Float.parseFloat(request.getParameter("txtAceleracaoMedia"));
        String tempoPista = request.getParameter("txtTempoPista");
        float frenagem = Float.parseFloat(request.getParameter("txtFrenagem"));
        try {
            Desempenho desempenho = new Desempenho(idDesempenho, nome, data, hora, velocidadeMedia, aceleracaoMedia, tempoPista, frenagem);
            desempenho.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDesempenhoController");
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
            int idDesempenho = Integer.parseInt(request.getParameter("idDesempenho"));
            Desempenho desempenho = Desempenho.obterDesempenho(idDesempenho);
            request.setAttribute("desempenho", desempenho);
            RequestDispatcher view = request.getRequestDispatcher("/manterDesempenho.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int idDesempenho = Integer.parseInt(request.getParameter("txtIdDesempenho"));
        String nome = request.getParameter("txtNome");
        String data = request.getParameter("txtData");
        String hora = request.getParameter("txtHora");
        float velocidadeMedia = Float.parseFloat(request.getParameter("txtVelocidadeMedia"));
        float aceleracaoMedia = Float.parseFloat(request.getParameter("txtAceleracaoMedia"));
        String tempoPista = request.getParameter("txtTempoPista");
        float frenagem = Float.parseFloat(request.getParameter("txtFrenagem"));
        try {
            Desempenho desempenho = new Desempenho(idDesempenho, nome, data, hora, velocidadeMedia, aceleracaoMedia, tempoPista, frenagem);
            desempenho.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDesempenhoController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            int idDesempenho = Integer.parseInt(request.getParameter("idDesempenho"));
            Desempenho desempenho = Desempenho.obterDesempenho(idDesempenho);
            request.setAttribute("desempenho", desempenho);
            RequestDispatcher view = request.getRequestDispatcher("/manterDesempenho.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int idDesempenho = Integer.parseInt(request.getParameter("txtIdDesempenho"));
        String nome = request.getParameter("txtNome");
        String data = request.getParameter("txtData");
        String hora = request.getParameter("txtHora");
        float velocidadeMedia = Float.parseFloat(request.getParameter("txtVelocidadeMedia"));
        float aceleracaoMedia = Float.parseFloat(request.getParameter("txtAceleracaoMedia"));
        String tempoPista = request.getParameter("txtTempoPista");
        float frenagem = Float.parseFloat(request.getParameter("txtFrenagem"));
        try {
            Desempenho desempenho = new Desempenho(idDesempenho, nome, data, hora, velocidadeMedia, aceleracaoMedia, tempoPista, frenagem);
            desempenho.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDesempenhoController");
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
            Logger.getLogger(ManterDesempenhoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterDesempenhoController.class.getName()).log(Level.SEVERE, null, ex);
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
