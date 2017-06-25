<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Relatórios</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <h3  align="center">Relatórios</h3>
            <div class="input-field col s6 center-align">
                <select name="selectRelatorio" required="required">
                    <option value="" disabled selected>Escolha...</option>
                    <option value="arquiteturaAutomovel"> Arquitetura Automóvel</option>
                    <option value="competicaoTipoPista"> Competição Tipo Pista</option>
                    <option value="designAutomovel"> Design Automovel</option>
                    <option value="integranteFrequencia"> Integrante Frequência</option>
                    <option value="groupAutomovelCor"> Agrupado por Automovel Cor</option>
                    <option value="groupDesempenhoPista"> Agrupado por Desempenho Tipo Pista</option>
                    <option value="groupDesempenhoPista"> Agrupado por Pessoa Por Bairro</option>
                </select>
            </div>
        </div>

        <div class="input-field col s4 center-align">
            <a class="waves-effect waves-light btn-large brown darken-4" id="imprimir">Imprimir <i class="material-icons right">print</i></a>
        </div>
    </body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        $('body').css('background-image', "url('images/fundo.png')");
        $("[name='selectRelatorio']").material_select();

        $("#imprimir").click(function () {
            if ($("[name='selectRelatorio'] option:selected").val() === "arquiteturaAutomovel") {
                window.location.href = 'RelatorioController?relatorioNome=reportArquiteturaAutomovel.jasper';
            }
            if ($("[name='selectRelatorio'] option:selected").val() === "competicaoTipoPista") {
                window.location.href = 'RelatorioController?relatorioNome=reportCompeticaoTipoPista.jasper';
            }
            if ($("[name='selectRelatorio'] option:selected").val() === "designAutomovel") {
                window.location.href = 'RelatorioController?relatorioNome=reportDesignAutomovel.jasper';
            }
            if ($("[name='selectRelatorio'] option:selected").val() === "integranteFrequencia") {
                window.location.href = 'RelatorioController?relatorioNome=reportIntegranteFrequencia.jasper';
            }
            if ($("[name='selectRelatorio'] option:selected").val() === "groupAutomovelCor") {
                window.location.href = 'RelatorioController?relatorioNome=reportGroupAutomovelCor.jasper';
            }
            if ($("[name='selectRelatorio'] option:selected").val() === "groupDesempenhoPista") {
                window.location.href = 'RelatorioController?relatorioNome=reportGroupDesempenhoPorTipoPista.jasper';
            }
             if ($("[name='selectRelatorio'] option:selected").val() === "groupDesempenhoPista") {
                window.location.href = 'RelatorioController?relatorioNome=reportGroupPessoaPorBairro.jasper';
            }
        });

        $('.dropdown-button').dropdown({
            constrainWidth: false, // Does not change width of dropdown to that of the activator
            hover: true // Activate on hover
        });

        $('.materialboxed').materialbox();

        $(document).ready(function () {
            $('.parallax').parallax();
        });
    });
</script>
