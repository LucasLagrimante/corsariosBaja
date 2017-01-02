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
        <title>Pesquisa de DesempenhoTeste</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1 align="center">Pesquisa de Desempenho Teste</h1>
        <table border align="center">
            <tr>
                <th>Código Desempenho Teste</th>
                <th>Automóvel</th>
                <th>Tipo Pista</th>
                <th>Motorista</th>
                <th>Desempenho Teste</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Aceleração Média</th>
                <th>Velocidade Média</th>
                <th>Tempo Corrida</th>
                <th>Frenagem</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${desempenhosTeste}" var="desempenhoTeste">
                <tr>
                    <td><c:out value="${desempenhoTeste.idDesempenhoTeste}" /></td>
                    <td><c:out value="${desempenhoTeste.idAutomovel}" /></td>
                    <td><c:out value="${desempenhoTeste.idTipoPista}" /></td>
                    <td><c:out value="${desempenhoTeste.matricula}" /></td>
                    <td><c:out value="${desempenhoTeste.nome}" /></td>
                    <td><c:out value="${desempenhoTeste.data}" /></td>
                    <td><c:out value="${desempenhoTeste.hora}" /></td>
                    <td><c:out value="${desempenhoTeste.aceleracaoMedia}" /></td>
                    <td><c:out value="${desempenhoTeste.velocidadeMedia}" /></td>
                    <td><c:out value="${desempenhoTeste.tempoPista}" /></td>
                    <td><c:out value="${desempenhoTeste.frenagem}" /></td>
                    <td><a href="ManterDesempenhoTesteController?acao=prepararEditar&idDesempenhoTeste=<c:out value="${desempenhoTeste.idDesempenhoTeste}" />">Editar</a></td>
                    <td><a href="ManterDesempenhoTesteController?acao=prepararExcluir&idDesempenhoTeste=<c:out value="${desempenhoTeste.idDesempenhoTeste}" />">Excluir</a></td>
                </tr>
            </c:forEach>
            <tr> 
                <td  align="center" colspan="13"> 
                    <button onclick="window.location.href = 'index.jsp'">Voltar</button>
                </td>
            </tr>
        </table>
    </body>
</html>