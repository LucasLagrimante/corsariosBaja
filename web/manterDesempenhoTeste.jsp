<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
            <form action="ManterDesempenhoTesteController?acao=confirmar${operacao}" method="POST" name="frmManterDesempenhoTeste">
                <table>
                    <tr>
                        <td align="left">Automóvel: </td>
                        <td align="right">
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectAutomovel" value="${desempenhoTeste.automovel.idAutomovel}"></c:if>
                            <select name="selectAutomovel" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${automoveis}" var="automovel">
                                    <option value="${automovel.idAutomovel}" <c:if test="${desempenhoTeste.automovel.idAutomovel == automovel.idAutomovel}"> selected</c:if>> ${automovel.nome} </option>
                                </c:forEach>
                            </select>
                        </td>				
                    </tr>
                    <tr>
                        <td align="left">Tipo Pista: </td>
                        <td align="right">
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectTipoPista" value="${desempenhoTeste.tipopista.idTipoPista}"></c:if>
                            <select name="selectTipoPista" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${tipospista}" var="tipopista">
                                    <option value="${tipopista.idTipoPista}" <c:if test="${desempenhoTeste.tipopista.idTipoPista == tipopista.idTipoPista}"> selected</c:if>> ${tipopista.nome} </option>
                                </c:forEach>
                            </select>
                        </td>				
                    </tr>
                    <tr>
                        <td align="left">Motorista: </td>                            
                        <td align="right">
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectIntegrante" value="${desempenhoTeste.integrante.matricula}"></c:if>
                            <select name="selectIntegrante" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${integrantes}" var="integrante">
                                    <option value="${integrante.matricula}" <c:if test="${desempenhoTeste.integrante.matricula == integrante.matricula}"> selected</c:if>> ${integrante.pessoa.nome} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr> 
                    <tr>
                        <td align="left">ID: </td>
                        <td align="right"> <input name="txtIdDesempenhoTeste" value="${desempenhoTeste.idDesempenhoTeste}" type="text" required="required" pattern="[0-9]+$" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Nome desempenho: </td>
                            <td align="right"> <input name="txtNome" value="${desempenhoTeste.nome}" type="text" required="required" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Data: </td>
                            <td align="right"> <input name="txtData" value="${desempenhoTeste.data}" type="date" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Hora: </td>
                            <td align="right"> <input name="txtHora" value="${desempenhoTeste.hora}" type="time" required="required"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr></td>
                        </tr>
                        <tr>
                            <td align="left">Aceleração Média: </td>
                            <td align="right"> <input name="txtAceleracaoMedia" value="${desempenhoTeste.aceleracaoMedia}" type="text" required="required" pattern="(?:\d*\.)?\d+"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Velocidade Média: </td>
                            <td align="right"> <input name="txtVelocidadeMedia" value="${desempenhoTeste.velocidadeMedia}" type="text" required="required" pattern="(?:\d*\.)?\d+"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Tempo de Pista: </td>
                            <td align="right"> <input name="txtTempoPista" value="${desempenhoTeste.tempoPista}" required="required" type="time" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Frenagem: </td>
                            <td align="right"><input name="txtFrenagem" value="${desempenhoTeste.frenagem}" type="text" required="required" pattern="(?:\d*\.)?\d+" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>