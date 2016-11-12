<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Livro de Frequencia Diaria</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Livro de Frequencia Diaria ${operacao}</h2>
            <h2 align="center">10/09/2016   17:47</h2>
            <form action="ManterFrequenciaController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">Id: </td>
                        <td align="right"><input name="txtIdFrequencia" type="text" value="${frequencia.idFrequencia}"></td>
                    </tr>
                    <tr>                       
                        <td align="left">Data: </td>
                        <td align="right"><input name="txtData" type="text" value="${frequencia.data}"></td>
                    </tr>
                    <tr>
                        <td align="left">Estado: </td>
                        <td align="right"><input name="txtEstado" type="text" value="${frequencia.estado}"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>