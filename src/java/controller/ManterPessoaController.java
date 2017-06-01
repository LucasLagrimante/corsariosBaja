package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.PessoaDAO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

/**
 *
 * @author Marco
 */
public class ManterPessoaController extends HttpServlet {

    private Pessoa Pessoa;

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
            if (!operacao.equals("incluir")) {
                int idPessoa = Integer.parseInt(request.getParameter("txtIdPessoa"));
                Pessoa = PessoaDAO.getInstance().getPessoa(idPessoa);
                request.setAttribute("Pessoa", Pessoa);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterPessoa.jsp");
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
            int idPessoa = Integer.parseInt(request.getParameter("txtIdPessoa"));
            String nome = request.getParameter("txtNome");
            String cpf = request.getParameter("txtCpf");
            String logradouro = request.getParameter("txtLogradouro");
            String cep = request.getParameter("txtCep");
            String bairro = request.getParameter("txtBairro");
            String uf = request.getParameter("txtUf");
            String numero = request.getParameter("txtNumero");
            String telefone = request.getParameter("txtTelefone");
            if (operacao.equals("incluir")) {
            Pessoa pessoa = new Pessoa(idPessoa, nome, cpf, logradouro, cep, bairro, uf, numero, telefone);
                PessoaDAO.getInstance().salvar(Pessoa);
            } else if (operacao.equals("editar")) {
               
                Pessoa.setNome(nome);
                 Pessoa.setCpf(cpf);
                Pessoa.setLogradouro(logradouro);
                Pessoa.setCep(cep);
                Pessoa.setBairro(bairro);
                Pessoa.setUf(uf);
                Pessoa.setNumero(numero);
                Pessoa.setTelefone(telefone);
                PessoaDAO.getInstance().salvar(Pessoa);
                
            } else if (operacao.equals("excluir")) {
                PessoaDAO.getInstance().excluir(Pessoa);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarPessoaController");
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
