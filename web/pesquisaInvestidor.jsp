<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Investidor</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>    <form class="form">
            <form class="form">
                <br><br><br><br>
                <h1 align="center">Pesquisa de Investidor</h1>
                <table border align="center">
                    <tr>
                        <th>Código do doador</th>
                        <th>Valor doado</th>
                        <th>Pessoa</th>


                        <th colspan="2">Ação</th>
                    </tr>
                    <c:forEach items="${investidores}" var="investidor">
                        <tr>
                            <td><c:out value="${investidor.idInvestidor}" /></td>
                            <td><c:out value="${investidor.valorDoado}" /></td>
                            <td><c:out value="${investidor.idPessoa}" /></td>


                            <td><a href="ManterInvestidorController?acao=prepararEditar&txtIdInvestidor=<c:out value="${investidor.idInvestidor}" />">Editar</a></td>
                            <td><a href="ManterInvestidorController?acao=prepararExcluir&txtIdInvestidor=<c:out value="${investidor.idInvestidor}" />">Excluir</a></td>
                        </tr>
                    </c:forEach>
                    <tr> 
                        <td  align="center" colspan="11">
                            <input type="button" value="Imprimir" onclick="window.location.href = 'RelatorioController?relatorioNome=reportInvestidor.jasper'">
                            <input type="button" value="Voltar" onclick="window.location.href = 'index.jsp'">
                        </td>
                    </tr>
            </form>

        </table>

</body>
</html>