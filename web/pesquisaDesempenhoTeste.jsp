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
    </head>
    <body>
        <h1>Pesquisa de Desempenho Teste</h1>
        <table border="1">
            <tr>
                <th>Código DesempenhoTeste</th>
                <th>Nome DesempenhoTeste</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${desempenhosTestes}" var="desempenhoTeste">
                <tr>
                    <td><c:out value="${desempenhoTeste.idDesempenhoTeste}" /></td>
                    <td><c:out value="${desempenhoTeste.nome}" /></td>
                    <td><a href="ManterDesempenhoTesteController?acao=prepararEditar&idDesempenhoTeste=<c:out value="${desempenhoTeste.idDesempenhoTeste}" />">Editar</a></td>
                    <td><a href="ManterDesempenhoTesteController?acao=prepararExcluir&idDesempenhoTeste=<c:out value="${desempenhoTeste.idDesempenhoTeste}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterDesempenhoTesteController?acao=preparaIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
