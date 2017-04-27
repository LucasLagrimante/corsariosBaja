<%-- 
    Document   : pesquisaAutomovel
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
        <title>Pesquisa de Automóvel</title>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/favicon.ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <form class="form">
            <br><br><br><br>
            <h1 align="center">Pesquisa de Automóvel</h1>
            <table border="2" align="center">
                <tr>
                    <th>Código Automóvel</th>
                    <th>Nome Automóvel</th>
                    <th>Cor</th>
                    <th>Data de término do projeto</th>
                    <th>Peso Carro</th>
                    <th>Peso Chassi</th>
                    <th>Custo Total</th>
                    <th colspan="2">Ação</th>
                </tr>
                <c:forEach items="${automoveis}" var="automovel">
                    <tr>
                        <td><c:out value="${automovel.idAutomovel}" /></td>
                        <td><c:out value="${automovel.nome}" /></td>
                        <td><c:out value="${automovel.cor}" /></td>
                        <td><c:out value="${automovel.dataTerminoProjeto}" /></td>
                        <td><c:out value="${automovel.pesoCarro}" /></td>
                        <td><c:out value="${automovel.pesoChassi}" /></td>
                        <td><c:out value="${automovel.custoTotal}" /></td>
                        <td><a href="ManterAutomovelController?acao=prepararEditar&idAutomovel=<c:out value="${automovel.idAutomovel}" />">Editar</a></td>
                        <td><a href="ManterAutomovelController?acao=prepararExcluir&idAutomovel=<c:out value="${automovel.idAutomovel}" />">Excluir</a></td>
                    </tr>
                </c:forEach>
                <tr> 
                    <td  align="center" colspan="9">
                        <select name="selectTipoRelatorio" required="required">   
                            <option value="completo">Relatório Completo</option>
                            <option value="filtroCor">Filtro Por Cor</option>
                            <option value="filtroPeso">Filtro Por Peso</option>
                        </select>

                        <select name="selectCor" hidden="hidden" required="required">   
                            <c:forEach items="${cores}" var="cor">
                                <option value="${cor}"> ${cor}</option>
                            </c:forEach>
                        </select>

                        <select name="selectPeso" hidden="hidden" required="required">   
                            <c:forEach items="${pesos}" var="peso">
                                <option value="${peso}"> ${peso}</option>
                            </c:forEach>
                        </select>

                        <input type="button" value="Imprimir" name="imprimir">
                        <input type="button" value="Voltar" onclick="window.location.href = 'index.jsp'">
                    </td>
                </tr>
        </form>
    </table>
</body>
</html>

<script type="text/javascript">
    $(document).ready(function () {
        $("[name='selectCor']").hide();
        $("[name='selectPeso']").hide();

        $("[name='selectTipoRelatorio']").change(function () {
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "completo") {
                $("[name='selectCor']").hide();
                $("[name='selectPeso']").hide();
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroCor") {
                $("[name='selectCor']").show();
                $("[name='selectPeso']").hide();
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroPeso") {
                $("[name='selectCor']").hide();
                $("[name='selectPeso']").show();
            }
        });
        $("[name='imprimir']").click(function () {
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "completo") {
                window.location.href = 'RelatorioController?relatorioNome=reportAutomovel.jasper'
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroPeso") {
                window.location.href = 'RelatorioController?relatorioNome=reportAutomovelPorPeso.jasper&parametro=' + $("[name='selectPeso'] option:selected").val();
            }
            if ($("[name='selectTipoRelatorio'] option:selected").val() === "filtroCor") {
                window.location.href = 'RelatorioController?relatorioNome=reportAutomovelPorCor.jasper&parametro=' + $("[name='selectCor'] option:selected").val();
            }
        });
    });
</script>
