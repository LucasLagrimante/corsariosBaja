<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar Automovel</title>
        <meta charset="utf-8">
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
            <li><a class="brown-text text-darken-4" href="ManterAutomovelController?acao=prepararIncluir">Autom�vel</a></li>
            <li><a class="brown-text text-darken-4" href="ManterArquiteturaController?acao=prepararIncluir">Arquitetura</a></li>
            <li><a class="brown-text text-darken-4" href="ManterAvaliacaoController?acao=prepararIncluir">Avalia��o</a></li>
            <li><a class="brown-text text-darken-4" href="ManterCompeticaoController?acao=prepararIncluir">Competi��o</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesempenhoController?acao=prepararIncluir">Desempenho de Competic�o</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesempenhoTesteController?acao=prepararIncluir">Desempenho de Teste</a></li>
            <li><a class="brown-text text-darken-4" href="ManterDesignController?acao=prepararIncluir">Design</a></li>
            <li><a class="brown-text text-darken-4" href="ManterFrequenciaController?acao=prepararIncluir">Frequ�ncia</a></li>
            <li><a class="brown-text text-darken-4" href="ManterInvestidorController?acao=prepararIncluir">Investidor</a></li>
            <li><a class="brown-text text-darken-4" href="ManterIntegranteController?acao=prepararIncluir">Integrante</a></li>
            <li><a class="brown-text text-darken-4" href="ManterPecaController?acao=prepararIncluir">Pe�a</a></li>
            <li><a class="brown-text text-darken-4" href="ManterPessoaController?acao=prepararIncluir">Pessoa</a></li>
            <li><a class="brown-text text-darken-4" href="ManterTipoPecaController?acao=prepararIncluir">Tipo de Pe�a</a></li>
            <li><a class="brown-text text-darken-4" href="ManterTipoPistaController?acao=prepararIncluir">Tipo de Pista</a></li>
        </ul>
        <ul id="menuPesquisa" class="dropdown-content">
            <li><a class="brown-text text-darken-4" href="PesquisaAutomovelController">Autom�vel</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaArquiteturaController">Arquitetura</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaAvaliacaoController">Avalia��o</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaCompeticaoController">Competi��o</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaDesempenhoController">Desempenho de Competic�o</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaDesempenhoTesteController">Desempenho de Teste</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaDesignController">Design</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaFrequenciaController">Frequ�ncia</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaInvestidorController">Investidor</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaIntegranteController">Integrante</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaPecaController">Pe�a</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaPessoaController">Pessoa</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaTipoPecaController">Tipo de Pe�a</a></li>
            <li><a class="brown-text text-darken-4" href="PesquisaTipoPistaController">Tipo de Pista</a></li>
        </ul>
        <nav>
            <div class="nav-wrapper brown darken-4">
                <a href="#!" class="brand-logo"><i class="material-icons">high_quality</i>Corrida Baja - Equipe Cors�rios</a>
                <ul class="right hide-on-med-and-down">
                    <!-- Dropdown Trigger -->
                    <li><a href="index.jsp">In�cio</a></li>
                    <li><a class="dropdown-button" href="#!" data-activates="menuCadastro">Cadastro<i class="material-icons right">arrow_drop_down</i></a></li>
                    <li><a class="dropdown-button" href="#!" data-activates="menuPesquisa">Pesquisa<i class="material-icons right">arrow_drop_down</i></a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <h3 align="center">${operacao} Autom�vel</h3>
            <form action="ManterAutomovelController?acao=confirmar${operacao}" method="POST" name="frmManterAutomovel">
                <div class="row">
                    <div class="input-field col s6 offset-m3" >
                        <input id="id" name="txtIdAutomovel" class="validate" type="text" required="required"  pattern="[0-9]+$" value="${automovel.idAutomovel}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="id">ID</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="nome" name="txtNome" type="text" value="${automovel.nome}" required="required" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label for="nome">Nome</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="cor" name="txtCor" type="text" required="required" value="${automovel.cor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label for="nome">Cor</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="dataTermino" name="txtDataTerminoProjeto" class="datepicker" type="text" required="required" value="${automovel.dataTerminoProjeto}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <label for="dataTermino">Data T�rmino Projeto</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="pesoCarro" name="txtPesoCarro" class="validate" type="text" required="required" pattern="(?:\d*\.)?\d+" value="${automovel.pesoCarro}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="pesoCarro">Peso Carro</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="pesoChassi" class="validate" type="text" required="required" pattern="(?:\d*\.)?\d+" name="txtPesoChassi"  value="${automovel.pesoChassi}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="pesoChassi">Peso Chassi</label>
                        </div>
                    </div>   

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="custo" type="text" class="validate" required="required" pattern="(?:\d*\.)?\d+" name="txtCustoTotal"  value="${automovel.custoTotal}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <label data-error="errado" data-success="certo" for="custo">Custo Total</label>
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

        $('body').css('background-image', "url('images/b19.png')");

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
            labelMonthNext: 'Pr�ximo m�s',
            labelMonthPrev: 'M�s Anterior',
            labelMonthSelect: 'Selecionar um m�s',
            labelYearSelect: 'Selecionar um ano',
            monthsFull: ['Janeiro', 'Fevereiro', 'Mar�o', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
            monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
            weekdaysFull: ['Domingo', 'Segunda', 'Ter�a', 'Quarta', 'Quinta', 'Sexta', 'S�bado'],
            weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
            weekdaysLetter: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
        });
    });
</script>