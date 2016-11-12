<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Arquitetura</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Arquitetura - ${operacao}</h2>
            <form action="ManterArquiteturaController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">ID: </td>
                        <td align="right"><input name="txtIdArquitetura" type="text" value="${arquitetura.idArquitetura}"></td>
                    </tr>
                    <tr>
                        <td align="left">Imagem: </td>
                        <td align="right"><input name="txtCaminhoImagem" type="text" value="${arquitetura.caminhoImagem}"></td>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Incluir"><input type="reset" value="Apagar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>