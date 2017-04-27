<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Avaliacao</title>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center" class="login">
            <h1 align="center">${operacao}<br>Avaliação</h1>
            <form class="form"  action="ManterAvaliacaoController?acao=confirmar${operacao}" method="POST" name="frmManterAvaliacao">
                <br>
                <abbr>ID</abbr>
                <p class="field">
                    <input name="txtIdAvaliacao" type="text" value="${avaliacao.idAvaliacao}" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>          <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Frequencia</abbr>
                    <p class="field">
                        <input name="txtFrequencia" type="text" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!" value="${avaliacao.frequencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>    </select>           <i class="fa fa-circle"></i>
                    </p>

                    <abbr>Desempenho na Avaliação</abbr>
                    <p class="field">
                        <select name="txtComparecimento" value="${avaliacao.comparecimento}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                          <option value="otimo" <c:if test="${avaliacao.comparecimento == 'otimo'}"> selected</c:if>>Ótimo</option>
                          <option value="bom" <c:if test="${avaliacao.comparecimento == 'bom'}"> selected</c:if>>Bom</option>
                          <option value="medio" <c:if test="${avaliacao.comparecimento == 'medio'}"> selected</c:if>>Médio</option>
                          <option value="ruim" <c:if test="${avaliacao.comparecimento == 'ruim'}"> selected</c:if>>Ruim</option>
                          <option value="pessimo" <c:if test="${avaliacao.comparecimento == 'pessimo'}"> selected</c:if>>Péssimo</option>
                        </select>
                    </p>
                    <br>
                    <abbr>Data</abbr>
                    <p class="field">
                        <input name="txtData" type="text" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18" value="${avaliacao.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>          <i class="fa fa-circle"></i>
                    </p>


                    <abbr>Integrante</abbr>
                    <p class="field">
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectIntegrante" value="${avaliacao.integrante.matricula}"></c:if>
                    <select name="selectIntegrante" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${integrantes}" var="integrante">
                            <option value="${integrante.matricula}" <c:if test="${avaliacao.integrante.matricula == integrante.matricula}"> selected</c:if>> ${integrante.pessoa.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <input type="submit" value="Confirmar">
            </form>
        </div>
    </body>
</html>