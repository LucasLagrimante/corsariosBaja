<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Cadastrar Tipo de Peca</title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
</head>
<body>
    <div align="center" class="login">
        <h1 align="center">${operacao}<br>Tipo de Peça</h1>
        <form class="form" action="ManterTipoPecaController?acao=confirmar${operacao}" method="POST" name="frmManterTipoPeca">
          <br>
          <abbr>ID</abbr>
          <p  class="field">
            <input name="txtIdTipoPeca" type="text" value="${tipoPeca.idTipoPeca}"  placeholder="Digite apenas números!"  required="required" pattern="[0-9]+$"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
            <i class="fa fa-circle"></i>
        </p>
        <abbr>Tipo/Nome da Peca</abbr>
        <p  class="field">
            <input name="txtNome" type="text" value="${tipoPeca.nome}" required="required" pattern="[a-z\s]+$"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
            <i class="fa fa-circle"></i>
        </p>
        <input type="submit" value="Confirmar">
    </form>
</div>

</body>
<style>
  /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
  /*still in the works :P*/
  /*variables*/
  /*general style*/
  /*google font*/
  @import "http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,300,400,700)";
  body {
      font: 13px/20px "Open Sans", Tahoma, Verdana, sans-serif;
      color: #a7a599;
      background: #31302b;
  }

  /*Login form style*/
  /* === Logo === */
  .logo {
      background-position: center;
      height: 60px;
      width: 140px;
      margin: 100px auto 30px auto;
  }

  /* === Form === */
  .form {
      width: 100%;
  }
  .form .field {
      position: relative;
      margin: 0 50px;
  }
  .form .field i {
      font-size: 18px;
      left: 0px;
      top: 0px;
      position: absolute;
      height: 44px;
      width: 44px;
      color: #f7f3eb;
      background: #676056;
      text-align: center;
      line-height: 44px;
      transition: all 0.3s ease-out;
      pointer-events: none;
  }

  /* === Login styles === */
  .login {
      position: relative;
      margin: 100px auto;
      width: 370px;
      height: 410px;
      background: white;
      border-radius: 3px;
  }
  .login:before {
      content: '';
      position: absolute;
      top: -8px;
      right: -8px;
      bottom: -8px;
      left: -8px;
      z-index: -1;
      background: rgba(255, 255, 255, 0.1);
      border-radius: 4px;
  }
  .login h1 {
      line-height: 55px;
      font-size: 24px;
      font-weight: bold;
      font-family: 'Open Sans', sans-serif;
      text-transform: uppercase;
      color: #fff;
      text-align: center;
      background: #1abc9c;
      border-top-left-radius: 3px;
      border-top-right-radius: 3px;
  }
  .login .submit {
      text-align: center;
  }
  .login.button {
      text-align: center;
  }
  .login p:first-child {
      margin-top: 30px;
  }
  .login p .remember {
      float: left;
  }
  .login p .remember label {
      color: #a7a599;
      font-size: 12px;
      cursor: pointer;
  }
  .login p .forgot {
      float: right;
      margin-right: 50px;
  }
  .login p .forgot a {
      color: #a7a599;
      font-size: 12px;
      text-decoration: none;
      font-style: italic;
      transition: all 0.3s ease-out;
  }
  .login p .forgot a:hover {
      color: #f2672e;
  }

  /*input style*/
  /* === Input Form === */
  ::-webkit-input-placeholder {
      color: #ded9cf;
      font-family: 'Open Sans';
  }

  :-moz-placeholder {
      color: #ded9cf !important;
      font-family: 'Open Sans';
  }

  .form input[type=text], input[type=password] {
      font-family: 'Open Sans', Calibri, Arial, sans-serif;
      font-size: 14px;
      font-weight: 400;
      padding: 10px 15px 10px 55px;
      position: relative;
      width: 200px;
      height: 24px;
      color: #676056;
      border: none;
      background: #f7f3eb;
      color: #777;
      transition: color 0.3s ease-out;
  }

  .form input[type=text] {
      margin-bottom: 15px;
  }

  .form input[type=text]:hover ~ i,
  .form input[type=password]:hover ~ i {
      color: #27ae60;
  }

  .form input[type=text]:focus ~ i,
  .form input[type=password]:focus ~ i {
      color: #27ae60;
  }

  .form input[type=text]:focus,
  .form input[type=password]:focus,
  .form button[type=submit]:focus {
      outline: none;
  }

  .form input[type=submit] {
      margin-top: 15px;
      width: 270px;
      text-align: center;
      font-size: 14px;
      font-family: 'Open Sans',sans-serif;
      font-weight: bold;
      padding: 12px 0;
      letter-spacing: 0;
      box-shadow: inset 0px 0px 0px 0px #1abc9c;
      color: #fff;
      background-color: #16a085;
      text-shadow: none;
      text-transform: uppercase;
      border: none;
      cursor: pointer;
      position: relative;
      margin-bottom: 20px;
      -webkit-animation: shadowFadeOut 0.4s;
      -moz-animation: shadowFadeOut 0.4s;
  }
  .form button[type=button]:focus {
      outline: none;
  }

  .form input[type=button] {
      margin-top: 15px;
      width: 270px;
      text-align: center;
      font-size: 14px;
      font-family: 'Open Sans',sans-serif;
      font-weight: bold;
      padding: 12px 0;
      letter-spacing: 0;
      box-shadow: inset 0px 0px 0px 0px #1abc9c;
      color: #fff;
      background-color: #16a085;
      text-shadow: none;
      text-transform: uppercase;
      border: none;
      cursor: pointer;
      position: relative;
      margin-bottom: 20px;
      -webkit-animation: shadowFadeOut 0.4s;
      -moz-animation: shadowFadeOut 0.4s;
  }

  .form input[type=submit]:hover, input[type=submit]:focus {
      color: #fff;
      box-shadow: inset 0px 46px 0px 0px #1abc9c;
      -webkit-animation: shadowFade 0.4s;
      -moz-animation: shadowFade 0.4s;
  }
  .form input[type=button]:hover, input[type=button]:focus {
      color: #fff;
      box-shadow: inset 0px 46px 0px 0px #1abc9c;
      -webkit-animation: shadowFade 0.4s;
      -moz-animation: shadowFade 0.4s;
  }

  /*keyframes for input animation*/
  @keyframes shadowFade {
      0% {
        box-shadow: inset 0px 0px 0px 0px #1abc9c;
        color: #fff;
    }
    100% {
        box-shadow: inset 0px 46px 0px 0px #1abc9c;
        color: #fff;
    }
}
@keyframes shadowFadeOut {
  0% {
    box-shadow: inset 0px 46px 0px 0px #1abc9c;
    color: #fff;
}
100% {
    box-shadow: inset 0px 0px 0px 0px #1abc9c;
    color: #fff;
}
}
@-webkit-keyframes shadowFade {
  0% {
    box-shadow: inset 0px 0px 0px 0px #1abc9c;
    color: #fff;
}
100% {
    box-shadow: inset 0px 46px 0px 0px #1abc9c;
    color: #fff;
}
}
@-webkit-keyframes shadowFadeOut {
  0% {
    box-shadow: inset 0px 46px 0px 0px #1abc9c;
    color: #fff;
}
100% {
    box-shadow: inset 0px 0px 0px 0px #1abc9c;
    color: #fff;
}
}
@-moz-keyframes shadowFade {
  0% {
    box-shadow: inset 0px 0px 0px 0px #1abc9c;
    color: #fff;
}
100% {
    box-shadow: inset 0px 46px 0px 0px #1abc9c;
    color: #fff;
}
}
@-moz-keyframes shadowFadeOut {
  0% {
    box-shadow: inset 0px 44px 0px 0px #1abc9c;
    color: #fff;
}
100% {
    box-shadow: inset 0px 0px 0px 0px #1abc9c;
    color: #fff;
}
}
/*continued styling for input */
.form input[type="checkbox"] {
  display: none;
}

.form input[type="checkbox"] + label span {
    display:inline-block;
    width:16px;
    height:16px;
    margin: -2px 4px 0 50px;
    vertical-align:middle;
    background:url("../img/checkbox.png") left top no-repeat;
    cursor:pointer;
}
.form input[type="checkbox"]:checked + label span {
    background:url("../img/checkbox.png") -16px top no-repeat;
}
/* === Copyright === */
.copyright {
  margin-top: 30px;
  text-align: center;
}
.copyright p, .copyright a {
  color: #828078;
  font-size: 12px;
  text-decoration: none;
  transition: color 0.3s ease-out;
}
.copyright p a:hover, .copyright a a:hover {
  color: #f2672e;
}
</style>
</html>