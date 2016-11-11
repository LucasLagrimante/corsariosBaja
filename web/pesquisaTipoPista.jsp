<%-- 
    Document   : pesquisaTipoPista
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
        <title>Pesquisa de Tipo de Pista</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1 align="center">Pesquisa de Tipo de Pista</h1>
        <table border align="center">
            <tr>
                <th>Código Tipo Pista</th>
                <th>Nome TipoPista</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${tiposPista}" var="tipoPista">
                <tr>
                    <td><c:out value="${tipoPista.idTipoPista}" /></td>
                    <td><c:out value="${tipoPista.nome}" /></td>
                    <td><a href="ManterTipoPistaController?acao=prepararEditar&idTipoPista=<c:out value="${tipoPista.idTipoPista}" />">Editar</a></td>
                    <td><a href="ManterTipoPistaController?acao=prepararExcluir&idTipoPista=<c:out value="${tipoPista.idTipoPista}" />">Excluir</a></td>
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
