<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Peça</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Cadastrar peça ${operacao}</h2>
            <form action="">
                <table>
                    <tr>
                        <td align="left">Veículo </td>
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
                        <td align="left">Tipo de Peça: </td>
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
                        <td align="left">Nome: </td>
                        <td align="right"><input type="text" value="${peca.nome}"></td>
                    </tr>
                    <tr>
                        <td align="left">Modelo: </td>
                        <td align="right"><input type="text" value="${peca.modelo}"></td>
                    </tr>
                    <tr>
                        <td align="left">Preço: </td>
                        <td align="right"><input type="text" value="${peca.preco}"></td>
                    </tr>
                    <tr>
                        <td align="left">Quantidade: </td>
                        <td align="right"><input type="number" value="${peca.quantidade}"  min="1" size="4"> </td>
                    </tr>
                    <tr>
                        <td colspan = "2" align="center"><input type="submit" value="Cadastrar Tipo de Peca"> <input type="reset" value="Apagar"> <input type="submit" value="Enviar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>