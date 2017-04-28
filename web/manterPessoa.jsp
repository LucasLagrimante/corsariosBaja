<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Pessoa</title>
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
            <h1 align="center">${operacao}<br>Pessoa</h1>
            <form class="form"  action="ManterPessoaController?acao=confirmar${operacao}" method="POST" name="frmManterPessoa" >

                <br>
                <abbr>ID</abbr>
                <p  class="field">
                    <input name="txtIdPessoa" type="text" value="${pessoa.idPessoa}" required="required" placeholder="Digite apenas números!"  pattern="[0-9]+$" placeholder="Digite apenas números!" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Nome</abbr>
                    <p  class="field">
                        <input name="txtNome" required="required" type="text" value="${pessoa.nome}" pattern="[a-z\s]+$" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>CPF</abbr>
                    <p  class="field">
                        <input name="txtCpf" onkeypress="mascara(this, cpf)" maxlength="14" required="required" type="text" pattern="([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})" value="${pessoa.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Logradouro</abbr>
                    <p  class="field">
                        <input name="txtLogradouro" required="required" type="text" value="${pessoa.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>CEP</abbr>
                    <p  class="field">
                        <input name="txtCep" required="required"  type="text" pattern= "\d{5}-?\d{3}" maxlength="9" value="${pessoa.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Bairro</abbr>
                    <p  class="field">
                        <input name="txtBairro" required="required" type="text"  value="${pessoa.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>UF</abbr>
                    <p  class="field">
                        <input name="txtUf" type="text" required="required" pattern="[a-z\s]+$"  maxlength="2"  value="${pessoa.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Número</abbr>
                    <p  class="field">
                        <input type="text" name="txtNumero" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!"  value="${pessoa.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Telefone</abbr>
                    <p  class="field">
                        <input type="text" name="txtTelefone" type="tel" required="required" maxlength="15" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" placeholder="Formato: (99) 9999-9999"  value="${pessoa.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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