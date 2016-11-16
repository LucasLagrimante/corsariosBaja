<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Tipo de Pista</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Cadastrar Tipo de Pista- ${operacao}</h2>
            <form action="ManterTipoPistaController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdTipoPista" type="text" value="${tipoPista.idTipoPista}"></td>
                    </tr>
                    <tr>
                        <td align="left">Tipo da Pista: </td>
                        <td align="right"> <input name="txtNome" type="text" value="${tipoPista.nome}"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Enviar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>