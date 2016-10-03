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
            <h2 align="center">Cadastrar Competição</h2>
            <form action="">
                <table>
                    <tr>
                        <td align="left">Nome: </td>
                        <td align="right"> <input type="text"></td>
                    </tr>
                    <tr>
                        <td align="left">Tipo de Pista: </td>
                        <td align="right">
                            <select>
                                <option value="volvo">...</option>
                                <option value="saab">Saab</option>
                                <option value="mercedes">Mercedes</option>
                                <option value="audi">Audi</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">Data e Hora: </td>
                        <td align="right"> <input type="datetime-local"></td>
                    </tr>
                    <tr>
                        <td align="left">Local: </td>
                        <td align="right"> <input type="text"></td>
                    </tr>

                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Cadastrar tipos de pista"> <input type="reset" value="Apagar"> <input type="submit" value="Enviar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>