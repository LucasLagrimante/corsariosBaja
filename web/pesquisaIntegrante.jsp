<%-- 
    Document   : pesquisaIntegrante
    Created on : 20/09/2016, 09:17:12
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Integrante</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <!--Import jQuery before materialize.js-->
        <script src="js/jquery-3.2.1.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <!-- Dropdown Structure -->
        <ul id="menuCadastro" class="dropdown-content">
            <li><a class="brown-text text-darken-4" href="ManterAutomovelController?acao=prepararIncluir">Automóvel</a></li>
            <li><a class="brown-text text-darken-4" href="ManterArquiteturaController?acao=prepararIncluir">Arquitetura</a></li>
            <li><a class="brown-text text-darken-4" href="ManterAvaliacaoController?acao=prepararIncluir">Avaliação</a></li>
            <li><a class="brown-text text-darken-4" href="ManterCompeticaoController?acao=prepararIncluir">Competição</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesempenhoController?acao=prepararIncluir">Desempenho de Competicão</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesempenhoTesteController?acao=prepararIncluir">Desempenho de Teste</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesignController?acao=prepararIncluir">Design</a></li>
            <li><a class="brown-text text-darken-4" href="ManterFrequenciaController?acao=prepararIncluir">Frequência</a></li>
            <li><a class="brown-text text-darken-4" href="ManterInvestidorController?acao=prepararIncluir">Investidor</a></li>
            <li><a class="brown-text text-darken-4" href="ManterIntegranteController?acao=prepararIncluir">Integrante</a></li>
            <li><a class="brown-text text-darken-4" href="ManterPecaController?acao=prepararIncluir">Peça</a></li>
            <li><a class="brown-text text-darken-4" href="ManterPessoaController?acao=prepararIncluir">Pessoa</a></li>
            <li><a class="brown-text text-darken-4" href="ManterTipoPecaController?acao=prepararIncluir">Tipo de Peça</a></li>
            <li><a class="brown-text text-darken-4" href="ManterTipoPistaController?acao=prepararIncluir">Tipo de Pista</a></li>
        </ul>
        <ul id="menuPesquisa" class="dropdown-content">
            <li><a class="brown-text text-darken-4" href="PesquisaAutomovelController">Automóvel</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaArquiteturaController">Arquitetura</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaAvaliacaoController">Avaliação</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaCompeticaoController">Competição</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaDesempenhoController">Desempenho de Competicão</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaDesempenhoTesteController">Desempenho de Teste</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaDesignController">Design</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaFrequenciaController">Frequência</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaInvestidorController">Investidor</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaIntegranteController">Integrante</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaPecaController">Peça</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaPessoaController">Pessoa</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaTipoPecaController">Tipo de Peça</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaTipoPistaController">Tipo de Pista</a></li>
        </ul>
        <nav>
            <div class="nav-wrapper brown darken-4">
                <a href="#!" class="brand-logo"><i class="material-icons">high_quality</i>Corrida Baja - Equipe Corsários</a>
                <ul class="right hide-on-med-and-down">
                    <!-- Dropdown Trigger -->
                    <li><a href="index.jsp">Início</a></li>
                    <li><a class="dropdown-button" href="#!" data-activates="menuCadastro">Cadastro<i class="material-icons right">arrow_drop_down</i></a></li>
                    <li><a class="dropdown-button" href="#!" data-activates="menuPesquisa">Pesquisa<i class="material-icons right">arrow_drop_down</i></a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
                <h3 align="center">Pesquisa de Integrante</h3>
                <table class="striped centered">
                    <thead>
                        <tr>
                            <th>Matricula</th>
                            <th>Carga Horaria Disponivel</th>
                            <th>Pessoa</th>
                            <th colspan="2">Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${integrantes}" var="integrante">
                            <tr>
                                <td><c:out value="${integrante.matricula}" /></td>
                                <td><c:out value="${integrante.cargaHorariaDisponivel}" /></td>
                                <td><c:out value="${integrante.idPessoa}" /></td>
                                <td><a class="brown-text text-darken-4" href="ManterIntegranteController?acao=prepararEditar&txtMatricula=<c:out value="${integrante.matricula}" />">Editar</a></td>
                                <td><a class="brown-text text-darken-4" href="ManterIntegranteController?acao=prepararExcluir&txtMatricula=<c:out value="${integrante.matricula}" />">Excluir</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            <div class="row">
                <div class="input-field col s4 center-align">
                    <select name="selectTipoRelatorio" required="required">
                        <option value="" disabled selected>Escolha...</option>
                        <option value="completo">Relatório Completo</option>
                        <option value="filtroPessoa">Filtro Por Pessoa</option>
                    </select>
                </div>

                <div class="input-field col s4 center-align">
                    <select name="selectPessoa" required="required">
                        <option value="" disabled selected>Escolha...</option>
                        <c:forEach items="${pessoas}" var="pessoa">
                            <option value="${pessoa}"> ${pessoa}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="input-field col s4 center-align">
                    <a class="waves-effect waves-light btn-large brown darken-4" id="imprimir">Imprimir <i class="material-icons right">print</i></a>
                </div>
            </div>
        </div>
    </body>
</html>
<script type="text/javascript">
    $(document).ready(function() {
        $('select').material_select();
        $("[name='selectTipoRelatorio']").material_select();
        $("[name='selectPessoa']").material_select('destroy');

        $('body').css('background-image', "url('images/fundo.png')");

        $('.dropdown-button').dropdown({
            constrainWidth: false, // Does not change width of dropdown to that of the activator
            hover: true // Activate on hover
        });

        $("#imprimir").click(function() {
            window.location.href = 'RelatorioController?relatorioNome=reportIntegrante.jasper';
        });

        $("[name='selectTipoRelatorio']").change(function() {
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "completo") {
                $("[name='selectTipoRelatorio']").material_select();
                $("[name='selectPessoa']").material_select('destroy');
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroPessoa") {
                $("[name='selectTipoRelatorio']").material_select();
                $("[name='selectPessoa']").material_select();
            }
        });
        $("#imprimir").click(function() {
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "completo") {
                window.location.href = 'RelatorioController?relatorioNome=reportIntegrante.jasper';
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroPessoa") {
                window.location.href = 'RelatorioController?relatorioNome=reportIntegrantePorPessoa.jasper&parametro=' + $("[name='selectPessoa'] option:selected").val();
            }

        });
    });
</script>