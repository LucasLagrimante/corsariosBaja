<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Competição</title>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center" class="login">
            <h1 align="center">${operacao} <br>Competição</h1>
            <form class="form" action="ManterCompeticaoController?acao=confirmar${operacao}" method="POST" name="frmManterCompeticao">
                <br><br>
                <abbr>ID</abbr>
                <p  class="field">
                    <input name="txtIdCompeticao" type="text" required="required" pattern="[0-9]+$"  value="${competicao.idCompeticao}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Nome</abbr>
                    <p  class="field">
                        <input name="txtNome" type="text" value="${competicao.nome}" required="required" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>      <i class="fa fa-circle"></i>
                    </p>


                    <abbr>Data</abbr>
                    <p  class="field">
                        <input name="txtData" type="text" value="${competicao.data}" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>


                    <abbr>Hora</abbr>
                    <p  class="field">
                        <input name="txtHora" value="${competicao.hora}" required="required" type="text" required="required" maxlength="8" pattern="^(?:(?:([01]?\d|2[0-3]):)?([0-5]?\d):)?([0-5]?\d)$" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Local</abbr>
                    <p  class="field">
                        <input name="txtLocal" required="required" type="text" value="${competicao.local}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>      <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Tipo Pista</abbr>
                    <p>
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectTipoPista" value="${competicao.tipopista.idTipoPista}"></c:if>
                    <select name="selectTipoPista" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${tipospista}" var="tipopista">
                            <option value="${tipopista.idTipoPista}" <c:if test="${competicao.tipopista.idTipoPista == tipopista.idTipoPista}"> selected</c:if>> ${tipopista.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br><br>

                <input type="submit" value="Confirmar">
                <input type="button" value="Cadastrar Tipos de Pista" onclick="window.location.href = 'http://localhost:8080/corsariosBaja/ManterTipoPistaController?acao=prepararIncluir'">

            </form>

        </div>
    </body>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</html>