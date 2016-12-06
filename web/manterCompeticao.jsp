<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form action="ManterCompeticaoController?acao=confirmar${operacao}" method="POST" name="frmManterCompeticao">
                <table>

                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdCompeticao" type="text" required="required" pattern="[0-9]+$"  value="${competicao.idCompeticao}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Nome: </td>
                            <td align="right"><input name="txtNome" type="text" value="${competicao.nome}" required="required" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Data: </td>
                            <td align="right"><input name="txtData" type="date" value="${competicao.data}" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Hora: </td>
                            <td align="right"><input name="txtHora" value="${competicao.hora}" required="required" type="time" required="required" maxlength="8" pattern="^(?:(?:([01]?\d|2[0-3]):)?([0-5]?\d):)?([0-5]?\d)$" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Local: </td>
                            <td align="right"><input name="txtLocal" required="required" type="text" value="${competicao.local}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Tipo Pista: </td>
                            <td align="right">
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectTipoPista" value="${competicao.tipopista.idTipoPista}"></c:if>
                            <select name="selectTipoPista" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${tipospista}" var="tipopista">
                                    <option value="${tipopista.idTipoPista}" <c:if test="${competicao.tipopista.idTipoPista == tipopista.idTipoPista}"> selected</c:if>> ${tipopista.nome} </option>
                                </c:forEach>
                            </select>
                        </td>				
                    </tr>
                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
            <button onclick="window.location.href = 'http://localhost:8080/corsariosBaja/ManterTipoPistaController?acao=prepararIncluir'">Cadastrar Tipos de Pista</button>
        </div>
    </body>
</html>