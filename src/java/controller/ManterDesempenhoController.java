package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.AutomovelDAO;
import dao.DesempenhoDAO;
import dao.IntegranteDAO;
import dao.TipopistaDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Automovel;
import model.Desempenho;
import model.Integrante;
import model.Tipopista;

/**
 *
 * @author Marco
 */
public class ManterDesempenhoController extends HttpServlet {

    private Desempenho desempenho;

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
            request.setAttribute("tipospista", TipopistaDAO.getInstance().obterTipospista());
            request.setAttribute("integrantes", IntegranteDAO.getInstance().obterIntegrantes());
            //fim chave estrangeira
            if (!operacao.equals("incluir")) {
                int idDesempenho = Integer.parseInt(request.getParameter("txtIdDesempenho"));
                desempenho = DesempenhoDAO.getInstance().getDesempenho(idDesempenho);
                request.setAttribute("desempenho", desempenho);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterDesempenho.jsp");
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
            int idDesempenho = Integer.parseInt(request.getParameter("txtIdDesempenho"));
            String nome = request.getParameter("txtNome");
            String data = request.getParameter("txtData");
            String hora = request.getParameter("txtHora");
            float velocidadeMedia = Float.parseFloat(request.getParameter("txtVelocidadeMedia"));
            float aceleracaoMedia = Float.parseFloat(request.getParameter("txtAceleracaoMedia"));
            String tempoPista = request.getParameter("txtTempoPista");
            float frenagem = Float.parseFloat(request.getParameter("txtFrenagem"));
            //chave estrangeira
            int idAutomovel = Integer.parseInt(request.getParameter("selectAutomovel"));
            int idTipopista = Integer.parseInt(request.getParameter("selectTipoPista"));
            int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));
            Automovel automovel = null;
            if (idAutomovel != 0) {
                automovel = AutomovelDAO.getInstance().getAutomovel(idAutomovel);
            }
            Tipopista tipopista = null;
            if (idTipopista != 0) {
                tipopista = TipopistaDAO.getInstance().getTipopista(idTipopista);

            }
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = IntegranteDAO.getInstance().getIntegrante(matricula);
            }
            //fim chave estrangeira
            if (operacao.equals("incluir")) {
                Desempenho desempenho = new Desempenho(idDesempenho, nome, data, hora, velocidadeMedia, aceleracaoMedia, tempoPista, frenagem, automovel, integrante, tipopista);

                DesempenhoDAO.getInstance().salvar(desempenho);
            } else if (operacao.equals("editar")) {
                desempenho.setNome(nome);
                desempenho.setData(data);
                desempenho.setHora(hora);
                desempenho.setVelocidadeMedia(velocidadeMedia);
                desempenho.setAceleracaoMedia(aceleracaoMedia);
                desempenho.setTempoPista(tempoPista);
                desempenho.setFrenagem(frenagem);
                desempenho.setFKautomovel(automovel);
                desempenho.setFKtipopista(tipopista);
                desempenho.setFKmotorista(integrante);

                DesempenhoDAO.getInstance().salvar(desempenho);
            } else if (operacao.equals("excluir")) {
                DesempenhoDAO.getInstance().excluir(desempenho);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarDesempenhoController");
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
