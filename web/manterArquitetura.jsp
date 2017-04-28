<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Arquitetura</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
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
            <h3 align="center">${operacao} Arquitetura</h3>
            <form action="ManterArquiteturaController?acao=confirmar${operacao}" method="POST" name="frmManterArquitetura" class="form">
                <div class="row">
                    <div class="input-field col s6 offset-m3 offset-m3" >
                        <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectAutomovel" value="${arquitetura.automovel.idAutomovel}"></c:if>
                        <select id="automovel" name="selectAutomovel" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                            <c:forEach items="${automoveis}" var="automovel">
                                <option value="${automovel.idAutomovel}" <c:if test="${arquitetura.automovel.idAutomovel == automovel.idAutomovel}"> selected</c:if>> ${automovel.nome} </option>
                            </c:forEach>
                        </select>
                        <label for="automovel">Automóvel</label>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s6 offset-m3">
                        <input id="id"name="txtIdArquitetura" class="validate"  type="text" required="required" pattern="[0-9]+$" value="${arquitetura.idArquitetura}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="id">ID</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="imagem" name="txtCaminhoImagem" type="text" required="required" value="${arquitetura.caminhoImagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <label for="imagem">Imagem</label>
                    </div>
                </div>

                <div class="row">
                    <div class="col s12 center-align">
                        <button class="btn waves-effect waves-light" type="submit" value="Confirmar">
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

        $('.dropdown-button').dropdown({
            constrainWidth: false, // Does not change width of dropdown to that of the activator
            hover: true // Activate on hover
        });
    });
</script>