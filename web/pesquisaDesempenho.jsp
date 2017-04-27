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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>    <form class="form">
            <form class="form">
                <br><br><br><br>
                <h1 align="center">Pesquisa de Desempenho</h1>
                <table border align="center">
                    <tr>
                        <th>Código Desempenho</th>
                        <th>Automóvel</th>
                        <th>Tipo Pista</th>
                        <th>Motorista</th>
                        <th>Desempenho</th>
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
                            <td><c:out value="${desempenho.idAutomovel}" /></td>
                            <td><c:out value="${desempenho.idTipoPista}" /></td>
                            <td><c:out value="${desempenho.matricula}" /></td>
                            <td><c:out value="${desempenho.nome}" /></td>
                            <td><c:out value="${desempenho.data}" /></td>
                            <td><c:out value="${desempenho.hora}" /></td>
                            <td><c:out value="${desempenho.aceleracaoMedia}" /></td>
                            <td><c:out value="${desempenho.velocidadeMedia}" /></td>
                            <td><c:out value="${desempenho.tempoPista}" /></td>
                            <td><c:out value="${desempenho.frenagem}" /></td>
                            <td><a href="ManterDesempenhoController?acao=prepararEditar&idDesempenho=<c:out value="${desempenho.idDesempenho}" />">Editar</a></td>
                            <td><a href="ManterDesempenhoController?acao=prepararExcluir&idDesempenho=<c:out value="${desempenho.idDesempenho}" />">Excluir</a></td>
                        </tr>
                    </c:forEach>
                    <tr> 
                        <td  align="center" colspan="13"> 
                            <input type="button" value="Imprimir" onclick="window.location.href = 'RelatorioController?relatorioNome=reportDesempenho.jasper'">
                            <input type="button" value="Voltar" onclick="window.location.href = 'index.jsp'">
                        </td>
                    </tr>
            </form>

        </table>
</body>
</html>