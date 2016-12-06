<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Avaliacao</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Avaliacao - ${operacao}</h2>
            <form action="ManterAvaliacaoController?acao=confirmar${operacao}" method="POST" name="frmManterAvaliacao">
                <table>
                    <tr>
                        <td align="left">ID: </td>
                        <td align="right"><input name="txtIdAvaliacao" type="text" value="${avaliacao.idAvaliacao}" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Frequencia: </td>
                            <td align="right"><input name="txtFrequencia" type="text" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!" value="${avaliacao.frequencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Desempenho na avaliação: </td>
                            <td align="right">
                                <select name="txtComparecimento" value="${avaliacao.comparecimento}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                  <option value="otimo" <c:if test="${avaliacao.comparecimento == 'otimo'}"> selected</c:if>>Ótimo</option>
                                  <option value="bom" <c:if test="${avaliacao.comparecimento == 'bom'}"> selected</c:if>>Bom</option>
                                  <option value="medio" <c:if test="${avaliacao.comparecimento == 'medio'}"> selected</c:if>>Médio</option>
                                  <option value="ruim" <c:if test="${avaliacao.comparecimento == 'ruim'}"> selected</c:if>>Ruim</option>
                                  <option value="pessimo" <c:if test="${avaliacao.comparecimento == 'pessimo'}"> selected</c:if>>Péssimo</option>
                                </select> 
                        </tr>
                        <tr>
                            <td align="left">Data: </td>
                            <td align="right"><input name="txtData" type="date" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18" value="${avaliacao.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Integrante: </td>                            
                            <td align="right">
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectIntegrante" value="${avaliacao.integrante.matricula}"></c:if>
                            <select name="selectIntegrante" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${integrantes}" var="integrante">
                                    <option value="${integrante.matricula}" <c:if test="${avaliacao.integrante.matricula == integrante.matricula}"> selected</c:if>> ${integrante.pessoa.nome} </option>
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