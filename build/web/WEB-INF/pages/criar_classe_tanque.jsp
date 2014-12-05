<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<img style="float: left; vertical-align: middle; margin: 0 10px 0 0; width: 95px; height: 81px;" src="images/tanque2.png" alt="manutenção" /><h1 style="margin: 15px 0 0 0;">Inserir nova classe de tanque</h1>

<br> <br>
<!--
<h2></h2>
-->
<form id="checkoutForm" action="<c:url value='criar_classe_tanque'/>" method="post" data-validate="parsley">
    <div class="form_settings">
        <p><span>Nome:</span><input type="text" name="nome" data-required="true" data-trigger="change" data-rangelength="[1,3]"></p>
        <br>
        <p>
            <span>Descrição:</span>
            <textarea rows="5" cols="50" name="descricao" data-rangelength="[0,50]" style="width:300px; max-width: 590px; height:150px; max-height: 250px"></textarea>
        </p>
        <p style="padding-top: 15px">
            <span>&nbsp;</span>
            <input class="submit" type="submit" name="criar" value="Criar" />
        </p>
    </div>
</form>

    <%
    if (request.getAttribute("ClasseTanqueINSERIDO") == "1") {
%>
<script>

    alert("Classe de tanque inserida com sucesso!");

</script>
<%                                }
%>
    
