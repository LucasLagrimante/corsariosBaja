<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Desempenho de Teste</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Desempenho de Teste - ${operacao}</h2>
            <form action="ManterDesempenhoTesteController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">Código: </td>
                        <td align="right"><input name="txtIdDesempenhoTeste" type="text" value="${desempenhoTeste.idDesempenhoteste}"></td>
                    </tr>
                    <tr>
                        <td align="left">Nome: </td>
                        <td align="right"><input name="txtNome" type="text" value="${desempenhoTeste.nome}"></td>
                    </tr>
                    <tr>
                        <td align="left">Data: </td>
                        <td align="right"><input name="txtData" type="text" value="${desempenhoTeste.data}"></td>
                    </tr>
                    <tr>
                        <td align="left">Hora: </td>
                        <td align="right"><input name="txtHora" type="text" value="${desempenhoTeste.hora}"></td>
                    </tr>
                    <tr>
                        <td align="left">Velocidade Média: </td>
                        <td align="right"><input name="txtVelocidadeMedia" type="text" value="${desempenhoTeste.velocidadeMedia}"></td>
                    </tr>
                    <tr>
                        <td align="left">Aceleração Média: </td>
                        <td align="right"><input name="txtAceleracaoMedia" type="text" value="${desempenhoTeste.aceleracaoMedia}"></td>
                    </tr>
                    <tr>
                        <td align="left">Tempo de Pista: </td>
                        <td align="right"><input name="txtTempoPista" type="text" value="${desempenhoTeste.tempoPista}"></td>
                    </tr>
                    <tr>
                        <td align="left">Frenagem: </td>
                        <td align="right"><input name="txtFrenagem" type="text" value="${desempenhoTeste.frenagem}"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>