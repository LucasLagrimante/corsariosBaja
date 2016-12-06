<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Frequencia</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Frequencia ${operacao}</h2>
            <form action="ManterFrequenciaController?acao=confirmar${operacao}" method="POST" name="frmManterFrequencia">
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdFrequencia"  type="text" required="required" pattern="[0-9]+$" value="${frequencia.idFrequencia}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Data: </td>
                            <td align="right"><input name="txtData" type="date" value="${frequencia.data}" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Estado: </td>
                            <td align="right">
                                <input required type="radio" name="radioEstado" value="presente" <c:if test="${frequencia.estado == 'presente'}"> checked</c:if> <c:if test="${operacao == 'Excluir'}"> disabled</c:if>> Presente
                            <input type="radio" name="radioEstado" value="ausente" <c:if test="${frequencia.estado == 'ausente'}"> checked</c:if> <c:if test="${operacao == 'Excluir'}"> disabled</c:if>> Ausente
                            </td>
                        </tr>
                        <tr>
                            <td align="left">Integrante: </td>                            
                            <td align="right">
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectIntegrante" value="${frequencia.integrante.matricula}"></c:if>
                            <select name="selectIntegrante" required <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${integrantes}" var="integrante">
                                    <option value="${integrante.matricula}" <c:if test="${frequencia.integrante.matricula == integrante.matricula}"> selected</c:if>> ${integrante.pessoa.nome} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>     
                    <tr>
                        <td colspan = "2" align="center"><input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>