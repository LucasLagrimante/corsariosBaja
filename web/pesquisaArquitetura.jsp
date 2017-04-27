<%-- 
    Document   : pesquisaArquitetura
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
        <title>Pesquisa de Arquitetura</title>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/favicon.ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body><form class="form">
            <br><br><br><br>
            <h1 align="center">Pesquisa de Arquitetura</h1>
            <table border align="center">
                <tr>
                    <th>Código Arquitetura</th>
                    <th>Caminho</th>
                    <th>Automovel</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${arquiteturas}" var="arquitetura">
                    <tr>
                        <td><c:out value="${arquitetura.idArquitetura}" /></td>
                        <td><c:out value="${arquitetura.caminhoImagem}" /></td>
                        <td><c:out value="${arquitetura.idAutomovel}" /></td>
                        <td><a href="ManterArquiteturaController?acao=prepararEditar&idArquitetura=<c:out value="${arquitetura.idArquitetura}" />">Editar</a></td>
                        <td><a href="ManterArquiteturaController?acao=prepararExcluir&idArquitetura=<c:out value="${arquitetura.idArquitetura}" />">Excluir</a></td>
                    </tr>
                </c:forEach>
                <tr> 
                    <td  align="center" colspan="9"> 
                        <input type="button" value="Imprimir" onclick="window.location.href = 'RelatorioController?relatorioNome=reportArquitetura.jasper'">
                        <input type="button" value="Voltar" onclick="window.location.href = 'index.jsp'">
                    </td>
                </tr>
        </form>

    </table>

</body>
</html>
