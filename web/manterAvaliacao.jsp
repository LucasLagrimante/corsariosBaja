<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Avaliacao</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Avaliacao - ${operacao}</h2>
            <form action="ManterAvaliacaoController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">ID: </td>
                        <td align="right"><input name="txtIdAvaliacao" type="text" value="${avaliacao.idAvaliacao}"></td>
                    </tr>
                    <tr>
                        <td align="left">Frequencia: </td>
                        <td align="right"><input name="txtFrequencia" type="text" value="${avaliacao.frequencia}"></td>
                    </tr>
                    <tr>
                        <td align="left">Comparecimento: </td>
                        <td align="right"><input name="txtComparecimento" type="text" value="${avaliacao.comparecimento}"></td>
                    </tr>
                    <tr>
                        <td align="left">Data: </td>
                        <td align="right"><input name="txtData" type="data" value="${avaliacao.data}"></td>
                    </tr>
                    <tr>               
                        <td colspan="2" align="center"><input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>