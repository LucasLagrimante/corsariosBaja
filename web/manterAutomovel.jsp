<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Automovel</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Automovel - ${operacao}</h2>
            <form action="ManterAutomovelController?acao=confirmar${operacao}" method="POST" name="frmManterAutomovel">
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdAutomovel" type="text" required="required" pattern="[0-9]+$" value="${automovel.idAutomovel}" placeholder="Digite números!" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Nome:</td>
                            <td align="right"><input name="txtNome" type="text" value="${automovel.nome}" required="required" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Cor:</td>
                            <td align="right"><input name="txtCor" type="text" required="required" value="${automovel.cor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Data Termino Projeto:</td>
                            <td align="right"><input name="txtDataTerminoProjeto" type="date" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18" value="${automovel.dataTerminoProjeto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Peso Carro:</td>
                            <td align="right"><input name="txtPesoCarro" type="text" required="required" pattern="(?:\d*\.)?\d+" value="${automovel.pesoCarro}" placeholder="Digite números!"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Peso Chassi:</td>
                            <td align="right"><input type="text" required="required" pattern="(?:\d*\.)?\d+" name="txtPesoChassi"  value="${automovel.pesoChassi}" placeholder="Digite números!" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Custo Total:</td>
                            <td align="right"><input type="text" required="required" pattern="(?:\d*\.)?\d+" name="txtCustoTotal"  value="${automovel.custoTotal}" placeholder="Digite números!" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>