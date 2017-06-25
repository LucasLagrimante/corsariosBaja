<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="images/favicon.ico">
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
            <h3 align="center">${operacao} Pessoa</h3>
            <form action="ManterPessoaController?acao=confirmarOperacao&operacao=${operacao}" method="POST" name="frmManterPessoa">
                <div class="row">
                    <div class="input-field col s6 offset-m3">
                        <input id="id" name="txtIdPessoa" type="text" value="${pessoa.idPessoa}" class="validate" required="required"   pattern="[0-9]+$"  <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="id">ID</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="nome" name="txtNome" required="required" type="text" value="${pessoa.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label for="nome">Nome</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="cpf" name="txtCpf" class="validate" maxlength="14" required="required" type="text" pattern="([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})" value="${pessoa.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="cpf">CPF</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="logradouro" name="txtLogradouro" required="required" type="text" value="${pessoa.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label for="logradouro">Logradouro</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="cep" name="txtCep" required="required" class="validate" type="text" pattern= "\d{5}-?\d{3}" maxlength="9" value="${pessoa.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="cep">CEP</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="bairro" name="txtBairro" required="required" type="text" value="${pessoa.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label for="bairro">Bairro</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <select id="uf" required="required" name="txtUf" value="${pessoa.uf}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <option value="" disabled selected>Escolha</option>
                                <option value="AC" <c:if test="${pessoa.uf == 'AC'}"> selected</c:if>>Acre</option>
                            <option value="AL" <c:if test="${pessoa.uf == 'AL'}"> selected</c:if>>Alagoas</option>
                            <option value="AP" <c:if test="${pessoa.uf == 'AP'}"> selected</c:if>>Amapá</option>
                            <option value="AM" <c:if test="${pessoa.uf == 'AM'}"> selected</c:if>>Amazonas</option>
                            <option value="BA" <c:if test="${pessoa.uf == 'BA'}"> selected</c:if>>Bahia</option>
                            <option value="CE" <c:if test="${pessoa.uf == 'CE'}"> selected</c:if>>Ceará</option>
                            <option value="DF" <c:if test="${pessoa.uf == 'DF'}"> selected</c:if>>Distrito Federal</option>
                            <option value="ES" <c:if test="${pessoa.uf == 'ES'}"> selected</c:if>>Espirito Santo</option>
                            <option value="GO" <c:if test="${pessoa.uf == 'GO'}"> selected</c:if>>Goiás</option>
                            <option value="MA" <c:if test="${pessoa.uf == 'MA'}"> selected</c:if>>Maranhão</option>
                            <option value="MS" <c:if test="${pessoa.uf == 'MS'}"> selected</c:if>>Mato Grosso do Sul</option>
                            <option value="MT" <c:if test="${pessoa.uf == 'MT'}"> selected</c:if>>Mato Grosso</option>
                            <option value="MG" <c:if test="${pessoa.uf == 'MG'}"> selected</c:if>>Minas Gerais</option>
                            <option value="PA" <c:if test="${pessoa.uf == 'PA'}"> selected</c:if>>Pará</option>
                            <option value="PB" <c:if test="${pessoa.uf == 'PB'}"> selected</c:if>>Paraíba</option>
                            <option value="PR" <c:if test="${pessoa.uf == 'PR'}"> selected</c:if>>Paraná</option>
                            <option value="PE" <c:if test="${pessoa.uf == 'PE'}"> selected</c:if>>Pernambuco</option>
                            <option value="PI" <c:if test="${pessoa.uf == 'PI'}"> selected</c:if>>Piauí</option>
                            <option value="RJ" <c:if test="${pessoa.uf == 'RJ'}"> selected</c:if>>Rio de Janeiro</option>
                            <option value="RN" <c:if test="${pessoa.uf == 'RN'}"> selected</c:if>>Rio Grande do Norte</option>
                            <option value="RS" <c:if test="${pessoa.uf == 'RS'}"> selected</c:if>>Rio Grande do Sul</option>
                            <option value="RO" <c:if test="${pessoa.uf == 'RO'}"> selected</c:if>>Rondônia</option>
                            <option value="RR" <c:if test="${pessoa.uf == 'RR'}"> selected</c:if>>Roraima</option>
                            <option value="SC" <c:if test="${pessoa.uf == 'SC'}"> selected</c:if>>Santa Catarina</option>
                            <option value="SP" <c:if test="${pessoa.uf == 'SP'}"> selected</c:if>>São Paulo</option>
                            <option value="SE" <c:if test="${pessoa.uf == 'SE'}"> selected</c:if>>Sergipe</option>
                            <option value="TO" <c:if test="${pessoa.uf == 'TO'}"> selected</c:if>>Tocantins</option>
                            </select>
                            <label for="uf">UF</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="numero" type="text" name="txtNumero" class="validate" required="required" pattern="[0-9]+$" value="${pessoa.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label data-error="errado" data-success="certo" for="numero">Número</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-m3">
                            <input id="telefone" type="text" class="validate"name="txtTelefone" type="tel" required="required" maxlength="15" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" value="${pessoa.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <label data-error="errado" data-success="certo" for="telefone">Telefone</label>
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

        $("#cpf").keydown(function () {
            var tamanho = $("#cpf").val().length;
            if (tamanho === 3) {
                var text = $("#cpf").val() + ".";
                $("#cpf").val(text);
            }
            if (tamanho === 7) {
                var text = $("#cpf").val() + ".";
                $("#cpf").val(text);
            }
            if (tamanho === 11) {
                var text = $("#cpf").val() + "-";
                $("#cpf").val(text);
            }
        });

        $("#cep").keydown(function () {
            var tamanho = $("#cep").val().length;
            if (tamanho === 5) {
                var text = $("#cep").val() + "-";
                $("#cep").val(text);
            }
        });

        $("#telefone").keydown(function () {
            var tamanho = $("#telefone").val().length;
            if (tamanho === 0) {
                var text = $("#telefone").val() + "(";
                $("#telefone").val(text);
            }
            if (tamanho === 3) {
                var text = $("#telefone").val() + ") ";
                $("#telefone").val(text);
            }
            if (tamanho === 10) {
                var text = $("#telefone").val() + "-";
                $("#telefone").val(text);
            }
        });
    });
</script>