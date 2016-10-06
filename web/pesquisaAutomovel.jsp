<%-- 
    Document   : pesquisaAutomovel
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
        <title>Pesquisa de Automovel</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Automovel</h1>
        <table border="1">
            <tr>
                <th>Código Automovel</th>
                <th>Nome Automovel</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${automoveis}" var="automovel">
                <tr>
                    <td><c:out value="${automovel.idAutomovel}" /></td>
                    <td><c:out value="${automovel.nome}" /></td>
                    <td><a href="ManterAutomovelController?acao=prepararEditar&idAutomovel=<c:out value="${automovel.idAutomovel}" />">Editar</a></td>
                    <td><a href="ManterAutomovelController?acao=prepararExcluir&idAutomovel=<c:out value="${automovel.idAutomovel}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterAutomovelController?acao=preparaIncluir" method="post">
           <input type="submit" value="Incluir" name="btnIncluir">
        </form>
    </body>
</html>
