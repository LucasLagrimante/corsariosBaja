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
import model.Integrante;
import model.Pessoa;

/**
 *
 * @author Aluno
 */
public class ManterIntegranteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            RequestDispatcher view = request.getRequestDispatcher("/manterIntegrante.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        String cargaHorariaDisponivel = request.getParameter("txtCargaHorariaDisponivel");
        int idPessoa = Integer.parseInt(request.getParameter("selectPessoa"));
        try {
            Pessoa pessoa = null;
            if (idPessoa != 0) {
                pessoa = Pessoa.obterPessoa(idPessoa);
            }
            Integrante peca = new Integrante(matricula, cargaHorariaDisponivel, idPessoa);
            peca.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaIntegranteController");
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

    public void prepararEditar(HttpServletRequest request,
            HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        try {

            request.setAttribute("operacao", "Editar");
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
            Integrante integrante = Integrante.obterIntegrante(matricula);
            request.setAttribute("integrante", integrante);
            RequestDispatcher view = request.getRequestDispatcher("/manterIntegrante.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;

        } catch (IOException ex) {
            throw ex;

        } catch (ClassNotFoundException ex) {
            throw ex;

        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        String cargaHorariaDisponivel = request.getParameter("txtCargaHorariaDisponivel");
        int idPessoa = Integer.parseInt(request.getParameter("selectPessoa"));
        try {
            Pessoa pessoa = null;
            if (idPessoa != 0) {
                pessoa = Pessoa.obterPessoa(idPessoa);
            }
            Integrante integrante = new Integrante(matricula, cargaHorariaDisponivel, idPessoa);
            integrante.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaIntegranteController");
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

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            int idIntegrante = Integer.parseInt(request.getParameter("txtMatricula"));
            Integrante integrante = Integrante.obterIntegrante(idIntegrante);
            request.setAttribute("integrante", integrante);
            RequestDispatcher view = request.getRequestDispatcher("/manterIntegrante.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        int matricula = Integer.parseInt(request.getParameter("txtMatricula"));
        String cargaHorariaDisponivel = request.getParameter("txtCargaHorariaDisponivel");
        int idPessoa = Integer.parseInt(request.getParameter("selectPessoa"));
        try {
            Pessoa pessoa = null;
            if (idPessoa != 0) {
                pessoa = Pessoa.obterPessoa(idPessoa);
            }
            Integrante integrante = new Integrante(matricula, cargaHorariaDisponivel, idPessoa);
            integrante.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaIntegranteController");
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
    }    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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
            Logger.getLogger(ManterIntegranteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterIntegranteController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterIntegranteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterIntegranteController.class.getName()).log(Level.SEVERE, null, ex);
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
