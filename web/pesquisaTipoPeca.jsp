<%-- 
    Document   : pesquisaTipoPeca
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
        <title>Pesquisa de Tipo de Peca</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>    <form class="form">
            <form class="form">
                <br><br><br><br>
                <h1 align="center">Pesquisa de Tipo de Peca</h1>
                <table border align="center">
                    <tr>
                        <th>Código Tipo Peca</th>
                        <th>Nome TipoPeca</th>
                        <th colspan="2">Ação</th>
                    </tr>
                    <c:forEach items="${tiposPeca}" var="tipoPeca">
                        <tr>
                            <td><c:out value="${tipoPeca.idTipoPeca}" /></td>
                            <td><c:out value="${tipoPeca.nome}" /></td>
                            <td><a href="ManterTipoPecaController?acao=prepararEditar&idTipoPeca=<c:out value="${tipoPeca.idTipoPeca}" />">Editar</a></td>
                            <td><a href="ManterTipoPecaController?acao=prepararExcluir&idTipoPeca=<c:out value="${tipoPeca.idTipoPeca}" />">Excluir</a></td>
                        </tr>
                    </c:forEach>
                    <tr> 
                        <td  align="center" colspan="9">
                            <input type="button" value="Imprimir" onclick="window.location.href = 'RelatorioController?relatorioNome=reportTipoPeca.jasper'">
                            <input type="button" value="Voltar" onclick="window.location.href = 'index.jsp'">
                        </td>
                    </tr>
                </table>
                </body>
                </html>
