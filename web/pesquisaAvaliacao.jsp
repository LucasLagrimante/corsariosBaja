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
        <h1 align="center">Pesquisa de Avaliação</h1>
        <table border align="center">
            <tr>
                <th>Código Avaliação</th>
                <th>Matricula Integante</th>
                <th>Frequencia Avaliação</th>
                <th>Desempenho Avaliação</th>
                <th>Data Avaliação</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${avaliacoes}" var="avaliacao">
                <tr>
                    <td><c:out value="${avaliacao.idAvaliacao}" /></td>
                    <td><c:out value="${avaliacao.matricula}" /></td>
                    <td><c:out value="${avaliacao.frequencia}" /></td>
                    <td><c:out value="${avaliacao.comparecimento}" /></td>
                    <td><c:out value="${avaliacao.data}" /></td>
                    <td><a href="ManterAvaliacaoController?acao=prepararEditar&idAvaliacao=<c:out value="${avaliacao.idAvaliacao}" />">Editar</a></td>
                    <td><a href="ManterAvaliacaoController?acao=prepararExcluir&idAvaliacao=<c:out value="${avaliacao.idAvaliacao}" />">Excluir</a></td>
                </tr>
            </c:forEach>
            <tr> 
                <td  align="center" colspan="9"> 
                    <button onclick="window.location.href = 'index.jsp'">Voltar</button>
                </td>
            </tr>

        </table>

    </body>
</html>
