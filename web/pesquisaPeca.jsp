<%-- 
    Document   : pesquisaPeca
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
        <title>Pesquisa de Peça</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1 align="center">Pesquisa de Peça</h1>
        <table border align="center">
            <tr>
                <th>Código Peça</th>
                <th>Nome Peça</th>
                <th>Quantidade</th>
                <th>Modelo</th>
                <th>Preço de Compra</th>
                <th>Tipo da Peça</th>                
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${pecas}" var="peca">
                <tr>
                    <td><c:out value="${peca.idPeca}" /></td>
                    <td><c:out value="${peca.nome}" /></td>
                    <td><c:out value="${peca.quantidade}" /></td>
                    <td><c:out value="${peca.modelo}" /></td>
                    <td><c:out value="${peca.precoCompra}" /></td>                   
                    <td><c:out value="${peca.idTipoPeca}" /></td>
                   
                    <td><a href="ManterPecaController?acao=prepararEditar&txtIdPeca=<c:out value="${peca.idPeca}" />">Editar</a></td>
                    <td><a href="ManterPecaController?acao=prepararExcluir&txtIdPeca=<c:out value="${peca.idPeca}" />">Excluir</a></td>
                </tr>
            </c:forEach>
            <tr> 
                <td  align="center" colspan="11"> 
                    <button onclick="window.location.href = 'index.jsp'">Voltar</button>
                </td>
            </tr>
        </table>

    </body>
</html>
