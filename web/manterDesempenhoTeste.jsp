<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Desempenho de Teste</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Desempenho Teste - ${operacao}</h2>
            <form action="ManterDesempenhoTesteController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <!--                    <tr>
                                            <td align="left">Veículo: </td>
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
                                            <td align="left">Competição: </td>
                                            <td align="right">
                                                <select>
                                                    <option value="volvo">...</option>
                                                    <option value="saab">Saab</option>
                                                    <option value="mercedes">Mercedes</option>
                                                    <option value="audi">Audi</option>
                                                </select>
                                            </td>
                                        </tr>  -->
                    <tr>
                        <td align="left">ID: </td>
                        <td align="right"> <input name="txtIdDesempenhoTeste" value="${desempenhoTeste.idDesempenhoTeste}" type="text"></td>
                    </tr>
                    <tr>
                        <td align="left">Nome: </td>
                        <td align="right"> <input name="txtNome" value="${desempenhoTeste.nome}" type="text"></td>
                    </tr>
                    <tr>
                        <td align="left">Data: </td>
                        <td align="right"> <input name="txtData" value="${desempenhoTeste.data}" type="text"></td>
                    </tr>
                    <tr>
                        <td align="left">Hora: </td>
                        <td align="right"> <input name="txtHora" value="${desempenhoTeste.hora}" type="text"></td>
                    </tr></td>
                    </tr>
                    <tr>
                        <td align="left">Aceleração Média: </td>
                        <td align="right"> <input name="txtAceleracaoMedia" value="${desempenhoTeste.aceleracaoMedia}" type="text"></td>
                    </tr>
                    <tr>
                        <td align="left">Velocidade Média: </td>
                        <td align="right"> <input name="txtVelocidadeMedia" value="${desempenhoTeste.velocidadeMedia}" type="text"></td>
                    </tr>
                    <tr>
                        <td align="left">Tempo de Pista: </td>
                        <td align="right"> <input name="txtTempoPista" value="${desempenhoTeste.tempoPista}" type="text"></td>
                    </tr>
                    <tr>
                        <td align="left">Frenagem: </td>
                        <td align="right"><input name="txtFrenagem" value="${desempenhoTeste.frenagem}" type="text"></td>
                    </tr>
                    <!--                    <tr>
                                            <td align="left">Quesitos: </td>
                                            <td align="right">
                                                <select>
                                                    <option value="volvo">...</option>
                                                    <option value="saab">Saab</option>
                                                    <option value="mercedes">Mercedes</option>
                                                    <option value="audi">Audi</option>
                                                </select>
                                            </td>
                                        </tr>-->
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Cadastrar Quesitos"> <input type="submit" value="Cadastrar tipos de pista"> <input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>