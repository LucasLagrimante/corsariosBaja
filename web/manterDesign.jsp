<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Design</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Design - ${operacao}</h2>
            <form action="ManterDesignController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdDesign" type="text" value="${design.idDesign}"></td>
                    </tr>
                    <tr>
                    </tr>
                    <tr>
                        <td align="left">Imagem:</td>
                        <td align="right"><input name="txtImagem" type="text" value="${design.imagem}"></td>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Confirmar"><input type="reset" value="Apagar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>