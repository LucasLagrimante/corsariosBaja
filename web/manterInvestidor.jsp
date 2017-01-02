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
            <form action="ManterInvestidorController?acao=confirmar${operacao}" method="POST" name="frmManterInvestidor" onsubmit="return validarFormulario(this)">
                <table>
                    <tr>
                        <td align="left">Pessoa: </td>
                        <td align="right">                              
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectPessoa" value="${investidor.pessoa.idPessoa }"></c:if>
                            <select name="selectPessoa" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${pessoas}" var="pessoa">
                                    <option value="${pessoa.idPessoa}" <c:if test="${investidor.pessoa.idPessoa  == pessoa.idPessoa}"> selected</c:if>> ${pessoa.nome} </option>
                                </c:forEach>
                            </select>   
                        </td>				
                    </tr>
                    <tr>
                        <td align="left">ID: </td>
                        <td align="right"> <input type="text" name="txtIdInvestidor" value="${investidor.idInvestidor}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Valor Doado: </td>
                            <td align="right"> <input type="text" name="txtValorDoado" value="${investidor.valorDoado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Confirmar"></td>
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
                if (form.txtIdInvestidor.value == ""){
                    mensagem = mensagem + "Informe o ID\n";
                }
                if (!campoNumerico(form.txtIdInvestidor.value)){
                    mensagem = mensagem + "O campo ID deve ser numérico\n";
                }
                if (form.txtValorDoado.value == ""){
                    mensagem = mensagem + "Informe o Valor Doado\n";
                }
                if (!campoNumerico(form.txtValorDoado.value)){
                    mensagem = mensagem + "O campo Valor Doado deve ser numérico\n";
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