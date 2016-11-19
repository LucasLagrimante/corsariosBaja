<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Automóvel</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Automovel - ${operacao}</h2>
            <form action="ManterAutomovelController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdAutomovel" type="text" value="${automovel.idAutomovel}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Nome:</td>
                        <td align="right"><input name="txtNome" type="text" value="${automovel.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Cor:</td>
                        <td align="right"><input name="txtCor" type="text" value="${automovel.cor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Data Término Projeto:</td>
                        <td align="right"><input name="txtDataTerminoProjeto" type="data" value="${automovel.dataTerminoProjeto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Peso Carro:</td>
                        <td align="right"><input name="txtPesoCarro" type="text" value="${automovel.pesoCarro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Peso Chassi:</td>
                        <td align="right"><input type="text" name="txtPesoChassi"  value="${automovel.pesoChassi}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Custo Total:</td>
                        <td align="right"><input type="text" name="txtCustoTotal"  value="${automovel.custoTotal}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>