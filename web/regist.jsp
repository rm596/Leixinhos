<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2"/>
    <head>
        <title>Registo</title>

        <link rel="stylesheet" type="text/css" href="loginCSS/bootstrap-combined.min.css">
        <link rel="stylesheet" type="text/css" href="loginCSS/extra.css">

        <link rel="stylesheet" type="text/css" href="loginCSS/base.css">
        <link rel="stylesheet" type="text/css" href="loginCSS/layout2.css">

        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-latest.js"></script>
        <script type="text/javascript" src="js/parsley-standalone.min.js"></script>
        <script type="text/javascript" src="js/messages.pt_br.js"></script>

    </head>
    <body>

        <div class="container">
            <div class="form-bg">

                <form action="<c:url value='regist'/>" method="post" class="form-horizontal" data-validate="parsley">
                    <h2>Registo</h2>


                    <p>
                        <input type="text" name="nome" data-required="true" data-trigger="change" placeholder="Nome" data-rangelength="[5,30]"/>
                    </p>


                    <p>
                        <input type="text" name="email" data-type="email" data-required="true" data-trigger="change" placeholder="Email" data-rangelength="[5,30]"/>
                    </p>

                    <p>
                        <input type="text" name="morada" data-trigger="change" placeholder="Morada" data-rangelength="[5,30]"/>
                    </p>

                    <p>
                        <input type="text" name="phone" data-type="digits" data-rangelength="[9,9]" data-trigger="change" placeholder="Telemóvel" data-type="digits"/>
                    </p>

                    <p>
                        <input type="text" name="username" data-required="true" data-trigger="change" placeholder="Username" data-rangelength="[5,10]"  data-type="alphanum"/>
                    </p>

                    <p>
                        <input type="password" name="password" data-required="true" data-trigger="change" placeholder="Password" data-rangelength="[5,10]" data-type="alphanum"/>
                    </p>

                    <p>
                        <input type="text" name="grupoPRO" data-required="true" data-trigger="change" placeholder="Grupo" data-rangelength="[4,30]" data-type="alphanum"/>
                    </p>

                    <p>
                        <input type="text" name="dataFIM" data-type="dateIso" data-required="true" data-trigger="change" placeholder="Data Fim AAAA-MM-DD" />
                    </p>

                    <button type="submit" class="btn" class="btn1">Registar</button>

                </form>
            </div>
            <p class="forgot">Já possuí conta? <a href="login">Clique aqui para fazer Login no Sistema.</a></p>
        </div>
    </body>
</html>

<%
    if (request.getAttribute("usernameREGISTADO") == "1" && request.getAttribute("emailREGISTADO") == "0") {
%>
<script>

    alert("Username já Registado, por favor outro!");

</script>
<%                                } else if (request.getAttribute("usernameREGISTADO") == "0" && request.getAttribute("emailREGISTADO") == "1") {
%>
<script>

    alert("Email já Registado, por favor outro!");

</script>
<%                                } else if (request.getAttribute("usernameREGISTADO") == "1" && request.getAttribute("emailREGISTADO") == "1") {
%>
<script>

    alert("Username e Email já Registado, por favor outro!");

</script>
<%                                }
%>