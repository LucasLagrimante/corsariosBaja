<%-- 
    Document   : pesquisaArquitetura
    Created on : 20/09/2016, 09:17:12
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Arquitetura</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1 align="center">Pesquisa de Arquitetura</h1>
        <table border align="center">
            <tr>
                <th>Código Arquitetura</th>
                <th>Caminho</th>
                <th>Automovel</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${arquiteturas}" var="arquitetura">
                <tr>
                    <td><c:out value="${arquitetura.idArquitetura}" /></td>
                    <td><c:out value="${arquitetura.caminhoImagem}" /></td>
                    <td><c:out value="${arquitetura.idAutomovel}" /></td>
                    <td><a href="ManterArquiteturaController?acao=prepararEditar&idArquitetura=<c:out value="${arquitetura.idArquitetura}" />">Editar</a></td>
                    <td><a href="ManterArquiteturaController?acao=prepararExcluir&idArquitetura=<c:out value="${arquitetura.idArquitetura}" />">Excluir</a></td>
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
