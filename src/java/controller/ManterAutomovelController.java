package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.AutomovelDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Automovel;

/**
 *
 * @author Marco
 */
public class ManterAutomovelController extends HttpServlet {

    private Automovel automovel;

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
            if (!operacao.equals("Incluir")) {
                int idAutomovel = Integer.parseInt(request.getParameter("idAutomovel"));
                automovel = AutomovelDAO.getInstance().getAutomovel(idAutomovel);
                request.setAttribute("automovel", automovel);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterAutomovel.jsp");
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
            int idAutomovel = Integer.parseInt(request.getParameter("txtIdAutomovel"));
            String cor = request.getParameter("txtCor");
            String nome = request.getParameter("txtNome");
            String dataTerminoProjeto = request.getParameter("txtDataTerminoProjeto");
            float pesoCarro = Float.parseFloat(request.getParameter("txtPesoCarro"));
            float pesoChassi = Float.parseFloat(request.getParameter("txtPesoChassi"));
            float custoTotal = Float.parseFloat(request.getParameter("txtCustoTotal"));
            switch (operacao) {
                case "Incluir":
                    automovel = new Automovel(idAutomovel, cor, nome, dataTerminoProjeto, pesoCarro, pesoChassi, custoTotal);
                    AutomovelDAO.getInstance().salvar(automovel);
                    break;
                case "Editar":
                    automovel.setCor(cor);
                    automovel.setNome(nome);
                    automovel.setDataTerminoProjeto(dataTerminoProjeto);
                    automovel.setPesoCarro(pesoCarro);
                    automovel.setPesoChassi(pesoChassi);
                    automovel.setCustoTotal(custoTotal);
                    AutomovelDAO.getInstance().alterar(automovel);
                    break;
                case "Excluir":
                    AutomovelDAO.getInstance().excluir(automovel);
                    break;
                default:
                    break;
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarAutomovelController");
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
