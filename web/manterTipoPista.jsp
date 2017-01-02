<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Tipo de Pista</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Cadastrar Tipo de Pista ${operacao}</h2>
            <form action="ManterTipoPistaController?acao=confirmar${operacao}" method="POST" name="frmManterTipoPista" onsubmit="return validarFormulario(this)">
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdTipoPista" type="text" value="${tipoPista.idTipoPista}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Tipo da Pista: </td>
                        <td align="right"> <input name="txtNome" type="text" value="${tipoPista.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if (form.txtIdTipoPista.value == ""){
                    mensagem = mensagem + "Informe o ID\n";
                }
                if (!campoNumerico(form.txtIdTipoPista.value)){
                    mensagem = mensagem + "O campo ID deve ser numérico\n";
                }
                if (form.txtNome.value == ""){
                    mensagem = mensagem + "Informe o Tipo da Pista\n";
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