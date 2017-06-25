package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.TipopistaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tipopista;

/**
 *
 * @author Marco
 */
public class ManterTipopistaController extends HttpServlet {

    private Tipopista tipopista;

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
                Integer idTipopista = Integer.parseInt(request.getParameter("idTipopista"));
                tipopista = TipopistaDAO.getInstance().getTipopista(idTipopista);
                request.setAttribute("tipopista", tipopista);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterTipopista.jsp");
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
            int idTipopista = Integer.parseInt(request.getParameter("txtIdTipopista"));
            String nome = request.getParameter("txtNome");
            switch (operacao) {
                case "Incluir":
                    tipopista = new Tipopista(idTipopista, nome);
                    TipopistaDAO.getInstance().salvar(tipopista);
                    break;
                case "Editar":
                    tipopista.setNome(nome);
                    TipopistaDAO.getInstance().alterar(tipopista);
                    break;
                case "Excluir":
                    TipopistaDAO.getInstance().excluir(tipopista);
                    break;
                default:
                    break;
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarTipopistaController");
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
