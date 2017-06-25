package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.AutomovelDAO;
import dao.DesignDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Automovel;
import model.Design;

/**
 *
 * @author Marco
 */
public class ManterDesignController extends HttpServlet {

    private Design design;

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
            request.setAttribute("automoveis", AutomovelDAO.getInstance().obterAutomoveis());
            //fim chave estrangeira
            if (!operacao.equals("Incluir")) {
                Integer idDesign = Integer.parseInt(request.getParameter("idDesign"));
                design = DesignDAO.getInstance().getDesign(idDesign);
                request.setAttribute("design", design);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterDesign.jsp");
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
            int idDesign = Integer.parseInt(request.getParameter("txtIdDesign"));
            String caminhoImagem = request.getParameter("txtCaminhoImagem");
            //cheve estrangeira
            Integer idAutomovel = Integer.parseInt(request.getParameter("selectAutomovel"));
            Automovel automovel = null;
            if (idAutomovel != 0) {
                automovel = AutomovelDAO.getInstance().getAutomovel(idAutomovel);
            }
            switch (operacao) {
                case "Incluir":
                    design = new Design(idDesign, caminhoImagem, automovel);
                    DesignDAO.getInstance().salvar(design);
                    break;
                case "Editar":
                    design.setCaminhoImagem(caminhoImagem);
                    design.setFKautomovel(automovel);
                    DesignDAO.getInstance().alterar(design);
                    break;
                case "Excluir":
                    DesignDAO.getInstance().excluir(design);
                    break;
                default:
                    break;
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarDesignController");
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
