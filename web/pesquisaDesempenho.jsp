<%-- 
    Document   : pesquisaDesempenho
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
        <title>Pesquisa de Desempenho</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Desempenho</h1>
        <table border="1">
            <tr>
                <th>Código Desempenho</th>
                <th>Nome Desempenho</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Aceleração Média</th>
                <th>Velocidade Média</th>
                <th>Tempo Corrida</th>
                <th>Frenagem</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${desempenhos}" var="desempenho">
                <tr>
                    <td><c:out value="${desempenho.idDesempenho}" /></td>
                    <td><c:out value="${desempenho.nome}" /></td>
                    <td><c:out value="${desempenho.data}" /></td>
                    <td><c:out value="${desempenho.hora}" /></td>
                    <td><c:out value="${desempenho.aceleracaoMedia}" /></td>
                    <td><c:out value="${desempenho.velocidadeMedia}" /></td>
                    <td><c:out value="${desempenho.tempoCorrida}" /></td>
                    <td><c:out value="${desempenho.frenagem}" /></td>
                    <td><a href="ManterDesempenhoController?acao=prepararEditar&idDesempenho=<c:out value="${desempenho.idDesempenho}" />">Editar</a></td>
                    <td><a href="ManterDesempenhoController?acao=prepararExcluir&idDesempenho=<c:out value="${desempenho.idDesempenho}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterDesempenhoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
