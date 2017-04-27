<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Desempenho de Competição</title>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div align="center"  class="login">
            <h1 align="center">${operacao}<br>Desempenho de Competição</h1>
            <form class="form" action="ManterDesempenhoController?acao=confirmar${operacao}?" method="POST" name="frmManterDesempenho">
                <br>
                <abbr>Automóvel</abbr>
                <p class="field">
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectAutomovel" value="${desempenho.automovel.idAutomovel}"></c:if>
                    <select name="selectAutomovel" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${automoveis}" var="automovel">
                            <option value="${automovel.idAutomovel}" <c:if test="${desempenho.automovel.idAutomovel == automovel.idAutomovel}"> selected</c:if>> ${automovel.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <abbr>Tipo Pista</abbr>
                <p class="field">
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectTipoPista" value="${desempenho.tipopista.idTipoPista}"></c:if>
                    <select name="selectTipoPista" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${tipospista}" var="tipopista">
                            <option value="${tipopista.idTipoPista}" <c:if test="${desempenho.tipopista.idTipoPista == tipopista.idTipoPista}"> selected</c:if>> ${tipopista.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <abbr>Motorista</abbr>
                <p class="field">
                    <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectIntegrante" value="${desempenho.integrante.matricula}"></c:if>
                    <select name="selectIntegrante" required="required"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                        <c:forEach items="${integrantes}" var="integrante">
                            <option value="${integrante.matricula}" <c:if test="${desempenho.integrante.matricula == integrante.matricula}"> selected</c:if>> ${integrante.pessoa.nome} </option>
                        </c:forEach>
                    </select>
                </p>
                <br>
                <abbr>ID</abbr>
                <p class="field">
                    <input name="txtIdDesempenho" value="${desempenho.idDesempenho}" type="text"  required="required" pattern="[0-9]+$"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>       <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Nome desempenho</abbr>
                    <p class="field">
                        <input name="txtNome" value="${desempenho.nome}" type="text" required="required" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>       <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Data</abbr>
                    <p class="field">
                        <input name="txtData" value="${desempenho.data}" type="text" required="required" maxlength="10" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="2010-01-01" max="2018-02-18"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>       <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Hora</abbr>
                    <p class="field">
                        <input name="txtHora" value="${desempenho.hora}" type="text" required="required"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>       <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Aceleração Média</abbr>
                    <p class="field">

                        <input name="txtAceleracaoMedia" value="${desempenho.aceleracaoMedia}"  placeholder="Digite apenas números!" type="text" required="required" pattern="(?:\d*\.)?\d+" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>       <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Velocidade Média: Automóvel</abbr>
                    <p class="field">

                        <input name="txtVelocidadeMedia" value="${desempenho.velocidadeMedia}"  placeholder="Digite apenas números!" type="text"  required="required" pattern="(?:\d*\.)?\d+"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>       <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Tempo de Pista</abbr>
                    <p class="field">
                        <input name="txtTempoPista" value="${desempenho.tempoPista}" placeholder="Digite apenas números!"  required="required" type="text" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <i class="fa fa-circle"></i>
                    </p>
                    <abbr>Frenagem</abbr>
                    <p class="field">
                        <input name="txtFrenagem" value="${desempenho.frenagem}"  placeholder="Digite apenas números!" type="text" required="required" pattern="(?:\d*\.)?\d+"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    <i class="fa fa-circle"></i>
                </p>
                <input type="submit" value="Confirmar">
            </form>
        </div>
    </body>
</html>