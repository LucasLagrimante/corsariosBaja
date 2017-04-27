<%-- 
    Document   : pesquisaIntegrante
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
        <title>Pesquisa de Integrante</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>    <form class="form">
            <form class="form">
                <br><br><br><br>
                <h1 align="center">Pesquisa de Integrante</h1>
                <table border align="center">
                    <tr>
                        <th>Matricula</th>
                        <th>Carga Horaria Disponivel</th>
                        <th>Pessoa</th>
                        <th colspan="2">Ação</th>
                    </tr>
                    <c:forEach items="${integrantes}" var="integrante">
                        <tr>
                            <td><c:out value="${integrante.matricula}" /></td>
                            <td><c:out value="${integrante.cargaHorariaDisponivel}" /></td>
                            <td><c:out value="${integrante.idPessoa}" /></td>
                            <td><a href="ManterIntegranteController?acao=prepararEditar&txtMatricula=<c:out value="${integrante.matricula}" />">Editar</a></td>
                            <td><a href="ManterIntegranteController?acao=prepararExcluir&txtMatricula=<c:out value="${integrante.matricula}" />">Excluir</a></td>
                        </tr>
                    </c:forEach>
                    <tr> 
                        <td  align="center" colspan="9">
                            <input type="button" value="Imprimir" onclick="window.location.href = 'RelatorioController?relatorioNome=reportIntegrante.jasper'">
                            <input type="button" value="Voltar" onclick="window.location.href = 'index.jsp'">
                        </td>
                    </tr>
            </form>

        </table>

</body>
</html>
