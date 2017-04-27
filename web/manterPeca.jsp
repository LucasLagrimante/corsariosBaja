<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Peça</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center" class="login">
            <h1 align="center">${operacao}<br>Peça</h1>
            <form class="form"  action="ManterPecaController?acao=confirmar${operacao}" method="POST" name="frmManterPeca">
                <br>
                <abbr>ID</abbr>
                <p  class="field">
                    <input name="txtIdPeca"  type="text" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!" value="${peca.idPeca}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>><i class="fa fa-circle"></i>
                    </p>
                    <abbr>Quantidade</abbr>
                    <p  class="field">
                        <input name="txtQuantidade" type="text" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!" value="${peca.quantidade}"  min="1" size="4" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><i class="fa fa-circle"></i>
                    </p>
                    <abbr>Nome</abbr>
                    <p  class="field">
                        <input name="txtNome" type="text" required="required" value="${peca.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Modelo</abbr>
                    <p  class="field">
                        <input name="txtModelo" type="text" required="required" value="${peca.modelo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><i class="fa fa-circle"></i>
                    </p>
                    <abbr>Preço</abbr>
                    <p class="field">
                        <input name="txtPrecoCompra" type="text" required="required" pattern="(?:\d*\.)?\d+" placeholder="Digite apenas números!" value="${peca.precoCompra}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Tipo Peça</abbr>
                    <p>
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectTipoPeca" value="${peca.tipopeca.idTipoPeca}"></c:if>
                    <select name="selectTipoPeca" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${tipopecas}" var="tipopeca">
                            <option value="${tipopeca.idTipoPeca}" <c:if test="${peca.tipopeca.idTipoPeca == tipopeca.idTipoPeca}"> selected</c:if>> ${tipopeca.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <input type="submit" value="Confirmar">
                <input type="button" value="Cadastrar Tipo de Peca" onclick="window.location.href = 'http://localhost:8080/corsariosBaja/ManterTipoPecaController?acao=prepararIncluir'">
            </form>
        </div>
    </body>
</html>