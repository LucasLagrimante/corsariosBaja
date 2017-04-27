<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Design</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center"  class="login">
            <h1 align="center">${operacao}<br>Design </h1>
            <form class="form" action="ManterDesignController?acao=confirmar${operacao}" method="POST" name="frmManterDesign">
                <br>
                <abbr>Automóvel</abbr>
                <p>
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectAutomovel" value="${design.automovel.idAutomovel}"></c:if>
                    <select name="selectAutomovel" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${automoveis}" var="automovel">
                            <option value="${automovel.idAutomovel}" <c:if test="${design.automovel.idAutomovel == automovel.idAutomovel}"> selected</c:if>> ${automovel.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <abbr>ID</abbr>
                <p class="field">
                    <input name="txtIdDesign" type="text" required="required" placeholder="Digite apenas números!"  pattern="[0-9]+$" value="${design.idDesign}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Caminho Imagem</abbr>
                    <p class="field">
                        <input name="txtCaminhoImagem" type="text" required="required value="${design.caminhoImagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    <i class="fa fa-circle"></i>
                </p>
                <input type="submit" value="Confirmar">
            </form>
        </div>
    </body>
</html>