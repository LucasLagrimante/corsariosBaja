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
                        <li><a href="#">Veículo</a></li>
                        <li><a href="#">Dados do Veículo</a></li>
                        <li><a href="#">Peça</a></li>
                        <li><a href="#">Pessoa</a></li>
                        <li><a href="#">Integrante</a></li>
                        <li><a href="#">Rendimento</a></li>
                        <li><a href="#">Frequencia</a></li>
                        <li><a href="#">Competição</a></li>
                        <li><a href="#">Desempenho de Teste</a></li>
                        <li><a href="#">Desempenho de Competicão</a></li>
                    </ul>
                </li>
                <li><a href="#">Pesquisar</a>
                    <ul>
                        <li><a href="PesquisaAutomovelController">Veículo</a></li>
                        <li><a href="PesquisaPecaController">Peça</a></li>
                        <li><a href="PesquisaPessoaController">Pessoa</a></li>
                        <li><a href="PesquisaIntegranteController">Integrante</a></li>
                        <li><a href="PesquisaFrequenciaController">Rendimento</a></li>
                        <li><a href="PesquisaFrequenciaController">Frequencia</a></li>
                        <li><a href="PesquisaCompeticaoController">Competição</a></li>
                        <li><a href="PesquisaDesempenhoTesteController">Desempenho de Teste</a></li>
                        <li><a href="PesquisaDesempenhoController">Desempenho de Competicão</a></li>
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
