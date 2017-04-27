<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Avaliação</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <form class="form">
            <br><br><br><br>
            <h1 align="center">Pesquisa de Avaliação</h1>
            <table border align="center">
                <tr>
                    <th>Código Avaliação</th>
                    <th>Matricula Integante</th>
                    <th>Frequencia Avaliação</th>
                    <th>Desempenho Avaliação</th>
                    <th>Data Avaliação</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${avaliacoes}" var="avaliacao">
                    <tr>
                        <td><c:out value="${avaliacao.idAvaliacao}" /></td>
                        <td><c:out value="${avaliacao.matricula}" /></td>
                        <td><c:out value="${avaliacao.frequencia}" /></td>
                        <td><c:out value="${avaliacao.comparecimento}" /></td>
                        <td><c:out value="${avaliacao.data}" /></td>
                        <td><a href="ManterAvaliacaoController?acao=prepararEditar&idAvaliacao=<c:out value="${avaliacao.idAvaliacao}" />">Editar</a></td>
                        <td><a href="ManterAvaliacaoController?acao=prepararExcluir&idAvaliacao=<c:out value="${avaliacao.idAvaliacao}" />">Excluir</a></td>
                    </tr>
                </c:forEach>
                <tr> 
                    <td  align="center" colspan="9"> 
                        <input type="button" value="Imprimir" onclick="window.location.href = 'RelatorioController?relatorioNome=reportAvaliacao.jasper'">
                        <input type="button" value="Voltar" onclick="window.location.href = 'index.jsp'">
                    </td>
                </tr>
        </form>

    </table>

</body>
</html>
