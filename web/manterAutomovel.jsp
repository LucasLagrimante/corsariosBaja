<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Veículo</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Automovel - ${operacao}</h2>
            <form action="">
                <table>
                    <tr>
                        <td align="left">Nome:</td>
                        <td align="right"><input type="text" value="${automovel.nome}"></td>
                    </tr>
                    <tr>
                        <td align="left">Cor:</td>
                        <td align="right"><input type="text" value="${automovel.cor}"></td>
                    </tr>
                    <tr>
                        <td align="left">Data Término Projeto:</td>
                        <td align="right"><input type="data" value="${automovel.dataTerminoProjeto}"></td>
                    </tr>
                    <tr>
                        <td align="left">Peso Carro:</td>
                        <td align="right"><input type="text"value="${automovel.pesoCarro}"></td>
                    </tr>
                    <tr>
                        <td align="left">Peso Chassi:</td>
                        <td align="right"><input type="text" value="${automovel.pesoChassi}"></td>
                    </tr>
                    <tr>
                        <td align="left">Custo Total:</td>
                        <td align="right"><input type="text" value="${automovel.custoTotal}"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"> <input type="reset" value="Apagar"> <input type="submit" value="Incluir"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>