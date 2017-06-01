package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.ArquiteturaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Arquitetura;

/**
 *
 * @author Marco
 */
public class ManterArquiteturaController extends HttpServlet {

    private Arquitetura arquitetura;

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
                int codArquitetura = Integer.parseInt(request.getParameter("codArquitetura"));
                arquitetura = ArquiteturaDAO.getInstance().getArquitetura(codArquitetura);
                request.setAttribute("arquitetura", arquitetura);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterArquitetura.jsp");
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
            int codArquitetura = Integer.parseInt(request.getParameter("codArquitetura"));
            String nome = request.getParameter("nomeArquitetura");
            int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
            String tipoArquitetura = request.getParameter("tipoArquitetura");
            int totalPeriodos = Integer.parseInt(request.getParameter("totalPeriodos"));
            int codCoordenador = Integer.parseInt(request.getParameter("coordenador"));
            Professor coordenador = null;
            if (codCoordenador != 0) {
                coordenador = ProfessorDAO.getInstance().getProfessor(codCoordenador);
            }
            if (operacao.equals("incluir")) {
                arquitetura = new Arquitetura(codArquitetura, nome, cargaHoraria, tipoArquitetura, totalPeriodos, coordenador);
                ArquiteturaDAO.getInstance().salvar(arquitetura);
            } else if (operacao.equals("editar")) {
                arquitetura.setNome(nome);
                arquitetura.setCargaHoraria(cargaHoraria);
                arquitetura.setTipoArquitetura(tipoArquitetura);
                arquitetura.setTotalPeriodos(totalPeriodos);
                arquitetura.setCoordenador(coordenador);
                ArquiteturaDAO.getInstance().salvar(arquitetura);
            } else if (operacao.equals("excluir")) {
                ArquiteturaDAO.getInstance().excluir(arquitetura);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarArquiteturaController");
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
