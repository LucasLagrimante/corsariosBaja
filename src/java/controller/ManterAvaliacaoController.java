package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.AvaliacaoDAO;
import dao.IntegranteDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Avaliacao;
import model.Integrante;

/**
 *
 * @author Marco
 */
public class ManterAvaliacaoController extends HttpServlet {

    private Avaliacao avaliacao;

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
            //chave estrangeira
            request.setAttribute("integrantes", IntegranteDAO.getInstance().obterIntegrantes());
            //fim chave estrangeira
            if (!operacao.equals("Incluir")) {
                Integer idAvaliacao = Integer.parseInt(request.getParameter("idAvaliacao"));
                avaliacao = AvaliacaoDAO.getInstance().getAvaliacao(idAvaliacao);
                request.setAttribute("avaliacao", avaliacao);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterAvaliacao.jsp");
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
            int idAvaliacao = Integer.parseInt(request.getParameter("txtIdAvaliacao"));
            int frequencia = Integer.parseInt(request.getParameter("txtFrequencia"));
            String comparecimento = request.getParameter("txtComparecimento");
            String data = request.getParameter("txtData");
            //chave estrangeira
            Integer matricula = Integer.parseInt(request.getParameter("selectIntegrante"));
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = IntegranteDAO.getInstance().getIntegrante(matricula);
            }
            //fim chave estrangeira
            switch (operacao) {
                case "Incluir":
                    avaliacao = new Avaliacao(idAvaliacao, frequencia, comparecimento, data, integrante);
                    AvaliacaoDAO.getInstance().salvar(avaliacao);
                    break;
                case "Editar":
                    avaliacao.setFrequencia(frequencia);
                    avaliacao.setComparecimento(comparecimento);
                    avaliacao.setData(data);
                    avaliacao.setFKintegrante(integrante);
                    AvaliacaoDAO.getInstance().alterar(avaliacao);
                    break;
                case "Excluir":
                    AvaliacaoDAO.getInstance().excluir(avaliacao);
                    break;
                default:
                    break;
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarAvaliacaoController");
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
