<%-- 
    Document   : pesquisaInvestidor
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
        <title>Pesquisa de Investidor</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Investidor</h1>
        <table border="1">
            <tr>
                <th>Código Investidor</th>
                <th>Nome Investidor</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${investidores}" var="investidor">
                <tr>
                    <td><c:out value="${investidor.idInvestidor}" /></td>
                    <td><c:out value="${investidor.nome}" /></td>
                    <td><a href="ManterInvestidorController?acao=prepararEditar&idInvestidor=<c:out value="${investidor.idInvestidor}" />">Editar</a></td>
                    <td><a href="ManterInvestidorController?acao=prepararExcluir&idInvestidor=<c:out value="${investidor.idInvestidor}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterInvestidorController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
