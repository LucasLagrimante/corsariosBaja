<%-- 
    Document   : pesquisaFrequencia
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
        <title>Pesquisa de Frequencia</title>
    </head>
    <body>
        <h1>Pesquisa de Frequencia</h1>
        <table border="1">
            <tr>
                <th>Código Frequencia</th>
                <th>Estado</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${frequencias}" var="frequencia">
                <tr>
                    <td><c:out value="${frequencia.idFrequencia}" /></td>
                    <td><c:out value="${frequencia.estado}" /></td>
                    <td><a href="ManterFrequenciaController?acao=prepararEditar&idFrequencia=<c:out value="${frequencia.idFrequencia}" />">Editar</a></td>
                    <td><a href="ManterFrequenciaController?acao=prepararExcluir&idFrequencia=<c:out value="${frequencia.idFrequencia}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFrequenciaController?acao=preparaIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
