package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.FrequenciaDAO;
import dao.IntegranteDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Frequencia;
import model.Integrante;

/**
 *
 * @author Marco
 */
public class ManterFrequenciaController extends HttpServlet {

    private Frequencia frequencia;

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
            //chave estrangeira
            request.setAttribute("integrantes", IntegranteDAO.getInstance().obterIntegrantes());
            //fim chave estrangeira
            if (!operacao.equals("incluir")) {
                int idFrequencia = Integer.parseInt(request.getParameter("txtIdFrequencia"));
                frequencia = FrequenciaDAO.getInstance().getFrequencia(idFrequencia);
                request.setAttribute("frequencia", frequencia);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterFrequencia.jsp");
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
            int idFrequencia = Integer.parseInt(request.getParameter("txtIdFrequencia"));
            String data = request.getParameter("txtData");
            String estado = request.getParameter("radioEstado");
            //chave estrangeira
            int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));
            Integrante integrante = null;

            if (matricula != 0) {
                integrante = IntegranteDAO.getInstance().getIntegrante(matricula);
            }
            if (operacao.equals("incluir")) {
                Frequencia frequencia = new Frequencia(idFrequencia, data, estado, integrante);
                FrequenciaDAO.getInstance().salvar(frequencia);
            } else if (operacao.equals("editar")) {
                frequencia.setData(data);
                frequencia.setEstado(estado);
                frequencia.setFKintegrante(integrante);
                FrequenciaDAO.getInstance().salvar(frequencia);
            } else if (operacao.equals("excluir")) {
                FrequenciaDAO.getInstance().excluir(frequencia);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarFrequenciaController");
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
            Logger.getLogger(ManterFrequenciaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFrequenciaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterFrequenciaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFrequenciaController.class.getName()).log(Level.SEVERE, null, ex);
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
