<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Investimentos Monetários</title>
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
            <li><a class="brown-text text-darken-4" href="ManterAutomovelController?acao=prepararOperacao&operacao=incluir">Automóvel</a></li>
            <li><a class="brown-text text-darken-4" href="ManterArquiteturaController?acao=prepararOperacao&operacao=incluir">Arquitetura</a></li>
            <li><a class="brown-text text-darken-4" href="ManterAvaliacaoController?acao=prepararOperacao&operacao=incluir">Avaliação</a></li>
            <li><a class="brown-text text-darken-4" href="ManterCompeticaoController?acao=prepararOperacao&operacao=incluir">Competição</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesempenhoController?acao=prepararOperacao&operacao=incluir">Desempenho de Competicão</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesempenhotesteController?acao=prepararOperacao&operacao=incluir">Desempenho de Teste</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesignController?acao=prepararOperacao&operacao=incluir">Design</a></li>
            <li><a class="brown-text text-darken-4" href="ManterFrequenciaController?acao=prepararOperacao&operacao=incluir">Frequência</a></li>

            <li><a class="brown-text text-darken-4" href="ManterIntegranteController?acao=prepararOperacao&operacao=incluir">Integrante</a></li>
            <li><a class="brown-text text-darken-4" href="ManterPecaController?acao=prepararOperacao&operacao=incluir">Peça</a></li>
            <li><a class="brown-text text-darken-4" href="ManterPessoaController?acao=prepararOperacao&operacao=incluir">Pessoa</a></li>
            <li><a class="brown-text text-darken-4" href="ManterTipopecaController?acao=prepararOperacao&operacao=incluir">Tipo de Peça</a></li>
            <li><a class="brown-text text-darken-4" href="ManterTipopistaController?acao=prepararOperacao&operacao=incluir">Tipo de Pista</a></li>
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
                    <li><a class="dropdown-button" href="#!" data-activates="menuCadastro">Cadastro<i class="material-icons right">arrow_drop_down</i></a></li>
                    <li><a class="dropdown-button" href="#!" data-activates="menuPesquisa">Pesquisa<i class="material-icons right">arrow_drop_down</i></a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <h3 align="center">${operacao} Investimentos</h3>
            <form   action="ManterInvestidorController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterInvestidor">
                <div class="row">
                    <div class="input-field col s6 offset-m3">
                        <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectPessoa" value="${investidor.pessoa.idPessoa }"></c:if>
                        <select id="pessoa" name="selectPessoa" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                            <c:forEach items="${pessoas}" var="pessoa">
                                <option value="${pessoa.idPessoa}" <c:if test="${investidor.pessoa.idPessoa  == pessoa.idPessoa}"> selected</c:if>> ${pessoa.nome} </option>
                            </c:forEach>
                        </select>
                        <label for="pessoa">Pessoa</label>
                    </div>
                </div>


                <div class="row">
                    <div class="input-field col s6 offset-m3">
                        <input id="id" type="text" name="txtIdInvestidor" class="validate" value="${investidor.idInvestidor}" required="required" pattern="[0-9]+$" <c:if test="${operacao != 'incluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="id">ID</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="valor" type="text" name="txtValorDoado" required="required" class="validate" pattern="(?:\d*\.)?\d+" value="${investidor.valorDoado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <label data-error="errado" data-success="certo" for="valor">Valor Doado</label>
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
    });
</script>