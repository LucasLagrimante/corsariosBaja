package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.CompeticaoDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Competicao;

/**
 *
 * @author Marco
 */
public class ManterCompeticaoController extends HttpServlet {

    private Competicao competicao;

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
                int codCompeticao = Integer.parseInt(request.getParameter("codCompeticao"));
                competicao = CompeticaoDAO.getInstance().getCompeticao(codCompeticao);
                request.setAttribute("competicao", competicao);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterCompeticao.jsp");
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
            int codCompeticao = Integer.parseInt(request.getParameter("codCompeticao"));
            String nome = request.getParameter("nomeCompeticao");
            int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
            String tipoCompeticao = request.getParameter("tipoCompeticao");
            int totalPeriodos = Integer.parseInt(request.getParameter("totalPeriodos"));
            int codCoordenador = Integer.parseInt(request.getParameter("coordenador"));
            Professor coordenador = null;
            if (codCoordenador != 0) {
                coordenador = ProfessorDAO.getInstance().getProfessor(codCoordenador);
            }
            if (operacao.equals("incluir")) {
                competicao = new Competicao(codCompeticao, nome, cargaHoraria, tipoCompeticao, totalPeriodos, coordenador);
                CompeticaoDAO.getInstance().salvar(competicao);
            } else if (operacao.equals("editar")) {
                competicao.setNome(nome);
                competicao.setCargaHoraria(cargaHoraria);
                competicao.setTipoCompeticao(tipoCompeticao);
                competicao.setTotalPeriodos(totalPeriodos);
                competicao.setCoordenador(coordenador);
                CompeticaoDAO.getInstance().salvar(competicao);
            } else if (operacao.equals("excluir")) {
                CompeticaoDAO.getInstance().excluir(competicao);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarCompeticaoController");
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
