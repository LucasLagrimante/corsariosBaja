<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar Avaliacao</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <meta charset="utf-8">
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
            <li><a href="ManterAutomovelController?acao=prepararIncluir">Automóvel</a></li>
            <li><a href="ManterArquiteturaController?acao=prepararIncluir">Arquitetura</a></li>
            <li><a href="ManterAvaliacaoController?acao=prepararIncluir">Avaliação</a></li>
            <li><a href="ManterCompeticaoController?acao=prepararIncluir">Competição</a></li>
            <li><a href="ManterDesempenhoController?acao=prepararIncluir">Desempenho de Competicão</a></li>
            <li><a href="ManterDesempenhoTesteController?acao=prepararIncluir">Desempenho de Teste</a></li>
            <li><a href="ManterDesignController?acao=prepararIncluir">Design</a></li>
            <li><a href="ManterFrequenciaController?acao=prepararIncluir">Frequência</a></li>
            <li><a href="ManterInvestidorController?acao=prepararIncluir">Investidor</a></li>
            <li><a href="ManterIntegranteController?acao=prepararIncluir">Integrante</a></li>
            <li><a href="ManterPecaController?acao=prepararIncluir">Peça</a></li>
            <li><a href="ManterPessoaController?acao=prepararIncluir">Pessoa</a></li>
            <li><a href="ManterTipoPecaController?acao=prepararIncluir">Tipo de Peça</a></li>
            <li><a href="ManterTipoPistaController?acao=prepararIncluir">Tipo de Pista</a></li>
        </ul>
        <ul id="menuPesquisa" class="dropdown-content">
            <li><a href="PesquisaAutomovelController">Automóvel</a></li>
            <li><a href="PesquisaArquiteturaController">Arquitetura</a></li>
            <li><a href="PesquisaAvaliacaoController">Avaliação</a></li>
            <li><a href="PesquisaCompeticaoController">Competição</a></li>
            <li><a href="PesquisaDesempenhoController">Desempenho de Competicão</a></li>
            <li><a href="PesquisaDesempenhoTesteController">Desempenho de Teste</a></li>
            <li><a href="PesquisaDesignController">Design</a></li>
            <li><a href="PesquisaFrequenciaController">Frequência</a></li>
            <li><a href="PesquisaInvestidorController">Investidor</a></li>
            <li><a href="PesquisaIntegranteController">Integrante</a></li>
            <li><a href="PesquisaPecaController">Peça</a></li>
            <li><a href="PesquisaPessoaController">Pessoa</a></li>
            <li><a href="PesquisaTipoPecaController">Tipo de Peça</a></li>
            <li><a href="PesquisaTipoPistaController">Tipo de Pista</a></li>
        </ul>
        <nav>
            <div class="nav-wrapper blue-text teal darken-3">
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
            <h1 align="center">${operacao}<br>Avaliação</h1>
            <form class="form"  action="ManterAvaliacaoController?acao=confirmar${operacao}" method="POST" name="frmManterAvaliacao">
                <br>
                <abbr>ID</abbr>
                <p class="field">
                    <input name="txtIdAvaliacao" type="text" value="${avaliacao.idAvaliacao}" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>          <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Frequencia</abbr>
                    <p class="field">
                        <input name="txtFrequencia" type="text" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!" value="${avaliacao.frequencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>    </select>           <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Desempenho na Avaliação</abbr>
                    <p class="field">
                        <select name="txtComparecimento" value="${avaliacao.comparecimento}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                          <option value="otimo" <c:if test="${avaliacao.comparecimento == 'otimo'}"> selected</c:if>>Ótimo</option>
                          <option value="bom" <c:if test="${avaliacao.comparecimento == 'bom'}"> selected</c:if>>Bom</option>
                          <option value="medio" <c:if test="${avaliacao.comparecimento == 'medio'}"> selected</c:if>>Médio</option>
                          <option value="ruim" <c:if test="${avaliacao.comparecimento == 'ruim'}"> selected</c:if>>Ruim</option>
                          <option value="pessimo" <c:if test="${avaliacao.comparecimento == 'pessimo'}"> selected</c:if>>Péssimo</option>
                        </select>
                    </p>
                    <br>
                    <abbr>Data</abbr>
                    <p class="field">
                        <input name="txtData" type="text" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18" value="${avaliacao.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>          <i class="fa fa-circle"></i>
                    </p>


                    <abbr>Integrante</abbr>
                    <p class="field">
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectIntegrante" value="${avaliacao.integrante.matricula}"></c:if>
                    <select name="selectIntegrante" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${integrantes}" var="integrante">
                            <option value="${integrante.matricula}" <c:if test="${avaliacao.integrante.matricula == integrante.matricula}"> selected</c:if>> ${integrante.pessoa.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <input type="submit" value="Confirmar">
            </form>
        </div>
    </body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        $('select').material_select();
        $('.dropdown-button').dropdown({
            constrainWidth: false, // Does not change width of dropdown to that of the activator
            hover: true // Activate on hover
        });
    });
</script>