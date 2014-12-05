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

                <form action="<c:url value='recover'/>" method="post" class="form-horizontal" data-validate="parsley">
                    <h2>Recuperar Password</h2>


                    <p>
                        <input type="text" name="email" data-type="email" data-required="true" data-trigger="change" placeholder="Email" data-rangelength="[5,30]"/>
                    </p>

                    <button type="submit" class="btn" style="left:-28px;">Recuperar</button>
                </form>
                <%   if (request.getAttribute("sucesso") == "0") {
                %>
                <script>
                    alert("Email năo encontrado na Base Dados\n\nRegiste-se!!");
                </script>
                <%                    }
                %>

            </div>
            <p class="forgot"><a href="login">Clique aqui para fazer Login.</a></p>
        </div>
    </body>
</html>

