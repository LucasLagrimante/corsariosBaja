<%-- 
    Document   : pesquisaPessoa
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
        <title>Pesquisa de Pessoa</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Pessoa</h1>
        <table border="1">
            <tr>
                <th>Código Pessoa</th>
                <th>Nome Pessoa</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${pessoas}" var="pessoa">
                <tr>
                    <td><c:out value="${pessoa.idPessoa}" /></td>
                    <td><c:out value="${pessoa.nome}" /></td>
                    <td><a href="ManterPessoaController?acao=prepararEditar&idPessoa=<c:out value="${pessoa.idPessoa}" />">Editar</a></td>
                    <td><a href="ManterPessoaController?acao=prepararExcluir&idPessoa=<c:out value="${pessoa.idPessoa}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterPessoaController?acao=preparaIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
