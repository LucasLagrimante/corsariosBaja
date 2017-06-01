package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.IntegranteDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Integrante;

/**
 *
 * @author Marco
 */
public class ManterIntegranteController extends HttpServlet {

    private Integrante integrante;

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
                int codIntegrante = Integer.parseInt(request.getParameter("codIntegrante"));
                integrante = IntegranteDAO.getInstance().getIntegrante(codIntegrante);
                request.setAttribute("integrante", integrante);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterIntegrante.jsp");
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
            int codIntegrante = Integer.parseInt(request.getParameter("codIntegrante"));
            String nome = request.getParameter("nomeIntegrante");
            int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
            String tipoIntegrante = request.getParameter("tipoIntegrante");
            int totalPeriodos = Integer.parseInt(request.getParameter("totalPeriodos"));
            int codCoordenador = Integer.parseInt(request.getParameter("coordenador"));
            Professor coordenador = null;
            if (codCoordenador != 0) {
                coordenador = ProfessorDAO.getInstance().getProfessor(codCoordenador);
            }
            if (operacao.equals("incluir")) {
                integrante = new Integrante(codIntegrante, nome, cargaHoraria, tipoIntegrante, totalPeriodos, coordenador);
                IntegranteDAO.getInstance().salvar(integrante);
            } else if (operacao.equals("editar")) {
                integrante.setNome(nome);
                integrante.setCargaHoraria(cargaHoraria);
                integrante.setTipoIntegrante(tipoIntegrante);
                integrante.setTotalPeriodos(totalPeriodos);
                integrante.setCoordenador(coordenador);
                IntegranteDAO.getInstance().salvar(integrante);
            } else if (operacao.equals("excluir")) {
                IntegranteDAO.getInstance().excluir(integrante);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarIntegranteController");
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
