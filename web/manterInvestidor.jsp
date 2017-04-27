<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Investimentos Monetários</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center" class="login">
            <h1 align="center">${operacao}<br>Investimentos</h1>
            <form class="form"  action="ManterInvestidorController?acao=confirmar${operacao}" method="POST" name="frmManterInvestidor">
                <br>
                <abbr>Pessoa</abbr>
                <p  class="field">
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectPessoa" value="${investidor.pessoa.idPessoa }"></c:if>
                    <select name="selectPessoa" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${pessoas}" var="pessoa">
                            <option value="${pessoa.idPessoa}" <c:if test="${investidor.pessoa.idPessoa  == pessoa.idPessoa}"> selected</c:if>> ${pessoa.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <abbr>ID</abbr>
                <p  class="field">

                    <input type="text" name="txtIdInvestidor" value="${investidor.idInvestidor}" placeholder="Digite apenas números!"  required="required" pattern="[0-9]+$" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Valor Doado</abbr>
                    <p  class="field">
                        <input type="text" name="txtValorDoado" required="required" placeholder="Digite apenas números!"  pattern="(?:\d*\.)?\d+" value="${investidor.valorDoado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    <i class="fa fa-circle"></i>
                </p>
                <input type="submit" value="Confirmar">
                </table>
            </form>
        </div>
    </body>
</html>