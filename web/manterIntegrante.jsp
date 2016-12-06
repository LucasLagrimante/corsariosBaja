<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
            <h2 align="center">Manter Integrante- ${operacao}</h2>
            <form action="ManterIntegranteController?acao=confirmar${operacao}" method="POST" name="frmManterIntegrante">
                <table>
                    <tr>
                        <td align="left">Pessoa: </td>
                        <td align="right">
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectPessoa" value="${integrante.pessoa.idPessoa}"></c:if>
                            <select name="selectPessoa"  required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${pessoas}" var="pessoa">
                                    <option value="${pessoa.idPessoa}" <c:if test="${integrante.pessoa.idPessoa == pessoa.idPessoa}"> selected</c:if>> ${pessoa.nome} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>     
                    <tr>
                        <td align="left">Matricula: </td>
                        <td align="right"> <input type="text" name="txtMatricula" required="required" pattern="[0-9]+$" maxlength="6" value="${integrante.matricula}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Carga Horaria Disponivel: </td>
                            <td align="right"> <input name="txtCargaHorariaDisponivel" type="time" required="required" maxlength="8" pattern="^(?:(?:([01]?\d|2[0-3]):)?([0-5]?\d):)?([0-5]?\d)$" value="${integrante.cargaHorariaDisponivel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>