<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Tipo de Pista</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center" class="login">
            <h1 align="center">${operacao}<br>Tipo de Pista</h1>
            <form class="form" action="ManterTipoPistaController?acao=confirmar${operacao}" method="POST" name="frmManterTipoPista">
                <br>
                <abbr>ID</abbr>
                <p  class="field">
                    <input name="txtIdTipoPista" type="text" value="${tipoPista.idTipoPista}"  placeholder="Digite apenas números!"  required="required" pattern="[0-9]+$"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p> 
                    <abbr>Tipo/Nome da Pista</abbr>
                    <p  class="field">
                        <input name="txtNome" type="text" value="${tipoPista.nome}" required="required" pattern="[a-z\s]+$"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    <i class="fa fa-circle"></i>
                </p>
                <input type="submit" value="Confirmar">

            </form>
        </div>
    </body>
</html>