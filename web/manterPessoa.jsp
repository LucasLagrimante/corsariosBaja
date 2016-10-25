<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Veículo</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <div align="center">
            <h2 align="center">Manter Pessoa - ${operacao}</h2>
            <form action="ManterPessoaController?acao=confirmar${operacao}" method="POST" >
                <table>
                    <tr>
                        <td align="left">Id:</td>
                        <td align="right"><input name="txtIdPessoa" type="text" value="${pessoa.idPessoa}"></td>
                    </tr>
                    <tr>
                        <td align="left">Nome:</td>
                        <td align="right"><input name="txtNome" type="text" value="${pessoa.nome}"></td>
                    </tr>
                    <tr>
                        <td align="left">Cpf:</td>
                        <td align="right"><input name="txtCpf" type="text" value="${pessoa.cpf}"></td>
                    </tr>
                    <tr>
                        <td align="left">Logradouro:</td>
                        <td align="right"><input name="txtLogradouro" type="data" value="${pessoa.logradouro}"></td>
                    </tr>
                    <tr>
                        <td align="left">Cep:</td>
                        <td align="right"><input name="txtCep" type="text" value="${pessoa.cep}"></td>
                    </tr>
                    <tr>
                        <td align="left">Bairro:</td>
                        <td align="right"><input type="text" name="txtBairro"  value="${pessoa.bairro}"></td>
                    </tr>
                    <tr>
                        <td align="left">Uf:</td>
                        <td align="right"><input type="text" name="txtUf" maxlength="2"  value="${pessoa.uf}"></td>
                    </tr>
                    <tr>
                        <td align="left">Numero:</td>
                        <td align="right"><input type="text" name="txtNumero"  value="${pessoa.numero}"></td>
                    </tr>
                    <tr>
                        <td align="left">Telefone:</td>
                        <td align="right"><input type="text" name="txtTelefone"  value="${pessoa.telefone}"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Incluir"> <input type="reset" value="Apagar"></td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>