<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Cadastrar Design</title>
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
            <h1 align="center">${operacao}<br>Design </h1>
            <form class="form" action="ManterDesignController?acao=confirmar${operacao}" method="POST" name="frmManterDesign">
                <br>
                <abbr>Automóvel</abbr>
                <p>
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectAutomovel" value="${design.automovel.idAutomovel}"></c:if>
                    <select name="selectAutomovel" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${automoveis}" var="automovel">
                            <option value="${automovel.idAutomovel}" <c:if test="${design.automovel.idAutomovel == automovel.idAutomovel}"> selected</c:if>> ${automovel.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <abbr>ID</abbr>
                <p class="field">
                    <input name="txtIdDesign" type="text" required="required" placeholder="Digite apenas números!"  pattern="[0-9]+$" value="${design.idDesign}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Caminho Imagem</abbr>
                    <p class="field">
                        <input name="txtCaminhoImagem" type="text" required="required value="${design.caminhoImagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    <i class="fa fa-circle"></i>
                </p>
                <input type="submit" value="Confirmar">
            </form>
        </div>
    </body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        $('select').material_select();

        $('body').css('background-image', "url('images/b19.png')");

        $('.dropdown-button').dropdown({
            constrainWidth: false, // Does not change width of dropdown to that of the activator
            hover: true // Activate on hover
        });
    });
</script>