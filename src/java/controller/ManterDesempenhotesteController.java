package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.DesempenhotesteDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Desempenhoteste;

/**
 *
 * @author Marco
 */
public class ManterDesempenhotesteController extends HttpServlet {

    private Desempenhoteste desempenhoteste;

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
                int codDesempenhoteste = Integer.parseInt(request.getParameter("codDesempenhoteste"));
                desempenhoteste = DesempenhotesteDAO.getInstance().getDesempenhoteste(codDesempenhoteste);
                request.setAttribute("desempenhoteste", desempenhoteste);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterDesempenhoteste.jsp");
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
            int codDesempenhoteste = Integer.parseInt(request.getParameter("codDesempenhoteste"));
            String nome = request.getParameter("nomeDesempenhoteste");
            int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
            String tipoDesempenhoteste = request.getParameter("tipoDesempenhoteste");
            int totalPeriodos = Integer.parseInt(request.getParameter("totalPeriodos"));
            int codCoordenador = Integer.parseInt(request.getParameter("coordenador"));
            Professor coordenador = null;
            if (codCoordenador != 0) {
                coordenador = ProfessorDAO.getInstance().getProfessor(codCoordenador);
            }
            if (operacao.equals("incluir")) {
                desempenhoteste = new Desempenhoteste(codDesempenhoteste, nome, cargaHoraria, tipoDesempenhoteste, totalPeriodos, coordenador);
                DesempenhotesteDAO.getInstance().salvar(desempenhoteste);
            } else if (operacao.equals("editar")) {
                desempenhoteste.setNome(nome);
                desempenhoteste.setCargaHoraria(cargaHoraria);
                desempenhoteste.setTipoDesempenhoteste(tipoDesempenhoteste);
                desempenhoteste.setTotalPeriodos(totalPeriodos);
                desempenhoteste.setCoordenador(coordenador);
                DesempenhotesteDAO.getInstance().salvar(desempenhoteste);
            } else if (operacao.equals("excluir")) {
                DesempenhotesteDAO.getInstance().excluir(desempenhoteste);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarDesempenhotesteController");
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
