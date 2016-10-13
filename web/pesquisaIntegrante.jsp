<%-- 
    Document   : pesquisaIntegrante
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
        <title>Pesquisa de Integrante</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Integrante</h1>
        <table border="1">
            <tr>
                <th>Matricula</th>
                <th>Carga Horaria Disponivel</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${integrantes}" var="integrante">
                <tr>
                    <td><c:out value="${integrante.matricula}" /></td>
                    <td><c:out value="${integrante.cargaHorariaDisponivel}" /></td>
                    <td><a href="ManterIntegranteController?acao=prepararEditar&idIntegrante=<c:out value="${integrante.matricula}" />">Editar</a></td>
                    <td><a href="ManterIntegranteController?acao=prepararExcluir&idIntegrante=<c:out value="${integrante.matricula}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterIntegranteController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
