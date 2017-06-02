package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.PecaDAO;
import dao.TipopecaDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Peca;
import model.Tipopeca;

/**
 *
 * @author Marco
 */
public class ManterPecaController extends HttpServlet {

    private Peca peca;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }

    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("tipospeca", TipopecaDAO.getInstance().obterTipospeca());
            if (!operacao.equals("incluir")) {
                int idPeca = Integer.parseInt(request.getParameter("txtIdPeca"));
                peca = PecaDAO.getInstance().getPeca(idPeca);
                request.setAttribute("peca", peca);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterPeca.jsp");
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
            int idPeca = Integer.parseInt(request.getParameter("txtIdPeca"));
            int quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));
            String nome = request.getParameter("txtNome");
            String modelo = request.getParameter("txtModelo");
            float precoCompra = Float.parseFloat(request.getParameter("txtPrecoCompra"));
            //chave estrangeira
            int idTipoPeca = Integer.parseInt(request.getParameter("selectTipoPeca"));
            Tipopeca tipopeca = null;
            if (idTipoPeca != 0) {
                tipopeca = TipopecaDAO.getInstance().getTipopeca(idTipoPeca);
            }
            if (operacao.equals("incluir")) {
                Peca peca = new Peca(idPeca, quantidade, nome, modelo, precoCompra, tipopeca);
                PecaDAO.getInstance().salvar(peca);
            } else if (operacao.equals("editar")) {
                peca.setQuantidade(quantidade);
                peca.setNome(nome);
                peca.setModelo(modelo);
                peca.setPrecoCompra(precoCompra);
                peca.setFKtipopeca(tipopeca);

                PecaDAO.getInstance().salvar(peca);
            } else if (operacao.equals("excluir")) {
                PecaDAO.getInstance().excluir(peca);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarPecaController");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPecaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPecaController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPecaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPecaController.class.getName()).log(Level.SEVERE, null, ex);
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
