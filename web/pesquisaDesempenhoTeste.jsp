<%-- 
    Document   : pesquisaDesempenhoTeste
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
        <title>Pesquisa de Desempenho Teste</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Desempenho Teste</h1>
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Velocidade Média</th>
                <th>Aceleração Média</th>
                <th>Tempo Pista</th>
                <th>Frenagem</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${desempenhosTestes}" var="desempenhoTeste">
                <tr>
                    <td><c:out value="${desempenhoTeste.idDesempenhoTeste}" /></td>
                    <td><c:out value="${desempenhoTeste.nome}" /></td>
                    <td><c:out value="${desempenhoTeste.data}" /></td>
                    <td><c:out value="${desempenhoTeste.hora}" /></td>
                    <td><c:out value="${desempenhoTeste.velocidadeMedia}" /></td>
                    <td><c:out value="${desempenhoTeste.aceleracaoMedia}" /></td>
                    <td><c:out value="${desempenhoTeste.tempoPista}" /></td>
                    <td><c:out value="${desempenhoTeste.frenagem}" /></td>
                    <td><a href="ManterDesempenhoTesteController?acao=prepararEditar&idDesempenhoTeste=<c:out value="${desempenhoTeste.idDesempenhoTeste}" />">Editar</a></td>
                    <td><a href="ManterDesempenhoTesteController?acao=prepararExcluir&idDesempenhoTeste=<c:out value="${desempenhoTeste.idDesempenhoTeste}" />">Excluir</a></td>
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
