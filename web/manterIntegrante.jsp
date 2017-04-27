<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Integrante</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center" class="login">
            <h1 align="center">${operacao}<br> Integrante</h1>
            <form class="form"  action="ManterIntegranteController?acao=confirmar${operacao}" method="POST" name="frmManterIntegrante">
                <br>
                <abbr>Pessoa</abbr>
                <p>
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectPessoa" value="${integrante.pessoa.idPessoa}"></c:if>
                    <select name="selectPessoa"  required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${pessoas}" var="pessoa">
                            <option value="${pessoa.idPessoa}" <c:if test="${integrante.pessoa.idPessoa == pessoa.idPessoa}"> selected</c:if>> ${pessoa.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <abbr>Matricula</abbr>
                <p  class="field">
                    <input type="text" name="txtMatricula" required="required" pattern="[0-9]+$" maxlength="6" value="${integrante.matricula}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Carga Horaria Disponivel</abbr>
                    <p  class="field">
                        <input name="txtCargaHorariaDisponivel" type="text" required="required" maxlength="8" pattern="^(?:(?:([01]?\d|2[0-3]):)?([0-5]?\d):)?([0-5]?\d)$" value="${integrante.cargaHorariaDisponivel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    <i class="fa fa-circle"></i>
                </p>
                <br>
                <input type="submit" value="Confirmar">
            </form>
        </div>
    </body>
</html>