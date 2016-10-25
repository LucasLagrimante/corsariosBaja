<%-- 
    Document   : index
    Created on : 13/09/2016, 09:51:01
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link rel="stylesheet" type="text/css"  href="style/style.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href="#">Cadastrar</a>
                    <ul>
                        <li><a href="ManterAutomovelController?acao=prepararIncluir">Automovel</a></li>
                        <li><a href="ManterPecaController?acao=prepararIncluir">Peça</a></li>
                        <li><a href="ManterPessoaController?acao=prepararIncluir">Pessoa</a></li>
                        <li><a href="ManterIntegranteController?acao=prepararIncluir">Integrante</a></li>
                        <li><a href="ManterFrequenciaController?acao=prepararIncluir">Frequencia</a></li>
                        <li><a href="ManterAvaliacaoController?acao=prepararIncluir">Avaliacao</a></li>
                        <li><a href="ManterCompeticaoController?acao=prepararIncluir">Competição</a></li>
                        <li><a href="ManterDesempenhoTesteController?acao=prepararIncluir">Desempenho de Teste</a></li>
                        <li><a href="ManterDesempenhoController?acao=prepararIncluir">Desempenho de Competicão</a></li>
                        <li><a href="ManterArquiteturaController?acao=prepararIncluir">Arquitetura</a></li>
                        <li><a href="ManterDesignController?acao=prepararIncluir">Design</a></li>
                    </ul>
                </li>
                <li><a href="#">Pesquisar</a>
                    <ul>
                        <li><a href="PesquisaAutomovelController">Automovel</a></li>
                        <li><a href="PesquisaPecaController">Peça</a></li>
                        <li><a href="PesquisaPessoaController">Pessoa</a></li>
                        <li><a href="PesquisaIntegranteController">Integrante</a></li>
                        <li><a href="PesquisaFrequenciaController">Frequencia</a></li>
                        <li><a href="PesquisaAvaliacaoController">Avaliacao</a></li>
                        <li><a href="PesquisaCompeticaoController">Competição</a></li>
                        <li><a href="PesquisaDesempenhoTesteController">Desempenho de Teste</a></li>
                        <li><a href="PesquisaDesempenhoController">Desempenho de Competicão</a></li>
                        <li><a href="PesquisaArquiteturaController">Arquitetura</a></li>
                        <li><a href="PesquisaDesignController">Design</a></li>
                    </ul>
                </li>
                <li><a href="#">Investimentos</a>
                    <ul>
                        <li><a href="#">Investir</a></li>
                        <li><a href="#">Cofre</a></li>
                    </ul>
                </li>
                <li><a href="#">Relatórios</a>
                    <ul>
                        <li><a href="#">Integrantes</a></li>
                        <li><a href="#">Desempenho Comparativo</a></li>
                    </ul>
                </li>
                <li><a href="#">Exibir</a>
                    <ul>
                        <li><a href="#">Informações do Veículo</a></li>
                        <li><a href="#">Banco de Peças</a></li>
                        <li><a href="#">Arquitetura</a></li>
                        <li><a href="#">Design</a></li>
                        <li><a href="#">Custo Total</a></li>
                    </ul>
                </li>
                <li><a href="javascript:void()" onclick="window.close()">Sair</a></li>
            </ul>
            <div align="center" top="900px"><h1 fontsize="90">Carro de Corrida Baja - Equipe Corsários</h1></div>
    </body>
</html>
