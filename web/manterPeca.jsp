<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Peça</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Peça ${operacao}</h2>
            <form action="ManterPecaController?acao=confirmar${operacao}" method="POST" name="frmManterPeca" onsubmit="return validarFormulario(this)">
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdPeca"  type="text" value="${peca.idPeca}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Quantidade: </td>
                            <td align="right"><input name="txtQuantidade" type="textr" value="${peca.quantidade}"  min="1" size="4" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Nome: </td>
                            <td align="right"><input name="txtNome" type="text" value="${peca.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Modelo: </td>
                            <td align="right"><input name="txtModelo" type="text" value="${peca.modelo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Preço: </td>
                            <td align="right"><input name="txtPrecoCompra" type="text" value="${peca.precoCompra}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Tipo Peça: </td>
                            <td align="right">
                            <c:if test="${operacao == 'Excluir'}"><input type="hidden" name="selectTipoPeca" value="${peca.tipopeca.idTipoPeca}"></c:if>
                                <select name="selectTipoPeca" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>   
                                <c:forEach items="${tipopecas}" var="tipopeca">
                                    <option value="${tipopeca.idTipoPeca}" <c:if test="${peca.tipopeca.idTipoPeca == tipopeca.idTipoPeca}"> selected</c:if>> ${tipopeca.nome} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>     
                    <tr>
                        <td colspan = "2" align="center"><input type="submit" value="Cadastrar Tipo de Peca"> <input type="submit" value="Confirmar"></td>
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
                if (form.txtIdPeca.value == ""){
                    mensagem = mensagem + "Informe o ID\n";
                }
                if (!campoNumerico(form.txtIdPeca.value)){
                    mensagem = mensagem + "O campo ID deve ser numérico\n";
                }
                if (form.txtQuantidade.value == ""){
                    mensagem = mensagem + "Informe a Quantidade\n";
                }
                if (!campoNumerico(form.txtQuantidade.value)){
                    mensagem = mensagem + "O campo Quantidade deve ser numérico\n";
                }
                if (form.txtNome.value == ""){
                    mensagem = mensagem + "Informe o Nome\n";
                }
                if (form.txtModelo.value == ""){
                    mensagem = mensagem + "Informe o Modelo\n";
                }
                if (form.txtPrecoCompra.value == ""){
                    mensagem = mensagem + "Informe o Preço\n";
                }
                if (!campoNumerico(form.txtPrecoCompra.value)){
                    mensagem = mensagem + "O campo Preço deve ser numérico\n";
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