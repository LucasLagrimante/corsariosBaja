<%-- 
    Document   : pesquisatipoPeca
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
        <title>Pesquisa de tipoPeca</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de tipoPeca</h1>
        <table border="1">
            <tr>
                <th>Código tipoPeca</th>
                <th>Nome tipoPeca</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${tiposPecas}" var="tipoPeca">
                <tr>
                    <td><c:out value="${tipoPeca.idTipoPeca}" /></td>
                    <td><c:out value="${tipoPeca.nome}" /></td>
                    <td><a href="ManterTipoPecaController?acao=prepararEditar&idtipoPeca=<c:out value="${tipoPeca.idTipoPeca}" />">Editar</a></td>
                    <td><a href="ManterTipoPecaController?acao=prepararExcluir&idtipoPeca=<c:out value="${tipoPeca.idTipoPeca}" />">Excluir</a></td>
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
