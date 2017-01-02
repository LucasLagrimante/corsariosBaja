<%-- 
    Document   : pesquisaAutomovel
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
        <title>Pesquisa de Automóvel</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1 align="center">Pesquisa de Automóvel</h1>
        <table border align="center">
            <tr>
                <th>Código Automóvel</th>
                <th>Nome Automóvel</th>
                <th>Cor</th>
                <th>Data de término do projeto</th>
                <th>Peso Carro</th>
                <th>Peso Chassi</th>
                <th>Custo Total</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${automoveis}" var="automovel">
                <tr>
                    <td><c:out value="${automovel.idAutomovel}" /></td>
                    <td><c:out value="${automovel.nome}" /></td>
                    <td><c:out value="${automovel.cor}" /></td>
                    <td><c:out value="${automovel.dataTerminoProjeto}" /></td>
                    <td><c:out value="${automovel.pesoCarro}" /></td>
                    <td><c:out value="${automovel.pesoChassi}" /></td>
                    <td><c:out value="${automovel.custoTotal}" /></td>
                    <td><a href="ManterAutomovelController?acao=prepararEditar&idAutomovel=<c:out value="${automovel.idAutomovel}" />">Editar</a></td>
                    <td><a href="ManterAutomovelController?acao=prepararExcluir&idAutomovel=<c:out value="${automovel.idAutomovel}" />">Excluir</a></td>
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
