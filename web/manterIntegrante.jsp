<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Integrante</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Cadastrar Tntegrante ${operacao}</h2>
            <form action="">
                <table>
                    <tr>
                        <td align="left">Matricula: </td>
                        <td align="right"> <input type="text" name="txtMatricula" value="${integrante.nome}"></td>
                    </tr>
                    <tr>
                        <td align="left">Carga Horaria Disponivel: </td>
                        <td align="right"> <input type="text" name="txtCargaHorariaDisponivel" value="${integrante.sobrenome}"></td>
                    </tr>
                    <tr>
                        <td align="left">Pessoa: </td>
                        <td align="right">
                            <select name="selectTipoPeca"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0" <c:if test="${pessoa.idPessoa == null}"> selected</c:if>> </option>
                                <c:forEach items="${pessoas}" var="tipopeca">
                                    <option value="${pessoa.idPessoa}" <c:if test="${integrante.pessoa.idPessoa == pessoa.idPessoa}"> selected</c:if>> ${pessoa.nome} </option>
                                </c:forEach>
                            </select>
                        </td>				
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="reset" value="Apagar"> <input type="submit" value="Enviar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>