<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2"/>
    <head>
        <title>Login</title>

        <link rel="stylesheet" type="text/css" href="loginCSS/bootstrap-combined.min.css">
        <link rel="stylesheet" type="text/css" href="loginCSS/extra.css">

        <link rel="stylesheet" type="text/css" href="loginCSS/base.css">
        <link rel="stylesheet" type="text/css" href="loginCSS/layout.css">

        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-latest.js"></script>
        <script type="text/javascript" src="js/parsley-standalone.min.js"></script>
        <script type="text/javascript" src="js/messages.pt_br.js"></script>

    </head>
    <body>

        <div class="container">
            <div class="form-bg">

                <form action="<c:url value='index'/>" method="post" class="form-horizontal" data-validate="parsley">
                    <h2>Login</h2>


                    <p>
                        <input type="text" name="username" data-required="true" data-trigger="change" placeholder="Username" data-rangelength="[5,10]"  data-type="alphanum"/>
                    </p>

                    <p>
                        <input type="password" name="password" data-required="true" data-trigger="change" placeholder="Password" data-rangelength="[5,10]" data-type="alphanum"/>
                    </p>

                    <button type="submit" class="btn">Login</button>
                </form>
                <% if (request.getAttribute("error") == "1") { %>
                <script>
                    alert("Login Incorrecto!");
                </script>
                <% } else if (request.getAttribute("sucesso") == "1") { %>
                <script>
                    alert("Password Recuperada com Sucesso \n\nVerifique Email");
                </script>
               <% } %>
            </div>
            <p class="forgot">Ainda năo se encontra registado? <a href="regist">Clique aqui para se registar no Sistema.</a>
                <br>Perdeu a sua Password? <a href="recover">Clique aqui para a Recuperar.</a></p>
        </div>
    </body>
</html>

