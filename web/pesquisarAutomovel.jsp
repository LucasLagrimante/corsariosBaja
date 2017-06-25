<%-- 
    Document   : pesquisaAutomovel
    Created on : 20/09/2016, 09:17:12
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Automóvel</title>
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
            <li><a class="brown-text text-darken-4" href="ManterAutomovelController?acao=prepararOperacao&operacao=Incluir">Automóvel</a></li>
            <li><a class="brown-text text-darken-4" href="ManterArquiteturaController?acao=prepararOperacao&operacao=Incluir">Arquitetura</a></li>
            <li><a class="brown-text text-darken-4" href="ManterAvaliacaoController?acao=prepararOperacao&operacao=Incluir">Avaliação</a></li>
            <li><a class="brown-text text-darken-4" href="ManterCompeticaoController?acao=prepararOperacao&operacao=Incluir">Competição</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesempenhoController?acao=prepararOperacao&operacao=Incluir">Desempenho de Competicão</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesempenhotesteController?acao=prepararOperacao&operacao=Incluir">Desempenho de Teste</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesignController?acao=prepararOperacao&operacao=Incluir">Design</a></li>
            <li><a class="brown-text text-darken-4" href="ManterFrequenciaController?acao=prepararOperacao&operacao=Incluir">Frequência</a></li>
            <li><a class="brown-text text-darken-4" href="ManterIntegranteController?acao=prepararOperacao&operacao=Incluir">Integrante</a></li>
            <li><a class="brown-text text-darken-4" href="ManterPecaController?acao=prepararOperacao&operacao=Incluir">Peça</a></li>
            <li><a class="brown-text text-darken-4" href="ManterPessoaController?acao=prepararOperacao&operacao=Incluir">Pessoa</a></li>
            <li><a class="brown-text text-darken-4" href="ManterTipopecaController?acao=prepararOperacao&operacao=Incluir">Tipo de Peça</a></li>
            <li><a class="brown-text text-darken-4" href="ManterTipopistaController?acao=prepararOperacao&operacao=Incluir">Tipo de Pista</a></li>
        </ul>
        <ul id="menuPesquisa" class="dropdown-content">
            <li><a class="brown-text text-darken-4" href="PesquisarAutomovelController">Automóvel</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarArquiteturaController">Arquitetura</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarAvaliacaoController">Avaliação</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarCompeticaoController">Competição</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarDesempenhoController">Desempenho de Competicão</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarDesempenhotesteController">Desempenho de Teste</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarDesignController">Design</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarFrequenciaController">Frequência</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarIntegranteController">Integrante</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarPecaController">Peça</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarPessoaController">Pessoa</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarTipopecaController">Tipo de Peça</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisarTipopistaController">Tipo de Pista</a></li>
        </ul>
        <nav>
            <div class="nav-wrapper brown darken-4">
                <a href="#!" class="brand-logo"><i class="material-icons">high_quality</i>Corrida Baja - Equipe Corsários</a>
                <ul class="right hide-on-med-and-down">
                    <!-- Dropdown Trigger -->
                    <li><a href="index.jsp">Início</a></li>
                    <li><a href="relatorios.jsp">Relatórios</a></li>
                    <li><a class="dropdown-button" href="#!" data-activates="menuCadastro">Cadastro<i class="material-icons right">arrow_drop_down</i></a></li>
                    <li><a class="dropdown-button" href="#!" data-activates="menuPesquisa">Pesquisa<i class="material-icons right">arrow_drop_down</i></a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <h3 align="center">Pesquisa de Automóvel</h3>
            <table class="striped centered">
                <thead>
                    <tr>
                        <th>Código Automóvel</th>
                        <th>Nome Automóvel</th>
                        <th>Cor</th>
                        <th>Data de término do projeto</th>
                        <th>Peso Carro</th>
                        <th>Peso Chassi</th>
                        <th>Custo Total</th>
                        <th colspan="2">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${automoveis}" var="automovel">
                        <tr>
                            <td>${automovel.idAutomovel}</td>
                            <td>${automovel.nome}</td>
                            <td>${automovel.cor}</td>
                            <td>${automovel.dataTerminoProjeto}</td>
                            <td>${automovel.pesoCarro}</td>
                            <td>${automovel.pesoChassi}</td>
                            <td>${automovel.custoTotal}</td>
                            <td><a class="brown-text text-darken-4" href="ManterAutomovelController?acao=prepararOperacao&operacao=Editar&idAutomovel=${automovel.idAutomovel}">Editar</a></td>
                            <td><a class="brown-text text-darken-4" href="ManterAutomovelController?acao=prepararOperacao&operacao=Excluir&idAutomovel=${automovel.idAutomovel}">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="input-field col s4 center-align">
                    <select name="selectTipoRelatorio" required="required">
                        <option value="" disabled selected>Escolha...</option>
                        <option value="completo">Relatório Completo</option>
                        <option value="filtroCor">Filtro Por Cor</option>
                        <option value="filtroPeso">Filtro Por Peso do Carro</option>
                    </select>
                </div>

                <div class="input-field col s4 center-align">
                    <select name="selectCor" required="required">
                        <option value="" disabled selected>Escolha...</option>
                        <c:forEach items="${automoveis}" var="automovel">
                            <option value="${automovel.cor}"> ${automovel.cor}</option>
                        </c:forEach>
                    </select>

                    <select name="selectPeso" required="required"> 
                        <option value="" disabled selected>Escolha...</option>
                        <c:forEach items="${automoveis}" var="automovel">
                            <option value="${automovel.pesoCarro}"> ${automovel.pesoCarro}</option>
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
    $(document).ready(function () {
        $("[name='selectTipoRelatorio']").material_select();
        $("[name='selectCor']").material_select('destroy');
        $("[name='selectPeso']").material_select('destroy');

        $('body').css('background-image', "url('images/fundo.png')");

        $('.dropdown-button').dropdown({
            constrainWidth: false, // Does not change width of dropdown to that of the activator
            hover: true // Activate on hover
        });

        $("[name='selectTipoRelatorio']").change(function () {
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "completo") {
                $("[name='selectCor']").material_select('destroy');
                $("[name='selectPeso']").material_select('destroy');
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroCor") {
                $("[name='selectCor']").material_select();
                $("[name='selectPeso']").material_select('destroy');
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroPeso") {
                $("[name='selectCor']").material_select('destroy');
                $("[name='selectPeso']").material_select();
            }
        });
        $("#imprimir").click(function () {
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "completo") {
                window.location.href = 'RelatorioController?relatorioNome=reportAutomovel.jasper';
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroCor") {
                window.location.href = 'RelatorioController?relatorioNome=reportAutomovelPorCor.jasper&parametro=' + $("[name='selectCor'] option:selected").val();
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroPeso") {
                window.location.href = 'RelatorioController?relatorioNome=reportAutomovelPorPeso.jasper&parametro=' + $("[name='selectPeso'] option:selected").val();
            }
        });
    });
</script>
