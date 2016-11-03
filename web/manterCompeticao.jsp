<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Competição</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Cadastrar Competição - ${operacao}</h2>
            <form action="ManterCompeticaoController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdCompeticao" type="text" value="${competicao.idCompeticao}"></td>
                    </tr>
                    <tr>
                        <td align="left">Nome: </td>
                        <td align="right"><input name="txtNome" type="text" value="${competicao.nome}"></td>
                    </tr>
                    <tr>
                        <td align="left">Data: </td>
                        <td align="right"><input name="txtData" type="text" value="${competicao.data}"></td>
                    </tr>
                    <tr>
                        <td align="left">Hora: </td>
                        <td align="right"><input name="txtHora" type="text" value="${competicao.hora}"></td>
                    </tr>
                    <tr>
                        <td align="left">Local: </td>
                        <td align="right"><input name="txtLocal" type="text" value="${competicao.local}"></td>
                    </tr>

                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Cadastrar tipos de pista"> <input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>