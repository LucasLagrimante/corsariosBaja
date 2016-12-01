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
            <form action="ManterAvaliacaoController?acao=confirmar${operacao}" method="POST" name="frmManterAvaliacao" onsubmit="return validarFormulario(this)">
                <table>
                    <tr>
                        <td align="left">ID: </td>
                        <td align="right"><input name="txtIdAvaliacao" type="text" value="${avaliacao.idAvaliacao}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Frequencia: </td>
                            <td align="right"><input name="txtFrequencia" type="text" value="${avaliacao.frequencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Desempenho na avaliação: </td>
                            <td align="right"><input name="txtComparecimento" type="text" value="${avaliacao.comparecimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Data: </td>
                            <td align="right"><input name="txtData" type="data" value="${avaliacao.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
        <SCRIPT language="JavaScript">
            
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++) 
                { 
                    umCaracter = valor.charAt(i); 
                    if (caracteresValidos.indexOf(umCaracter) == -1) 
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }
            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtIdAvaliacao.value == ""){
                    mensagem = mensagem + "Informe o Id\n";
                }                             
                if (form.txtFrequencia.value == ""){
                    mensagem = mensagem + "Informe a Frquencia\n";
                }             
                if (form.txtComparecimento.value == ""){
                    mensagem = mensagem + "Informe o Comparecimento\n";
                }                  
                if (form.txtData.value == ""){
                    mensagem = mensagem + "Informe a Data\n";
                }
                if (!campoNumerico(form.txtIdAvaliacao.value)){
                    mensagem = mensagem + "Código da avaliacao deve ser numérico\n";
                } 
                if (!campoNumerico(form.txtFrequencia.value)){
                    mensagem = mensagem + "Frequencia deve ser numérica\n";
                }                  
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            
        </SCRIPT>        
        </div>
    </body>
</html>