<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Pessoa</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>

        <div align="center">
            <h2 align="center">Manter Pessoa - ${operacao}</h2>
            <form action="ManterPessoaController?acao=confirmar${operacao}" method="POST" name="frmManterPessoa" >
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdPessoa" type="text" value="${pessoa.idPessoa}" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Nome:</td>
                            <td align="right"><input name="txtNome" required="required" type="text" value="${pessoa.nome}" pattern="[a-z\s]+$" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">CPF:</td>
                            <td align="right"><input name="txtCpf" onkeypress="mascara(this, cpf)" maxlength="14" required="required" type="text" pattern="([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})" value="${pessoa.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Logradouro:</td>
                            <td align="right"><input name="txtLogradouro" required="required" type="text" value="${pessoa.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">CEP:</td>
                            <td align="right"><input name="txtCep" required="required"  type="text" pattern= "\d{5}-?\d{3}" maxlength="9" value="${pessoa.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Bairro:</td>
                            <td align="right"><input name="txtBairro" required="required" type="text"  value="${pessoa.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">UF:</td>
                            <td align="right"><input name="txtUf" type="text" required="required" pattern="[a-z\s]+$"  maxlength="2"  value="${pessoa.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Número:</td>
                            <td align="right"><input type="text" name="txtNumero" required="required" pattern="[0-9]+$" placeholder="Digite apenas números!"  value="${pessoa.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td align="left">Telefone:</td>
                            <td align="right"><input type="text" name="txtTelefone" type="tel" required="required" maxlength="15" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" placeholder="Formato: (99) 9999-9999"  value="${pessoa.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
            <script>
<script language="javascript">
                function mascara(o,f){



              
                    v_obj = o
                        v_
                        fun = f
                        setTimeout("execmascara()", 1)
        }
        function 
       
                
                execmascara(){

                        v_obj.va l
                    u
                        e = v_fun(v_obj.
                                value)
        }
        
        
           
                function leech(
            v){
                       
                    v = v.replace(/o/gi, "0")

                        v = v.replace(/i/gi, "1")
                        v = v.replace(/z/gi, "2")
                        v = v.replace(/e/gi, "3")
                        v = v.replace(/a/gi, "4")
                        v = v.replace(/s/gi, "5")
                        v = v.replace(/t/gi, "7")
                        return v
                        }
           
                function cpf(v){
             
                    v = v.replace(/D/g, "") //Remove tudo o que não é dígito
                        v = v.replace(/(d{3})(d)/, "$1.$2") //Coloca um ponto entre o terceiro e o quarto dígitos
                        v = v.replace(/(d{3})(d)/, "$1.$2") //Coloca um ponto entre o terceiro e o quarto dígitos
//de novo (para o segundo bloco de números)
                        v = v.repl
                ace(/(d{3})(d{1,2} )
                    $/, "$1-$2") //Coloca um hífen entre o terceiro e o quarto dígitos
                        return v
                            }
                        </script>

        </div>
    </body>
</html>