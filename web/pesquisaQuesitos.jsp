<%-- 
    Document   : pesquisaQuesito
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
        <title>Pesquisa de Quesito</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Quesito</h1>
        <table border="1">
            <tr>
                <th>Código Quesito</th>
                <th>Nome Quesito</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${quesitos}" var="quesito">
                <tr>
                    <td><c:out value="${quesito.idQuesito}" /></td>
                    <td><c:out value="${quesito.nome}" /></td>
                    <td><a href="ManterQuesitoController?acao=prepararEditar&idQuesito=<c:out value="${quesito.idQuesito}" />">Editar</a></td>
                    <td><a href="ManterQuesitoController?acao=prepararExcluir&idQuesito=<c:out value="${quesito.idQuesito}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterQuesitoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
