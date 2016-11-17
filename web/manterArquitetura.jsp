<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Arquitetura</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Arquitetura - ${operacao}</h2>
            <form action="ManterArquiteturaController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">Automóvel: </td>
                        <td align="right">
                            <select name="selectAutomovel" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>> 
                                <option value="0" <c:if test="${automovel.idAutomovel == null}"> selected</c:if>> </option>
                                <c:forEach items="${automoveis}" var="automovel">
                                    <option value="${automovel.idAutomovel}" <c:if test="${arquitetura.automovel.idAutomovel == automovel.idAutomovel}"> selected</c:if>> ${automovel.nome} </option>
                                </c:forEach>
                            </select>
                        </td>				
                    </tr>
                    <tr>
                        <td align="left">ID: </td>
                        <td align="right"><input name="txtIdArquitetura" type="text" value="${arquitetura.idArquitetura}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Imagem: </td>
                                <td align="right"><input name="txtCaminhoImagem" type="text" value="${arquitetura.caminhoImagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Confirmar" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>