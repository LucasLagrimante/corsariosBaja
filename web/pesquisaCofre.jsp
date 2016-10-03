<%-- 
    Document   : pesquisaCofre
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
        <title>Pesquisa de Cofre</title>
    </head>
    <body>
        <h1>Pesquisa de Cofre</h1>
        <table border="1">
            <tr>
                <th>Código Cofre</th>
                <th>Nome Cofre</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${cofres}" var="cofre">
                <tr>
                    <td><c:out value="${cofre.idCofre}" /></td>
                    <td><c:out value="${cofre.nome}" /></td>
                    <td><a href="ManterCofreController?acao=prepararEditar&idCofre=<c:out value="${cofre.idCofre}" />">Editar</a></td>
                    <td><a href="ManterCofreController?acao=prepararExcluir&idCofre=<c:out value="${cofre.idCofre}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCofreController?acao=preparaIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
