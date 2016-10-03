<%-- 
    Document   : pesquisaCompeticao
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
        <title>Pesquisa de Competicao</title>
    </head>
    <body>
        <h1>Pesquisa de Competição</h1>
        <table border="1">
            <tr>
                <th>Código Competicao</th>
                <th>Nome Competicao</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${competicoes}" var="competicao">
                <tr>
                    <td><c:out value="${competicao.idCompeticao}" /></td>
                    <td><c:out value="${competicao.nome}" /></td>
                    <td><a href="ManterCompeticaoController?acao=prepararEditar&idCompeticao=<c:out value="${competicao.idCompeticao}" />">Editar</a></td>
                    <td><a href="ManterCompeticaoController?acao=prepararExcluir&idCompeticao=<c:out value="${competicao.idCompeticao}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCompeticaoController?acao=preparaIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
