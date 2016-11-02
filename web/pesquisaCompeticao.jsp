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
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1 align="center">Pesquisa de Competição</h1>
        <table border align="center">
            <tr>
                <th>Código da Competição</th>
                <th>Nome da Competição</th>
                <th>Data da Competição</th>
                <th>Hora da Competição</th>
                <th>Local da Competição</th>
                
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${competicoes}" var="competicao">
                <tr>
                    <td><c:out value="${competicao.idCompeticao}" /></td>
                    <td><c:out value="${competicao.nome}" /></td>
                    <td><c:out value="${competicao.data}" /></td>
                    <td><c:out value="${competicao.hora}" /></td>
                    <td><c:out value="${competicao.local}" /></td>
                    <td><a href="ManterCompeticaoController?acao=prepararEditar&idCompeticao=<c:out value="${competicao.idCompeticao}" />">Editar</a></td>
                    <td><a href="ManterCompeticaoController?acao=prepararExcluir&idCompeticao=<c:out value="${competicao.idCompeticao}" />">Excluir</a></td>
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
