package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.PessoaDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

/**
 *
 * @author Marco
 */
public class ManterPessoaController extends HttpServlet {

    private Pessoa pessoa;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }

    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("professores", ProfessorDAO.getInstance().getAllProfessores());
            if (!operacao.equals("incluir")) {
                int codPessoa = Integer.parseInt(request.getParameter("codPessoa"));
                pessoa = PessoaDAO.getInstance().getPessoa(codPessoa);
                request.setAttribute("pessoa", pessoa);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterPessoa.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            int codPessoa = Integer.parseInt(request.getParameter("codPessoa"));
            String nome = request.getParameter("nomePessoa");
            int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
            String tipoPessoa = request.getParameter("tipoPessoa");
            int totalPeriodos = Integer.parseInt(request.getParameter("totalPeriodos"));
            int codCoordenador = Integer.parseInt(request.getParameter("coordenador"));
            Professor coordenador = null;
            if (codCoordenador != 0) {
                coordenador = ProfessorDAO.getInstance().getProfessor(codCoordenador);
            }
            if (operacao.equals("incluir")) {
                pessoa = new Pessoa(codPessoa, nome, cargaHoraria, tipoPessoa, totalPeriodos, coordenador);
                PessoaDAO.getInstance().salvar(pessoa);
            } else if (operacao.equals("editar")) {
                pessoa.setNome(nome);
                pessoa.setCargaHoraria(cargaHoraria);
                pessoa.setTipoPessoa(tipoPessoa);
                pessoa.setTotalPeriodos(totalPeriodos);
                pessoa.setCoordenador(coordenador);
                PessoaDAO.getInstance().salvar(pessoa);
            } else if (operacao.equals("excluir")) {
                PessoaDAO.getInstance().excluir(pessoa);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarPessoaController");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
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

        processRequest(request, response);

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
        processRequest(request, response);

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
