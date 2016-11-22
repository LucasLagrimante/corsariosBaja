<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
            <form action="ManterCompeticaoController?acao=confirmar${operacao}" method="post" name="frmManterCompeticao" onsubmit="return validarFormulario(this)">
                <table>

                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdCompeticao" type="text" value="${competicao.idCompeticao}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Nome: </td>
                            <td align="right"><input name="txtNome" type="text" value="${competicao.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Data: </td>
                            <td align="right"><input name="txtData" type="text" value="${competicao.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Hora: </td>
                            <td align="right"><input name="txtHora" type="text" value="${competicao.hora}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Local: </td>
                            <td align="right"><input name="txtLocal" type="text" value="${competicao.local}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Tipo Pista: </td>
                            <td align="right">
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectTipoPista" value="${competicao.tipopista.idTipoPista}"></c:if>
                            <select name="selectTipoPista" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
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
                if (form.txtIdCompeticao.value == ""){
                    mensagem = mensagem + "Informe o Id\n";
                }                             
                if (form.txtData.value == ""){
                    mensagem = mensagem + "Informe a Data/n";
                }             
                if (form.txtHora.value == ""){
                    mensagem = mensagem + "Informe a Hora\n";
                }                  
                if (form.txtLocal.value == ""){
                    mensagem = mensagem + "Informe o Local\n";
                }
                if (!campoNumerico(form.txtIdCompeticao.value)){
                    mensagem = mensagem + "Código da competição deve ser numérico\n";
                } 
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            
        </SCRIPT>        
            <button onclick="window.location.href = 'http://localhost:8080/corsariosBaja/ManterTipoPistaController?acao=prepararIncluir'">Cadastrar Tipos de Pista</button>
        </div>

    </body>
</html>