<%-- 
    Document   : pesquisaTipoPista
    Created on : 20/09/2016, 09:17:12
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de TipoPista</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de TipoPista</h1>
        <table border="1">
            <tr>
                <th>Código TipoPista</th>
                <th>Nome TipoPista</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${tipoPista}" var="TipoPista">
                <tr>
                    <td><c:out value="${TipoPista.idTipoPista}" /></td>
                    <td><c:out value="${TipoPista.nome}" /></td>
                    <td><a href="ManterTipoPistaController?acao=prepararEditar&idTipoPista=<c:out value="${TipoPista.idTipoPista}" />">Editar</a></td>
                    <td><a href="ManterTipoPistaController?acao=prepararExcluir&idTipoPista=<c:out value="${TipoPista.idTipoPista}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterTipoPistaController?acao=preparaIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
