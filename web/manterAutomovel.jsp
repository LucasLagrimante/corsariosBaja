<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Automovel</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center" class="login">
            <h1 align="center">${operacao}<br>Automóvel</h1>
            <form class="form" action="ManterAutomovelController?acao=confirmar${operacao}" method="POST" name="frmManterAutomovel">
                <br><br>
                <abbr>ID</abbr>
                <p class="field">
                    <input name="txtIdAutomovel" type="text" placeholder="Digite apenas números!"  title="ID" required="required" pattern="[0-9]+$" value="${automovel.idAutomovel}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Nome</abbr>
                    <p class="field">
                        <input name="txtNome" type="text" value="${automovel.nome}"  required="required" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Cor</abbr>
                    <p class="field">
                        <input name="txtCor" type="text" required="required" value="${automovel.cor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Data Término Projeto</abbr>
                    <p class="field">
                        <input name="txtDataTerminoProjeto" type="text"  required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18" value="${automovel.dataTerminoProjeto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Peso Carro</abbr>
                    <p class="field">
                        <input name="txtPesoCarro" placeholder="Digite apenas números!"  type="text" required="required"  pattern="(?:\d*\.)?\d+" value="${automovel.pesoCarro}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Peso Chassi</abbr>
                    <p class="field">
                        <input type="text" required="required" placeholder="Digite apenas números!"  pattern="(?:\d*\.)?\d+" name="txtPesoChassi"  value="${automovel.pesoChassi}"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Custo Total:</abbr>
                    <p class="field">
                        <input type="text" required="required" placeholder="Digite apenas números!"  pattern="(?:\d*\.)?\d+"  name="txtCustoTotal"  value="${automovel.custoTotal}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    <i class="fa fa-circle"></i>
                </p>
                <p class="submit"><input type="submit" value="Confirmar"><fa-circle/p>
        </form>
    </div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</html>