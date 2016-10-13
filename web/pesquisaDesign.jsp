<%-- 
    Document   : pesquisaDesign
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
        <title>Pesquisa de Design</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Design</h1>
        <table border="1">
            <tr>
                <th>Código Design</th>
                <th>Nome Design</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${designs}" var="design">
                <tr>
                    <td><c:out value="${design.idDesign}" /></td>
                    <td><c:out value="${design.nome}" /></td>
                    <td><a href="ManterDesignController?acao=prepararEditar&idDesign=<c:out value="${design.idDesign}" />">Editar</a></td>
                    <td><a href="ManterDesignController?acao=prepararExcluir&idDesign=<c:out value="${design.idDesign}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterDesignController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
