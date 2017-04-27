<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Frequência</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center" class="login">
            <h1 align="center">${operacao}<br>Frequência</h1>
            <form class="form"  action="ManterFrequenciaController?acao=confirmar${operacao}" method="POST" name="frmManterFrequencia">
                <br>
                <abbr>ID</abbr>
                <p  class="field">
                    <input name="txtIdFrequencia"  type="text" required="required" placeholder="Digite apenas números!"  pattern="[0-9]+$" value="${frequencia.idFrequencia}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Data</abbr>
                    <p  class="field">
                        <input name="txtData" type="text" value="${frequencia.data}" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <br>
                    <abbr>Estado</abbr>
                    <p  class="field">
                        <input required type="radio" name="radioEstado" value="presente" <c:if test="${frequencia.estado == 'presente'}"> checked</c:if> <c:if test="${operacao == 'Excluir'}"> disabled</c:if>> Presente
                    <input type="radio" name="radioEstado" value="ausente" <c:if test="${frequencia.estado == 'ausente'}"> checked</c:if> <c:if test="${operacao == 'Excluir'}"> disabled</c:if>> Ausente
                    </p>
                    <br>
                    <abbr>Integrante</abbr>
                    <p >
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectIntegrante" value="${frequencia.integrante.matricula}"></c:if>
                    <select name="selectIntegrante" required <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${integrantes}" var="integrante">
                            <option value="${integrante.matricula}" <c:if test="${frequencia.integrante.matricula == integrante.matricula}"> selected</c:if>> ${integrante.pessoa.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <input type="submit" value="Confirmar">
            </form>
        </div>
    </body>
</html>