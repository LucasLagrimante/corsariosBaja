<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Arquitetura</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center" class="login">
            <h1 align="center">${operacao} <br>Arquitetura</h1>
            <form action="ManterArquiteturaController?acao=confirmar${operacao}" method="POST" name="frmManterArquitetura" class="form">
                <br>
                <abbr>Automóvel</abbr>
                <p>
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectAutomovel" value="${arquitetura.automovel.idAutomovel}"></c:if>
                    <select name="selectAutomovel" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${automoveis}" var="automovel">
                            <option value="${automovel.idAutomovel}" <c:if test="${arquitetura.automovel.idAutomovel == automovel.idAutomovel}"> selected</c:if>> ${automovel.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <abbr>ID</abbr>
                <p class="field">
                <td align="right"><input name="txtIdArquitetura" placeholder="Digite apenas números!"  type="text" required="required" pattern="[0-9]+$" value="${arquitetura.idArquitetura}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Imagem</abbr>
                    <p class="field">
                    <td align="right"><input name="txtCaminhoImagem" type="text" required="required" value="${arquitetura.caminhoImagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <i class="fa fa-circle"></i>
                    </p>
                    <input type="submit" value="Confirmar" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
            </form>
        </div>
    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</html>