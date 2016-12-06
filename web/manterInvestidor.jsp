<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Investimentos Monetários</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Investimentos- ${operacao}</h2>
            <form action="ManterInvestidorController?acao=confirmar${operacao}" method="POST" name="frmManterInvestidor">
                <table>
                    <tr>
                        <td align="left">Pessoa: </td>
                        <td align="right">                              
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectPessoa" value="${investidor.pessoa.idPessoa }"></c:if>
                            <select name="selectPessoa" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${pessoas}" var="pessoa">
                                    <option value="${pessoa.idPessoa}" <c:if test="${investidor.pessoa.idPessoa  == pessoa.idPessoa}"> selected</c:if>> ${pessoa.nome} </option>
                                </c:forEach>
                            </select>   
                        </td>				
                    </tr>
                    <tr>
                        <td align="left">ID: </td>
                        <td align="right"> <input type="text" name="txtIdInvestidor" value="${investidor.idInvestidor}" required="required" pattern="[0-9]+$" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Valor Doado: </td>
                            <td align="right"> <input type="text" name="txtValorDoado" required="required" pattern="(?:\d*\.)?\d+" value="${investidor.valorDoado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>