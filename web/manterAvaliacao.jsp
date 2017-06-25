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
            <h3 align="center">${operacao} Avaliação</h3>
            <form action="ManterAvaliacaoController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterAvaliacao">
                <div class="row">
                    <div class="input-field col s6 offset-m3">
                        <input id="id" name="txtIdAvaliacao" type="text" class="validate" value="${avaliacao.idAvaliacao}" required="required" pattern="[0-9]+$" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="id">ID</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <p class="range-field">
                                <input type="range" id="frequencia" name="txtFrequencia" required="required"  min="0" max="100" value="${avaliacao.frequencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>/>
                            </p>   
                            <label for="frequencia">Frequência</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <select id="desempenhoNaAvaliacao" name="txtComparecimento" value="${avaliacao.comparecimento}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                              <option value="otimo" <c:if test="${avaliacao.comparecimento == 'otimo'}"> selected</c:if>>Ótimo</option>
                              <option value="bom" <c:if test="${avaliacao.comparecimento == 'bom'}"> selected</c:if>>Bom</option>
                              <option value="medio" <c:if test="${avaliacao.comparecimento == 'medio'}"> selected</c:if>>Médio</option>
                              <option value="ruim" <c:if test="${avaliacao.comparecimento == 'ruim'}"> selected</c:if>>Ruim</option>
                              <option value="pessimo" <c:if test="${avaliacao.comparecimento == 'pessimo'}"> selected</c:if>>Péssimo</option>
                            </select>
                            <label for="desempenhoNaAvaliacao">Desempenho na Avaliação</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="data" name="txtData" type="text" required="required" class="datepicker" value="${avaliacao.data}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <label for="data">Data</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                        <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectIntegrante" value="${avaliacao.FKintegrante.matricula}"></c:if>
                        <select id="integrante" name="selectIntegrante" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                            <c:forEach items="${integrantes}" var="integrante">
                                <option value="${integrante.matricula}" <c:if test="${avaliacao.FKintegrante.matricula == integrante.matricula}"> selected</c:if>> ${integrante.FKpessoa.nome} </option>
                            </c:forEach>
                        </select>
                        <label for="integrante">Integrante</label>
                    </div>
                </div>

                <div class="row">
                    <div class="col s12 center-align">
                        <button class="btn waves-effect waves-light brown darken-4" type="submit" value="Confirmar">
                            Confirmar <i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        $('select').material_select();

        $('body').css('background-image', "url('images/fundo.png')");

        $('.dropdown-button').dropdown({
            constrainWidth: false, // Does not change width of dropdown to that of the activator
            hover: true // Activate on hover
        });

        $('.datepicker').pickadate({
            closeOnClear: true,
            closeOnSelect: true,
            today: 'Hoje',
            clear: 'Limpar',
            close: 'Fechar',
            labelMonthNext: 'Próximo mês',
            labelMonthPrev: 'Mês Anterior',
            labelMonthSelect: 'Selecionar um mês',
            labelYearSelect: 'Selecionar um ano',
            monthsFull: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
            monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
            weekdaysFull: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
            weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
            weekdaysLetter: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
        });
    });
</script>