<%-- 
    Document   : pesquisaAvaliacao
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
        <title>Pesquisa de Avaliacao</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Avaliação</h1>
        <table border="1">
            <tr>
                <th>Código Avaliacao</th>
                <th>Nome Avaliacao</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${avaliacoes}" var="avaliacao">
                <tr>
                    <td><c:out value="${avaliacao.idAvaliacao}" /></td>
                    <td><c:out value="${avaliacao.nome}" /></td>
                    <td><a href="ManterAvaliacaoController?acao=prepararEditar&idAvaliacao=<c:out value="${avaliacao.idAvaliacao}" />">Editar</a></td>
                    <td><a href="ManterAvaliacaoController?acao=prepararExcluir&idAvaliacao=<c:out value="${avaliacao.idAvaliacao}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterAvaliacaoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
