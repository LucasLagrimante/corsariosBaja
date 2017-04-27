<%-- 
    Document   : pesquisaDesign
    Created on : 20/09/2016, 09:17:12
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Design</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>    <form class="form">
            <form class="form">
                <br><br><br><br>
                <h1 align="center">Pesquisa de Design</h1>
                <table border align="center">
                    <tr>
                        <th>Código Design</th>
                        <th>Caminho</th>
                        <th>Automovel</th>
                        <th colspan="2">Ação</th>
                    </tr>
                    <c:forEach items="${designs}" var="design">
                        <tr>
                            <td><c:out value="${design.idDesign}" /></td>
                            <td><c:out value="${design.caminhoImagem}" /></td>
                            <td><c:out value="${design.idAutomovel}" /></td>
                            <td><a href="ManterDesignController?acao=prepararEditar&idDesign=<c:out value="${design.idDesign}" />">Editar</a></td>
                            <td><a href="ManterDesignController?acao=prepararExcluir&idDesign=<c:out value="${design.idDesign}" />">Excluir</a></td>
                        </tr>
                    </c:forEach>
                    <tr> 
                        <td  align="center" colspan="9">
                            <input type="button" value="Imprimir" onclick="window.location.href = 'RelatorioController?relatorioNome=reportDesign.jasper'">
                            <input type="button" value="Voltar" onclick="window.location.href = 'index.jsp'">
                        </td>
                    </tr>
            </form>

        </table>

</body>
</html>
