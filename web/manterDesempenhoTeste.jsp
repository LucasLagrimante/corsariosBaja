<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Cadastrar Desempenho de Teste</title>
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
            <h1 align="center">${operacao}<br>Desempenho Teste</h1>
            <form class="form"  action="ManterDesempenhoTesteController?acao=confirmar${operacao}" method="POST" name="frmManterDesempenhoTeste">
                <br>

                <abbr>Automóvel</abbr>
                <p class="field">
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectAutomovel" value="${desempenhoTeste.automovel.idAutomovel}"></c:if>
                    <select name="selectAutomovel" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${automoveis}" var="automovel">
                            <option value="${automovel.idAutomovel}" <c:if test="${desempenhoTeste.automovel.idAutomovel == automovel.idAutomovel}"> selected</c:if>> ${automovel.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <abbr>Tipo Pista</abbr>
                <p class="field">
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectTipoPista" value="${desempenhoTeste.tipopista.idTipoPista}"></c:if>
                    <select name="selectTipoPista" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${tipospista}" var="tipopista">
                            <option value="${tipopista.idTipoPista}" <c:if test="${desempenhoTeste.tipopista.idTipoPista == tipopista.idTipoPista}"> selected</c:if>> ${tipopista.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <abbr>Motorista</abbr>
                <p>
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectIntegrante" value="${desempenhoTeste.integrante.matricula}"></c:if>
                    <select name="selectIntegrante" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${integrantes}" var="integrante">
                            <option value="${integrante.matricula}" <c:if test="${desempenhoTeste.integrante.matricula == integrante.matricula}"> selected</c:if>> ${integrante.pessoa.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <abbr>ID</abbr>
                <p class="field">
                    <input name="txtIdDesempenhoTeste" value="${desempenhoTeste.idDesempenhoTeste}" placeholder="Digite apenas números!"  type="text" required="required" pattern="[0-9]+$" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Nome desempenho</abbr>
                    <p class="field">
                        <input name="txtNome" value="${desempenhoTeste.nome}" type="text" required="required" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Data</abbr>
                    <p class="field">
                        <input name="txtData" value="${desempenhoTeste.data}" type="text" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>><i class="fa fa-circle"></i>
                    </p>
                    <abbr>Hora</abbr>
                    <p class="field">
                        <input name="txtHora" value="${desempenhoTeste.hora}" type="text" required="required"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Aceleração Média</abbr>
                    <p class="field">
                        <input name="txtAceleracaoMedia" value="${desempenhoTeste.aceleracaoMedia}" placeholder="Digite apenas números!" type="text" required="required" pattern="(?:\d*\.)?\d+"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Velocidade Média</abbr>
                    <p class="field">
                        <input name="txtVelocidadeMedia" value="${desempenhoTeste.velocidadeMedia}" placeholder="Digite apenas números!"  type="text" required="required" pattern="(?:\d*\.)?\d+"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Tempo de Pista</abbr>
                    <p class="field">
                        <input name="txtTempoPista" value="${desempenhoTeste.tempoPista}" placeholder="Digite apenas números!"  required="required" type="text" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Frenagem</abbr>
                    <p class="field">
                        <input name="txtFrenagem" value="${desempenhoTeste.frenagem}" placeholder="Digite apenas números!"  type="text" required="required" pattern="(?:\d*\.)?\d+" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
        $('.dropdown-button').dropdown({
            constrainWidth: false, // Does not change width of dropdown to that of the activator
            hover: true // Activate on hover
        });
    });
</script>