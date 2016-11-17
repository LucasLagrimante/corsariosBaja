<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Investidor</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
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
                    <button onclick="window.location.href = 'index.jsp'">Voltar</button>
                </td>
            </tr>
        </table>

    </body>
</html>